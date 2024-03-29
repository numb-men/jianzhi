package com.fzjianzhi.jianzhi.base.system.user;


import com.fzjianzhi.jianzhi.base.annotation.PassAuth;
import com.fzjianzhi.jianzhi.base.annotation.SystemUserAuth;
import com.fzjianzhi.jianzhi.base.mvc.BaseController;
import com.fzjianzhi.jianzhi.base.result.Result;
import com.fzjianzhi.jianzhi.base.system.config.SystemResource;
import com.fzjianzhi.jianzhi.base.system.config.SystemResourceClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * SystemUserController
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/10
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/system/user")
@SystemResourceClass(resourceName = "systemUser", comment = "系统用户管理", parentResource = "system")
public class SystemUserController extends BaseController<SystemUserService, SystemUser, Long> {
    
    @PassAuth
    @PostMapping("/login")
    @SystemResource(comment = "系统用户登录")
    public Result login(@Valid SystemUserDto systemUserDto) {
        return Result.success(baseService.login(systemUserDto));
    }

    @SystemUserAuth
    @PostMapping("/role")
    @SystemResource(comment = "给用户添加一个系统角色")
    public Result addOneRole(@RequestParam Long userId, @RequestParam Long roleId) {
        baseService.addRole(userId, roleId);
        return Result.success();
    }

    @SystemUserAuth
    @DeleteMapping("/role")
    @SystemResource(comment = "给用户删除一个系统角色")
    public Result removeOneRole(@RequestParam Long userId, @RequestParam Long roleId) {
        baseService.deleteRole(userId, roleId);
        return Result.success();
    }
}
