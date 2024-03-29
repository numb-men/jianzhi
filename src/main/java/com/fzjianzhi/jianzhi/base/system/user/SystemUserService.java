package com.fzjianzhi.jianzhi.base.system.user;


import com.fzjianzhi.jianzhi.base.exception.common.BaseException;
import com.fzjianzhi.jianzhi.base.exception.enums.BaseResultEnum;
import com.fzjianzhi.jianzhi.base.mvc.BaseService;
import com.fzjianzhi.jianzhi.base.system.exception.common.SystemException;
import com.fzjianzhi.jianzhi.base.system.exception.enums.SystemResultEnum;
import com.fzjianzhi.jianzhi.base.system.role.SystemRoleDao;
import com.fzjianzhi.jianzhi.base.system.role.SystemRoleEntity;
import com.fzjianzhi.jianzhi.base.utils.TokenUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * SystemUserService
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/10
 */
@Service
public class SystemUserService extends BaseService<SystemUser, Long> {

    @Resource
    private SystemUserDao systemUserDao;

    @Resource
    private SystemRoleDao systemRoleDao;

    @Resource
    private SystemAdmin systemAdmin;

    private SystemUser systemUser;
    private SystemRoleEntity systemRoleEntity;


    public String login(SystemUserDto systemUserDto) {
        String token = adminLogin(systemUserDto);
        if (token != null) {
            return token;
        }
        SystemUser user = systemUserDao.findByName(systemUserDto.getName());
        if (user == null) {
            throw new BaseException(BaseResultEnum.NOT_USER);
        }
        if (! user.getPassword().equals(systemUserDto.getPassword())) {
            throw new BaseException(BaseResultEnum.PASSWORD_ERROR);
        }
        return TokenUtil.createToken(user.getId(), user.getPassword());
    }

    private String adminLogin(SystemUserDto systemUserDto) {
        if (systemUserDto.getName().equals(systemAdmin.getName()) &&
            systemUserDto.getPassword().equals(systemAdmin.getPassword())) {
            return TokenUtil.createAdminToken(systemUserDto.getName(), systemUserDto.getPassword());
        }
        return null;
    }

    public void addRole(Long userId, Long roleId) {
        setSystemUser(userId, roleId);
        systemUser.getRoles().add(systemRoleEntity);
        save(systemUser);
    }

    public void deleteRole(Long userId, Long roleId) {
        setSystemUser(userId, roleId);
        systemUser.getRoles().remove(systemRoleEntity);
        save(systemUser);
    }

    private void setSystemUser(Long userId, Long roleId) {
        systemUser = findOne(userId).orElse(null);
        if (systemUser == null) {
            throw new SystemException(SystemResultEnum.USER_NOT_FOUND);
        }
        systemRoleEntity = systemRoleDao.findById(roleId).orElse(null);
        if (systemRoleEntity == null) {
            throw new SystemException(SystemResultEnum.ROLE_NOT_FOUND);
        }
    }
}
