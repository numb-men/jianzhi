package com.fzjianzhi.jianzhi.b2c.controller;

import com.fzjianzhi.jianzhi.b2c.entity.UserMessage;
import com.fzjianzhi.jianzhi.b2c.service.UserMessageService;
import com.fzjianzhi.jianzhi.base.mvc.BaseController;
import com.fzjianzhi.jianzhi.base.system.config.SystemConfig;
import com.fzjianzhi.jianzhi.base.system.config.SystemResourceClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserMessageController
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/17
 */

@Slf4j
@Validated
@RestController
@RequestMapping("/user/message")
@SystemResourceClass(resourceName = "userMessage", comment = "user message",
    parentResource = SystemConfig.DEFAULT_RESOURCE_PARENT_CODE)
public class UserMessageController extends BaseController<UserMessageService, UserMessage, Long> {

}
