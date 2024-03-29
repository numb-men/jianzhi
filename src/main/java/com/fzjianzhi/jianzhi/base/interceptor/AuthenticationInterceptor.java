package com.fzjianzhi.jianzhi.base.interceptor;


import com.fzjianzhi.jianzhi.base.annotation.PassAuth;
import com.fzjianzhi.jianzhi.base.annotation.SystemAdminAuth;
import com.fzjianzhi.jianzhi.base.annotation.SystemUserAuth;
import com.fzjianzhi.jianzhi.base.cache.EhcacheCache;
import com.fzjianzhi.jianzhi.base.exception.common.BaseException;
import com.fzjianzhi.jianzhi.base.exception.enums.BaseResultEnum;
import com.fzjianzhi.jianzhi.base.system.resource.SystemResourceEntity;
import com.fzjianzhi.jianzhi.base.system.resource.SystemResourceService;
import com.fzjianzhi.jianzhi.base.system.role.SystemRoleEntity;
import com.fzjianzhi.jianzhi.base.system.user.SystemAdmin;
import com.fzjianzhi.jianzhi.base.system.user.SystemUser;
import com.fzjianzhi.jianzhi.base.system.user.SystemUserService;
import com.fzjianzhi.jianzhi.base.utils.BaseUtil;
import com.fzjianzhi.jianzhi.base.utils.CastUtil;
import com.fzjianzhi.jianzhi.base.utils.TokenUtil;
import com.fzjianzhi.jianzhi.wx.base.WxUserAuth;
import com.fzjianzhi.jianzhi.wx.utils.vo.WxSessionVo;
import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * AuthenticationInterceptor
 * 全局处理token
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/4/25
 */
