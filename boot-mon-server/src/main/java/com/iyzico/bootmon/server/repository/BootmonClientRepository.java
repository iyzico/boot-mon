package com.iyzico.bootmon.server.repository;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.iyzico.bootmon.server.dto.shared.BootmonClient;

import java.io.IOException;
import java.util.Optional;

public interface BootmonClientRepository {
    void saveBootmonClient(BootmonClient bootmonClient) throws JsonProcessingException;

    Optional<BootmonClient> findBootmonClientByIp(String ip) throws IOException;
}
