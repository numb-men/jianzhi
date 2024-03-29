package com.fzjianzhi.jianzhi.b2c.controller;

import com.fzjianzhi.jianzhi.b2c.entity.RankAward;
import com.fzjianzhi.jianzhi.b2c.service.RankAwardService;
import com.fzjianzhi.jianzhi.base.mvc.BaseController;
import com.fzjianzhi.jianzhi.base.system.config.SystemConfig;
import com.fzjianzhi.jianzhi.base.system.config.SystemResourceClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RankAwardController
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/17
 */

@Slf4j
@Validated
@RestController
@RequestMapping("/rank/award")
@SystemResourceClass(resourceName = "rankAward", comment = "rank award",
    parentResource = SystemConfig.DEFAULT_RESOURCE_PARENT_CODE)
public class RankAwardController extends BaseController<RankAwardService, RankAward, Long> {

}
