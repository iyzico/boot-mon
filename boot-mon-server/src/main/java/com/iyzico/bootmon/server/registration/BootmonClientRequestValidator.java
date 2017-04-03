package com.iyzico.bootmon.server.registration;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class BootmonClientRequestValidator {

    public void validate(BootmonClient bootmonClient) {
        if (bootmonClient == null) {
            throw new BootmonRequestNotValidException("Client can not be null!");
        }
        this.validateName(bootmonClient.getName());

        if (StringUtils.isEmpty(bootmonClient.getManagementUrl())) {
            throw new BootmonRequestNotValidException("Client management url can not be empty!");
        }
        if (StringUtils.isEmpty(bootmonClient.getHealthCheckUrl())) {
            throw new BootmonRequestNotValidException("Client health check url can not be empty!");
        }
    }

    public void validateName(String bootmonClientName) {
        if (StringUtils.isEmpty(bootmonClientName)) {
            throw new BootmonRequestNotValidException("Client name can not be empty!");
        }
    }
}
