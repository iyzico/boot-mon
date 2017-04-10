package com.iyzico.bootmon.client.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "bootmon.server")
public class BootmonServerProperties {

    /**
     * Boot-mon server api url
     */
    private String url;

    /**
     * Boot-mon server HTTP Basic Authentication user name
     */
    @Value("${userName:changeIt}")
    private String userName;

    /**
     * Boot-mon server HTTP Basic Authentication password
     */
    @Value("${password:changeIt}")
    private String password;

    /**
     * Time interval (in ms) the registration is repeated
     */
    private long registrationRefreshPeriod = 10000L;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getRegistrationRefreshPeriod() {
        return registrationRefreshPeriod;
    }

    public void setRegistrationRefreshPeriod(long registrationRefreshPeriod) {
        this.registrationRefreshPeriod = registrationRefreshPeriod;
    }
}
