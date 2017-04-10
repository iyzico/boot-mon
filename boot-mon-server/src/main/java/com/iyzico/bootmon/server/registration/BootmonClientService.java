package com.iyzico.bootmon.server.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BootmonClientService {

    @Autowired
    BootmonClientRequestValidator bootmonClientRequestValidator;

    @Autowired
    BootmonClientRepository bootmonClientRepository;

    public void saveBootmonClient(BootmonClient bootmonClient) {
        bootmonClientRequestValidator.validate(bootmonClient);
        bootmonClientRepository.save(bootmonClient);
    }

    public BootmonClient findBootmonClientByName(String name) {
        bootmonClientRequestValidator.validateName(name);
        Optional<BootmonClient> bootmonClient = bootmonClientRepository.findByName(name);
        if (bootmonClient.isPresent()) {
            return bootmonClient.get();
        } else {
            throw new BootmonNotFoundException("Bootmon client not found with the given name.");
        }
    }
}
