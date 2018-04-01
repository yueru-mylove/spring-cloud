package com.miracle.cloud.controler;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ClientController {


    @Value("${profile}")
    private String profile;

    @Value("${context-path}")
    private String context_path;


    @GetMapping("/profile")
    public String getProfile() {
        return this.profile + this.context_path;
    }
}
