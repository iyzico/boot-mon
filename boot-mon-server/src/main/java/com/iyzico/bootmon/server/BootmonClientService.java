package com.iyzico.bootmon.server;


import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

public interface BootmonClientService {
    void saveBootmonClient(BootmonClient bootmonClient) throws JsonProcessingException;

    BootmonClient findBootmonClienByIp(String ip) throws IOException;

}
