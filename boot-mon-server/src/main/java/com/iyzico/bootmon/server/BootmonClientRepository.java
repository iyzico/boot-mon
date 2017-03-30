package com.iyzico.bootmon.server;


import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.util.Optional;

public interface BootmonClientRepository {
    void saveBootmonClient(BootmonClient bootmonClient) throws JsonProcessingException;

    Optional<BootmonClient> findBootmonClientByIp(String ip) throws IOException;
}
