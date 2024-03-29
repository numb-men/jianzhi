package com.fzjianzhi.jianzhi.base.system.resource;


import com.fzjianzhi.jianzhi.base.mvc.BaseController;
import com.fzjianzhi.jianzhi.base.system.config.SystemResourceClass;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SystemResourceController
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/11
 */
@RestController
@RequestMapping("/system/resource")
@SystemResourceClass(resourceName = "systemResource", comment = "系统资源管理", parentResource = "system")
public class SystemResourceController extends BaseController<SystemResourceService, SystemResourceEntity, Long> {
}
