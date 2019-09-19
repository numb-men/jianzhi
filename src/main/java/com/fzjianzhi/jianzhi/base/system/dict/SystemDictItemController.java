package com.fzjianzhi.jianzhi.base.system.dict;

import com.fzjianzhi.jianzhi.base.mvc.BaseController;
import com.fzjianzhi.jianzhi.base.system.config.SystemResourceClass;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SystemDictItemController
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/18
 */
@RestController
@RequestMapping("/system/dict/item")
@SystemResourceClass(resourceName = "systemDictItem", comment = "系统字典项管理", parentResource = "systemDict")
public class SystemDictItemController extends BaseController<SystemDictItemService, SystemDictItemEntity, Long> {
}
