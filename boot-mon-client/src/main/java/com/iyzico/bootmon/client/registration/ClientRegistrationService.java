package com.iyzico.bootmon.client.registration;

import com.iyzico.bootmon.client.configuration.BootmonClientProperties;
import com.iyzico.bootmon.client.configuration.BootmonServerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ClientRegistrationService {

    @Autowired
    BootmonClientProperties bootmonClientProperties;

    @Autowired
    BootmonServerProperties bootmonServerProperties;

    @PostConstruct
    public void register(){
    }
}
