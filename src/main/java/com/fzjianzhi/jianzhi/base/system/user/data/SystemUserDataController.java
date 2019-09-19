package com.fzjianzhi.jianzhi.base.system.user.data;

import com.fzjianzhi.jianzhi.base.mvc.BaseController;
import com.fzjianzhi.jianzhi.base.system.config.SystemResourceClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SystemUserDataController
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/19
 */
@Slf4j
@RestController
@RequestMapping("/system/user/data")
@SystemResourceClass(resourceName = "systemUserData", comment = "系统用户资料管理", parentResource = "system")
public class SystemUserDataController extends BaseController<SystemUserDataService, SystemUserData, Long> {
}
