package com.iyzico.bootmon.server.registration;

import com.iyzico.bootmon.server.IntegrationTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import redis.embedded.RedisServer;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class BootmonClientServiceIT extends IntegrationTest {

    @Autowired
    BootmonClientService bootmonClientService;

    RedisServer redisServer;

    @Before
    public void setUp() throws IOException {
        redisServer = new RedisServer();
        redisServer.start();
    }

    @Test
    public void should_persist_bootmon_client_to_redis() throws IOException {
        //given a bootmon client
        BootmonClient bootmonClient = new BootmonClient();
        bootmonClient.setName("myClient");
        bootmonClient.setManagementUrl("http://myhost/management");
        bootmonClient.setHealthCheckUrl("http://myhost/health");

        //when
        bootmonClientService.saveBootmonClient(bootmonClient);
        BootmonClient bootmonClientActual = bootmonClientService.findBootmonClientByName(bootmonClient.getName());

        //then
        assertThat(bootmonClientActual).isNotNull();
        assertThat(bootmonClientActual.getName()).isEqualTo(bootmonClient.getName());
        assertThat(bootmonClientActual.getManagementUrl()).isEqualTo(bootmonClient.getManagementUrl());
        assertThat(bootmonClientActual.getHealthCheckUrl()).isEqualTo(bootmonClient.getHealthCheckUrl());
    }

    @After
    public void tearDown() throws Exception {
        redisServer.stop();
    }
}