@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Resource
    private SystemUserService systemUserService;

    @Resource
    private SystemResourceService systemResourceService;

    @Resource
    private SystemAdmin systemAdmin;

    @Resource
    private BaseUtil baseUtil;

    private boolean isAdmin;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object){

        EhcacheCache.showCache();

        String token = httpServletRequest.getHeader("token");
        if (token == null) {
            token = (String) httpServletRequest.getAttribute("token");
        }

        // todo file、page resource auth
        if (! (object instanceof HandlerMethod)) {
            tryGetUser(token);
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        isAdmin = TokenUtil.tryCheckAdmin(systemAdmin, token);

        if (method.isAnnotationPresent(PassAuth.class)) {
            PassAuth passAuth = method.getAnnotation(PassAuth.class);
            if (passAuth.required()) {
                tryGetSystemUser(isAdmin, token);
                return true;
            }
        }
        if (method.isAnnotationPresent(WxUserAuth.class)) {
            WxUserAuth wxUserAuth = method.getAnnotation(WxUserAuth.class);
            if (wxUserAuth.required()) {
                return checkWxUserOrSystemUser(httpServletRequest, token);
            }
        }
        if (method.isAnnotationPresent(SystemUserAuth.class)) {
            SystemUserAuth systemUserAuth = method.getAnnotation(SystemUserAuth.class);
            if (systemUserAuth.required()) {
                return checkSystemUser(httpServletRequest, token);
            }
        }
        if (method.isAnnotationPresent(SystemAdminAuth.class)) {
            SystemAdminAuth systemAdminAuth = method.getAnnotation(SystemAdminAuth.class);
            if (systemAdminAuth.required()) {
                return checkSystemAdmin(token);
            }
        }

        tryGetSystemUser(isAdmin, token);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object o, Exception e) {
    }

    private boolean checkSystemUser(HttpServletRequest request, String token) {
        if (isAdmin) {
            baseUtil.setAdmin(systemAdmin);
            return true;
        }
        SystemUser user = getUserFromToken(token);
        if (TokenUtil.verifyToken(token, user.getPassword())) {
            checkPower(user, request);
            baseUtil.saveCurrentUser(user);
            return true;
        }
        return false;
    }

    private boolean checkSystemAdmin(String token) {
        if (isAdmin) {
            baseUtil.setAdmin(systemAdmin);
            return true;
        }
        if (! TokenUtil.checkAdmin(systemAdmin, token)){
            throw new BaseException(BaseResultEnum.NOT_POWER);
        }
        else {
            baseUtil.setAdmin(systemAdmin);
            return true;
        }
    }

    private boolean checkWxUserOrSystemUser(HttpServletRequest request, String token) {
        if (isAdmin) {
            baseUtil.setAdmin(systemAdmin);
            return true;
        }
        if (token == null) {
            throw new BaseException(BaseResultEnum.NOT_LOGIN);
        }
        String key;
        try {
            key = JWT.decode(token).getAudience().get(0);
        }
        catch (JWTDecodeException e) {
            throw new BaseException(BaseResultEnum.TOKEN_CHECK_FAILED);
        }
        // wxUser
        WxSessionVo wxSessionVo =
                (WxSessionVo) EhcacheCache.getValue("wxSessionCache", key);
        if (wxSessionVo != null) {
            if (TokenUtil.verifyToken(token, wxSessionVo.getSession_key())) {
                baseUtil.setWxCurrentUser(wxSessionVo);
                return true;
            }
            else {
                throw new BaseException(BaseResultEnum.TOKEN_CHECK_FAILED);
            }
        }
        // systemUser
        Long userId;
        try {
            userId = Long.valueOf(key);
        }
        catch (NumberFormatException e) {
            throw new BaseException(BaseResultEnum.TOKEN_CHECK_FAILED);
        }
        SystemUser user = systemUserService.findOne(userId).orElse(null);
        if (user == null) {
            throw new BaseException(BaseResultEnum.USER_NOT_FIND);
        }
        else {
            if (TokenUtil.verifyToken(token, user.getPassword())) {
                checkPower(user, request);
                baseUtil.saveCurrentUser(user);
                return true;
            }
        }
        return false;
    }

    private void tryGetSystemUser(boolean isAdmin, String token) {
        if (isAdmin) {
            baseUtil.setAdmin(systemAdmin);
        }
        else {
            tryGetUser(token);
        }
    }

    // 防止controller未加权限注解时无法获取到用户
    private void tryGetUser(String token) {
        if (token == null) {
            return;
        }
        Long userId;
        try {
            userId = Long.valueOf(JWT.decode(token).getAudience().get(0));
        }
        catch (JWTDecodeException | NumberFormatException e) {
            return;
        }
        systemUserService.findOne(userId).ifPresent(
            user -> baseUtil.saveCurrentUser(user)
        );
    }

    private SystemUser getUserFromToken(String token) {
        if (token == null) {
            throw new BaseException(BaseResultEnum.NOT_LOGIN);
        }
        Long userId;
        try {
            userId = Long.valueOf(JWT.decode(token).getAudience().get(0));
        }
        catch (JWTDecodeException | NumberFormatException e) {
            throw new BaseException(BaseResultEnum.TOKEN_CHECK_FAILED);
        }
        SystemUser user = systemUserService.findOne(userId).orElse(null);
        if (user == null) {
            throw new BaseException(BaseResultEnum.USER_NOT_FIND);
        }
        return user;
    }

    private void checkPower(SystemUser systemUser, HttpServletRequest request) {
        List<SystemResourceEntity> systemResourcesMatched = getSystemResourceMatched(request);
        if (systemResourcesMatched == null) {
            log.warn(request.getServletPath() + " not match any resource");
            return;
        }
        List<SystemResourceEntity> systemUserPowerResource = getSystemUserPowerResource(systemUser);
        for (SystemResourceEntity userPowerResource : systemUserPowerResource) {
            for (SystemResourceEntity resourceEntity : systemResourcesMatched) {
                if (userPowerResource.getId().equals(resourceEntity.getId())) {
                    return;
                }
            }
        }
        throw new BaseException(BaseResultEnum.NOT_POWER);
    }


    private List<SystemResourceEntity> getSystemUserPowerResource(SystemUser systemUser) {
        List<SystemResourceEntity> systemUserPowerResource = new ArrayList<>();
        List<SystemRoleEntity> roles = systemUser.getRoles();
        for (SystemRoleEntity role : roles) {
            List<SystemResourceEntity> resourceEntities = role.getResources();
            systemUserPowerResource.addAll(resourceEntities);
        }
        return systemUserPowerResource;
    }

    private List<SystemResourceEntity> getSystemResourceMatched(HttpServletRequest request) {
        String urlForMatch = request.getServletPath();
        String methodForMatch = request.getMethod();
        // find in cache todo test
        Object object = EhcacheCache.getValue("urlResourceMappingCache", urlForMatch);
        if (object != null) {
            List<SystemResourceEntity> resourceEntitiesInCache;
            try {
                resourceEntitiesInCache =  CastUtil.castList(object, SystemResourceEntity.class);
                return resourceEntitiesInCache;
            }
            catch (ClassCastException e){
                throw new BaseException(e.getMessage());
            }
        }
        PathMatcher pathMatcher = new AntPathMatcher();
        List<SystemResourceEntity> systemResourceEntities =
                systemResourceService.getSystemResourceEntities();
        SystemResourceEntity baseSystemResourceEntity = null;
        for (SystemResourceEntity systemResourceEntity : systemResourceEntities) {
            String url = systemResourceEntity.getUrl();
            String method = systemResourceEntity.getMethod();
            String[] urls = getStrings(url);
            String[] methods = getStrings(method);
            if (methods.length > 0 && urls.length > 0) {
                for (String u : urls) {
                    if (pathMatcher.match(u, urlForMatch)) {
                        for (String m : methods) {
                            if (m.equals(methodForMatch)) {
                                baseSystemResourceEntity = systemResourceEntity;
                                break;
                            }
                        }
                    }
                }
            }
        }
        if (baseSystemResourceEntity != null) {
            List<SystemResourceEntity> resourceEntities = new ArrayList<>();
            resourceEntities.add(baseSystemResourceEntity);
            int i = 0;
            while (i < resourceEntities.size()) {
                SystemResourceEntity resourceEntity = resourceEntities.get(i);
                for (SystemResourceEntity sr : systemResourceEntities) {
                    if (resourceEntity.getParentId().equals(sr.getId())) {
                        resourceEntities.add(sr);
                    }
                }
                i++;
            }
            EhcacheCache.setValue(
                    "urlResourceMappingCache", urlForMatch, resourceEntities);
            return resourceEntities;
        }

        return null;
    }

    private String[] getStrings(String s) {
        String[] ss = new String[0];
        if (! s.equals("")) {
            s = s.substring(1, s.length() - 1);
            ss = s.split(", ");
        }
        return ss;
    }
}
