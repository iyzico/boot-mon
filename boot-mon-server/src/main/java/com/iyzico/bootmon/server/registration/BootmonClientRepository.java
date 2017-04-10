package com.iyzico.bootmon.server.registration;

import java.util.Optional;

public interface BootmonClientRepository {

    void save(BootmonClient bootmonClient);

    Optional<BootmonClient> findByName(String name);
}
