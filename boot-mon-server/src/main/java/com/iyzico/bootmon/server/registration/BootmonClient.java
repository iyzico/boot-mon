package com.iyzico.bootmon.server.registration;

import org.springframework.hateoas.ResourceSupport;

public class BootmonClient extends ResourceSupport {

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
