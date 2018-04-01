package com.miracle.cloud.config;

import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

public class FeignEurekaConfiguration {

    /**
     * 禁用按个FeignClient的Hystrix支持；细粒度支持
     * 原因：默认FeignClient时开启Hystrix支持的；其配置的Builder时HystrixBuilder，此处更改了配置为FeignBuilder
     * @return
     */
    @Bean
    @Scope
    public Feign.Builder feignBuilder() {
        return new Feign.Builder();
    }


    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("root", "123456");
    }
}
