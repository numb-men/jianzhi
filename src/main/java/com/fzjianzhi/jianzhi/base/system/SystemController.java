package com.fzjianzhi.jianzhi.base.system;


import com.fzjianzhi.jianzhi.base.annotation.SystemAdminAuth;
import com.fzjianzhi.jianzhi.base.result.Result;
import com.fzjianzhi.jianzhi.base.system.config.SystemConfig;
import com.fzjianzhi.jianzhi.base.system.config.SystemResource;
import com.fzjianzhi.jianzhi.base.system.config.SystemResourceClass;
import com.fzjianzhi.jianzhi.base.system.dict.SystemDictService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * SystemController
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/10
 */
@RestController
@RequestMapping("/system")
@SystemResourceClass(resourceName = "system", comment = "系统管理",
        parentResource = SystemConfig.DEFAULT_RESOURCE_PARENT_CODE)
public class SystemController {

    @Resource
    private SystemService systemService;


    @SystemAdminAuth
    @GetMapping("/resource/create")
    @SystemResource(name = "systemResourceCreate", comment = "生成系统资源配置", code = "system.resource.create")
    public Result createResources(HttpServletRequest request) {
        systemService.createResources(request);
        return Result.success();
    }

    @SystemAdminAuth
    @GetMapping("/dict/create")
    @SystemResource(name = "systemDictCreate", comment = "生成系统字典", code = "system.dict.create")
    public Result createDict() {
        systemService.createDict();
        return Result.success();
    }
}
