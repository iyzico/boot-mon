package com.iyzico.bootmon.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BootmonClientServiceImpl implements BootmonClientService{
    @Autowired
    private BootmonClientRepository _bootmonClientRepository;


    public void saveBootmonClient(BootmonClient bootmonClient) {
        _bootmonClientRepository.saveBootmonClient(bootmonClient);
    }

    @Override
    public BootmonClient findBootmonClient(String name) {
        return _bootmonClientRepository.findBootmonClient(name);
    }

}
