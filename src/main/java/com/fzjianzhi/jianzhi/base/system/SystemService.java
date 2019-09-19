package com.fzjianzhi.jianzhi.base.system;


import com.fzjianzhi.jianzhi.base.system.config.SystemConfig;
import com.fzjianzhi.jianzhi.base.system.dict.SystemDictService;
import com.fzjianzhi.jianzhi.base.system.resource.SystemResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * SystemService
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/10
 */
@Service
@Slf4j
public class SystemService implements SystemConfig {

    @Resource
    private SystemResourceService systemResourceService;

    @Resource
    private SystemDictService systemDictService;


    public void createResources(HttpServletRequest request) {
        systemResourceService.createResources(request);
    }

    public void createDict() {
        systemDictService.createDict();
    }
}
