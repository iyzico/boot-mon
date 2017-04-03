package com.iyzico.bootmon.server.registration;

import com.iyzico.bootmon.server.IntegrationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class BootmonClientControllerIT extends IntegrationTest {

    @Autowired
    BootmonClientController bootmonClientController;

    @Test
    public void should_create_bootmon_client() {
        //given bootmon client
        BootmonClient bootmonClient = new BootmonClient();
        bootmonClient.setName("myClient");
        bootmonClient.setManagementUrl("http://myhost/management");
        bootmonClient.setHealthCheckUrl("http://myhost/health");

        //when
        HttpEntity<BootmonClient> response = bootmonClientController.create(bootmonClient);

        //then
        assertThat(response.getBody().getHealthCheckUrl()).isEqualTo("http://myhost/health");
    }
}
