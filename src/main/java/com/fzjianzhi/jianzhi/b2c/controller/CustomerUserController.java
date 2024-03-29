package com.fzjianzhi.jianzhi.b2c.controller;

import com.fzjianzhi.jianzhi.b2c.entity.CustomerUser;
import com.fzjianzhi.jianzhi.b2c.service.CustomerUserService;
import com.fzjianzhi.jianzhi.base.mvc.BaseController;
import com.fzjianzhi.jianzhi.base.system.config.SystemConfig;
import com.fzjianzhi.jianzhi.base.system.config.SystemResourceClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CustomerUserController
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/16
 */

@Slf4j
@Validated
@RestController
@RequestMapping("/b2c/customer/user")
@SystemResourceClass(resourceName = "customerUser", comment = "客户",
        parentResource = SystemConfig.DEFAULT_RESOURCE_PARENT_CODE)
public class CustomerUserController extends BaseController<CustomerUserService, CustomerUser, Long> {
}
