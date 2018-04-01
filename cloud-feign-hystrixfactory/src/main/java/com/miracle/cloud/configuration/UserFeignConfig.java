package com.miracle.cloud.configuration;

import feign.Logger;
import feign.Retryer;
import org.apache.tomcat.jni.Time;
import org.springframework.context.annotation.Bean;

public class UserFeignConfig {

    @Bean
    public Logger.Level logger() {
        return Logger.Level.FULL;
    }

}
