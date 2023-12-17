package com.kreit.movein.config;

import com.kreit.movein.auth.AgentUserJwtFilter;
import com.kreit.movein.auth.AppUserJwtFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<AppUserJwtFilter> validateAppUserTokenFilter() {
        FilterRegistrationBean<AppUserJwtFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new AppUserJwtFilter());
        registrationBean.addUrlPatterns("/app-user-api/*");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<AgentUserJwtFilter> validateAgentUserTokenFilter() {
        FilterRegistrationBean<AgentUserJwtFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new AgentUserJwtFilter());
        registrationBean.addUrlPatterns("/agent-api/*");
        return registrationBean;
    }
}

