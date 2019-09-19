package com.fzjianzhi.jianzhi.base.system.dict;


import com.fzjianzhi.jianzhi.base.mvc.BaseController;
import com.fzjianzhi.jianzhi.base.system.config.SystemResourceClass;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SystemDictController
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/18
 */
@RestController
@RequestMapping("/system/dict")
@SystemResourceClass(resourceName = "systemDict", comment = "系统字典管理", parentResource = "system")
public class SystemDictController extends BaseController<SystemDictService, SystemDictEntity, Long> {
}
