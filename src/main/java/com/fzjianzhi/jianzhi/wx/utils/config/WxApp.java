package com.fzjianzhi.jianzhi.wx.utils.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * WxApp
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/14
 */
@Data
@Component
@EnableConfigurationProperties(WxApp.class)
@ConfigurationProperties(prefix = "humor.wx")
public class WxApp {

    private String appId;
    private String appSecret;
}
