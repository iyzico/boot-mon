package com.iyzico.bootmon.server;


import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

public interface BootmonClientRepository {
    void saveBootmonClient(BootmonClient bootmonClient) throws JsonProcessingException;

    BootmonClient findBootmonClientByIp(String ip) throws IOException;
}
