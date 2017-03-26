package com.iyzico.bootmon.server;


public interface BootmonClientService {
    void saveBootmonClient(BootmonClient bootmonClient);

    BootmonClient findBootmonClient(String name);
}
