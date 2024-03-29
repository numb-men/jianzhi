package com.fzjianzhi.jianzhi.b2c.controller;

import com.fzjianzhi.jianzhi.b2c.entity.B2cBaseUser;
import com.fzjianzhi.jianzhi.b2c.service.B2cBaseUserService;
import com.fzjianzhi.jianzhi.base.mvc.BaseController;
import com.fzjianzhi.jianzhi.base.system.config.SystemConfig;
import com.fzjianzhi.jianzhi.base.system.config.SystemResourceClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * B2cBaseUserController
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/16
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/b2c/base/user")
@SystemResourceClass(resourceName = "b2cBaseUser", comment = "b2c基本用户",
        parentResource = SystemConfig.DEFAULT_RESOURCE_PARENT_CODE)
public class B2cBaseUserController extends BaseController<B2cBaseUserService, B2cBaseUser, Long> {
}
