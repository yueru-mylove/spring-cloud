package com;

import com.miracle.cloud.annotation.ExecludeComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
@ComponentScan(excludeFilters =  {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExecludeComponentScan.class)})
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        RestTemplate template = new RestTemplate();
        SimpleClientHttpRequestFactory factory = (SimpleClientHttpRequestFactory) template.getRequestFactory();
        factory.setConnectTimeout(30000);
        factory.setReadTimeout(10000);
        return template;
    }
}
