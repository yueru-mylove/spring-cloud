package com.miracle.cloud.controller;

import com.miracle.cloud.feign.FooClient;
import feign.Client;
import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RestController;

// @Import(FeignClientsConfiguration.class)
public class FooController {

    /**
     * 使用Spring的默认配置
     */
    private FooClient fooClient;

    private FooClient adminClient;

    @Autowired
    public FooController(Decoder decoder, Encoder encoder, Client client) {
        this.fooClient = Feign.builder().client(client).encoder(encoder).decoder(decoder)
                .requestInterceptor(new BasicAuthRequestInterceptor("root", "123456"))
                .target(FooClient.class, "http://cloud-product2");

        this.adminClient = Feign.builder().client(client).encoder(encoder).decoder(decoder)
                .requestInterceptor(new BasicAuthRequestInterceptor("root", "123456"))
                .target(FooClient.class, "httpL//cloud-product2");
    }
}
