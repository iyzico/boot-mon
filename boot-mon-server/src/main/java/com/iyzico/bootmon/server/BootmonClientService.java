package com.iyzico.bootmon.server;


import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.util.Optional;

public interface BootmonClientService {
    void saveBootmonClient(BootmonClient bootmonClient) throws JsonProcessingException;

    Optional<BootmonClient> findBootmonClienByIp(String ip) throws IOException;

}
