package com.fzjianzhi.jianzhi.b2c.controller;

import com.fzjianzhi.jianzhi.b2c.entity.Task;
import com.fzjianzhi.jianzhi.b2c.service.TaskService;
import com.fzjianzhi.jianzhi.base.mvc.BaseController;
import com.fzjianzhi.jianzhi.base.system.config.SystemConfig;
import com.fzjianzhi.jianzhi.base.system.config.SystemResourceClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TaskController
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/17
 */

@Slf4j
@Validated
@RestController
@RequestMapping("/task")
@SystemResourceClass(resourceName = "task", comment = "task",
    parentResource = SystemConfig.DEFAULT_RESOURCE_PARENT_CODE)
public class TaskController extends BaseController<TaskService, Task, Long> {

}
