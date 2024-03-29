package com.fzjianzhi.jianzhi.b2c.controller;

import com.fzjianzhi.jianzhi.b2c.entity.Like;
import com.fzjianzhi.jianzhi.b2c.service.LikeService;
import com.fzjianzhi.jianzhi.base.mvc.BaseController;
import com.fzjianzhi.jianzhi.base.system.config.SystemConfig;
import com.fzjianzhi.jianzhi.base.system.config.SystemResourceClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * LikeController
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/17
 */

@Slf4j
@Validated
@RestController
@RequestMapping("/like")
@SystemResourceClass(resourceName = "like", comment = "like",
    parentResource = SystemConfig.DEFAULT_RESOURCE_PARENT_CODE)
public class LikeController extends BaseController<LikeService, Like, Long> {

}
