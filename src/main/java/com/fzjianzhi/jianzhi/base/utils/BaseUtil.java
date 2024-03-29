package com.fzjianzhi.jianzhi.base.utils;


import com.fzjianzhi.jianzhi.base.system.user.SystemAdmin;
import com.fzjianzhi.jianzhi.base.system.user.SystemCurrentUser;
import com.fzjianzhi.jianzhi.base.system.user.SystemUser;
import com.fzjianzhi.jianzhi.wx.user.WxCurrentUser;
import com.fzjianzhi.jianzhi.wx.user.WxUser;
import com.fzjianzhi.jianzhi.wx.user.WxUserDao;
import com.fzjianzhi.jianzhi.wx.utils.vo.WxSessionVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * BaseUtil
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/9
 */
@Slf4j
@Component
public class BaseUtil {

    @Resource
    private SystemCurrentUser systemCurrentUser;

    @Resource
    private WxCurrentUser wxCurrentUser;

    @Resource
    private WxUserDao wxUserDao;

    @Resource
    private SystemAdmin systemAdmin;

    private boolean isAdmin;
    private boolean isSystemUser;
    private boolean isWxUser;

    public void saveCurrentUser(SystemUser user) {
        log.info("currentUser: " + user.toString());
        systemCurrentUser.setSystemCurrentUser(user);
        isAdmin = isWxUser = false;
        isSystemUser = true;
    }

    public void setAdmin(SystemAdmin admin) {
        log.info("currentUser: " + admin.toString());
        systemCurrentUser.setSystemCurrentUser(admin);
        isWxUser = isSystemUser = false;
        isAdmin = true;
    }

    public SystemCurrentUser getSystemCurrentUser() {
        return systemCurrentUser;
    }

    public void setWxCurrentUser(WxSessionVo wxSessionVo) {
        log.info("currentUser: ", wxSessionVo.toString());
        wxCurrentUser.setWxOpenId(wxSessionVo.getOpenid());
        wxCurrentUser.setWxSessionKey(wxSessionVo.getSession_key());
        WxUser wxUser = wxUserDao.findByOpenId(wxSessionVo.getOpenid());
        if (wxUser != null) {
            wxCurrentUser.setId(wxUser.getId());
            wxCurrentUser.setWxUser(wxUser);
        }
        isAdmin = isSystemUser = false;
        isWxUser = true;
    }

    public SystemAdmin getSystemAdmin() {
        return systemAdmin;
    }

    public WxCurrentUser getWxCurrentUser() {
        return wxCurrentUser;
    }

    public boolean currentUserIsAdmin() {
        return isAdmin;
    }

    public boolean currentUserIsSystemUser() {
        return isSystemUser;
    }

    public boolean currentUserIsWxUser() {
        return isWxUser;
    }
}
