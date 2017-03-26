package com.iyzico.bootmon.server;


import java.util.Map;

public interface BootmonClientRepository {
    void saveBootmonClient(BootmonClient bootmonClient);

    void updateBootmonClient(BootmonClient bootmonClient);

    BootmonClient findBootmonClient(String name);

    Map<Object, Object> findAllBootmonClients();

    void deleteBootmonClient(String name);
}
