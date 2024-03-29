package com.fzjianzhi.jianzhi.base.system.role;


import com.fzjianzhi.jianzhi.base.annotation.SystemUserAuth;
import com.fzjianzhi.jianzhi.base.mvc.BaseController;
import com.fzjianzhi.jianzhi.base.result.Result;
import com.fzjianzhi.jianzhi.base.system.config.SystemResource;
import com.fzjianzhi.jianzhi.base.system.config.SystemResourceClass;
import org.springframework.web.bind.annotation.*;

/**
 * SystemRoleController
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/11
 */
@RestController
@RequestMapping("/system/role")
@SystemResourceClass(resourceName = "systemRole", comment = "系统角色管理", parentResource = "system")
public class SystemRoleController extends BaseController<SystemRoleService, SystemRoleEntity, Long> {

    @SystemUserAuth
    @PostMapping("/resource")
    @SystemResource(comment = "给角色添加一个系统资源")
    public Result addOneResource(@RequestParam Long roleId, @RequestParam Long resourceId) {
        baseService.addResource(roleId, resourceId);
        return Result.success();
    }

    @SystemUserAuth
    @DeleteMapping("/resource")
    @SystemResource(comment = "给角色删除一个系统资源")
    public Result removeOneResource(@RequestParam Long roleId, @RequestParam Long resourceId) {
        baseService.deleteResource(roleId, resourceId);
        return Result.success();
    }
}
