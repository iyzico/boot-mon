package com.iyzico.bootmon.server.service.core;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.iyzico.bootmon.server.dto.shared.BootmonClient;

import java.io.IOException;
import java.util.Optional;

public interface BootmonClientService {

    void saveBootmonClient(BootmonClient bootmonClient) throws JsonProcessingException;

    Optional<BootmonClient> findBootmonClienByIp(String ip) throws IOException;

}
