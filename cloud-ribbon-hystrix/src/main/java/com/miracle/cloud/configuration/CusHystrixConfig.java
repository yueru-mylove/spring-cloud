package com.miracle.cloud.configuration;


import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixThreadPoolKey;

public class CusHystrixConfig extends HystrixCommand {


    protected CusHystrixConfig(Setter setter) {
        super(setter);
    }

    @Override
    protected Object run() throws Exception {
        return "test";
    }
}
