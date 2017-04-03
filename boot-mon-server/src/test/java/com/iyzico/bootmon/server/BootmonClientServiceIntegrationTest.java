package com.iyzico.bootmon.server;

import com.iyzico.bootmon.server.registration.BootmonClient;
import com.iyzico.bootmon.server.registration.BootmonClientService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.embedded.RedisServer;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationTest.class)
public class BootmonClientServiceIntegrationTest {

    @Autowired
    BootmonClientService bootmonClientService;

    RedisServer redisServer;

    @Before
    public void setUp() throws IOException {
        redisServer = new RedisServer();
        redisServer.start();
    }

    @Test
    public void should_redis_save_sucessfully() throws IOException {
        BootmonClient bootmonClient = new BootmonClient();
        bootmonClient.setName("myClient");
        bootmonClient.setManagementUrl("http://myhost/management");
        bootmonClient.setHealthCheckUrl("http://myhost/health");
        bootmonClientService.saveBootmonClient(bootmonClient);
        BootmonClient bootmonClientActual = bootmonClientService.findBootmonClienByName(bootmonClient.getName());
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
