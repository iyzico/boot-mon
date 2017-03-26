package com.iyzico.bootmon.server;

import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;

public class BootmonClient extends ResourceSupport implements Serializable{

    private String name;
    private String ip;
    private String port;
    private String healthCheckPath;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getHealthCheckPath() {
        return healthCheckPath;
    }

    public void setHealthCheckPath(String healthCheckPath) {
        this.healthCheckPath = healthCheckPath;
    }
}
