package com.fzjianzhi.jianzhi.b2c.controller;

import com.fzjianzhi.jianzhi.b2c.entity.PartTimeJob;
import com.fzjianzhi.jianzhi.b2c.service.PartTimeJobService;
import com.fzjianzhi.jianzhi.base.mvc.BaseController;
import com.fzjianzhi.jianzhi.base.system.config.SystemConfig;
import com.fzjianzhi.jianzhi.base.system.config.SystemResourceClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PartTimeJobController
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/17
 */

@Slf4j
@Validated
@RestController
@RequestMapping("/part/time/job")
@SystemResourceClass(resourceName = "partTimeJob", comment = "part time job",
    parentResource = SystemConfig.DEFAULT_RESOURCE_PARENT_CODE)
public class PartTimeJobController extends BaseController<PartTimeJobService, PartTimeJob, Long> {

}
