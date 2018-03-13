package com.miracle.cloud.config;

import feign.Contract;
import feign.Logger;
import feign.Retryer;
import org.apache.tomcat.jni.Time;
import org.springframework.cloud.netflix.feign.AnnotatedParameterProcessor;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.cloud.netflix.feign.support.SpringMvcContract;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.ConversionService;

import java.util.ArrayList;
import java.util.List;

public class CustomizedFeignConfiguration {

    @Bean
    Logger.Level createLogLevel() {

        return Logger.Level.FULL;
    }


    @Bean
    public Retryer retryer() {
        return new Retryer.Default(100, Time.sec(1), 5);
    }
}
