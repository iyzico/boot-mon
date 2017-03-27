package com.iyzico.bootmon.server.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BootmonServerProperties {

    @Value("${boot-mon-server.security.enabled:false}")
    private boolean securityEnabled;

    @Value("${boot-mon-server.security.userName:changeIt}")
    private String serverUserName;

    @Value("${boot-mon-server.security.password:changeIt}")
    private String serverPassword;

    public boolean isSecurityEnabled() {
        return securityEnabled;
    }

    public void setSecurityEnabled(boolean securityEnabled) {
        this.securityEnabled = securityEnabled;
    }

    public String getServerUserName() {
        return serverUserName;
    }

    public void setServerUserName(String serverUserName) {
        this.serverUserName = serverUserName;
    }

    public String getServerPassword() {
        return serverPassword;
    }

    public void setServerPassword(String serverPassword) {
        this.serverPassword = serverPassword;
    }
}
