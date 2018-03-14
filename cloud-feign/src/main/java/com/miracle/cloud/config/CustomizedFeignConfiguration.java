package com.miracle.cloud.config;

import feign.Contract;
import feign.Logger;
import feign.Retryer;
import org.apache.tomcat.jni.Time;
import org.springframework.context.annotation.Bean;
import java.util.Scanner;

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
