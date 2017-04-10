package com.iyzico.bootmon.client.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "bootmon.client")
public class BootmonClientProperties {

    /**
     * Client application name to register with. Default is spring.application.name.
     */
    @Value("${spring.application.name:spring-boot-application}")
    private String name;

    private String managementUrl;

    private String healthCheckUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagementUrl() {
        return managementUrl;
    }

    public void setManagementUrl(String managementUrl) {
        this.managementUrl = managementUrl;
    }

    public String getHealthCheckUrl() {
        return healthCheckUrl;
    }

    public void setHealthCheckUrl(String healthCheckUrl) {
        this.healthCheckUrl = healthCheckUrl;
    }
}
