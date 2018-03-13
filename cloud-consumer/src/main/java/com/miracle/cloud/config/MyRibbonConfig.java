package com.miracle.cloud.config;

import com.miracle.cloud.annotation.ExecludeComponentScan;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义Ribbon负载均衡策略
 *
 * FooConfiguration必须是@Configuration，但请注意，它不在主应用程序上下文的@ComponentScan中，
 * 否则将由所有@RibbonClients共享。如果您使用@ComponentScan（或@SpringBootApplication），
 * 则需要采取措施避免包含（例如将其放在一个单独的，不重叠的包中，或者指定要在@ComponentScan）。
 *
 */
@Configuration
@RibbonClient(name = "cloud-consumer", configuration = MyRibbonConfig.class)
@ExecludeComponentScan
public class MyRibbonConfig {

    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }


}
