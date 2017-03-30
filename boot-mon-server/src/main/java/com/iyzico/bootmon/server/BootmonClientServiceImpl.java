package com.iyzico.bootmon.server;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class BootmonClientServiceImpl implements BootmonClientService {
    @Autowired
    private BootmonClientRepository bootmonClientRepository;


    public void saveBootmonClient(BootmonClient bootmonClient) throws JsonProcessingException {
        bootmonClientRepository.saveBootmonClient(bootmonClient);
    }



    public Optional<BootmonClient> findBootmonClienByIp(String ip) throws IOException {
        return bootmonClientRepository.findBootmonClientByIp(ip);
    }
}
