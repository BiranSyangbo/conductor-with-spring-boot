package com.demo.conductor.workflow;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties
@ConfigurationProperties("conductor")
@Data
public class ConductorServerConfig {

    private String serverUrl;
    private String clientKeyId;
    private String clientSecret;

}
