package com.fzjianzhi.jianzhi.base.config;


import com.fzjianzhi.jianzhi.base.interceptor.AuthenticationInterceptor;
import com.fzjianzhi.jianzhi.base.interceptor.ParamNotBlankInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * InterceptorConfig
 * 配置处理token、NotNull
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/4/25
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor());
        registry.addInterceptor(notNullInterceptor())
                .addPathPatterns("/**");
    }

    @Bean
    public AuthenticationInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor();
    }

    @Bean
    public ParamNotBlankInterceptor notNullInterceptor() {
        return new ParamNotBlankInterceptor();
    }
}
