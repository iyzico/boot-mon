package com.iyzico.bootmon.server;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.embedded.RedisServer;

import java.io.IOException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationTest.class)
public class BootmonClientServiceIntegrationTest {

    @Autowired
    BootmonClientServiceImpl bootmonClientService;

    RedisServer redisServer;

    @Before
    public void setUp() throws IOException {
        redisServer = new RedisServer();
        redisServer.start();
    }

    @Test
    public void should_redis_save_sucessfully() throws IOException {
        BootmonClient bootmonClient = new BootmonClient();
        bootmonClient.setName("boot");
        bootmonClient.setIp("127.0.0.1");
        bootmonClient.setHealthCheckPath("/healthy");
        bootmonClient.setPort("8080");
        bootmonClientService.saveBootmonClient(bootmonClient);
        Optional<BootmonClient> optionalBootmonClientActual = bootmonClientService.findBootmonClienByIp(bootmonClient.getIp());
        assertThat(optionalBootmonClientActual.isPresent()).isTrue();
        BootmonClient bootmonClientActual = optionalBootmonClientActual.get();
        assertThat(bootmonClientActual.getName()).isEqualTo(bootmonClient.getName());
        assertThat(bootmonClientActual.getIp()).isEqualTo(bootmonClient.getIp());
        assertThat(bootmonClientActual.getPort()).isEqualTo(bootmonClient.getPort());
        assertThat(bootmonClientActual.getHealthCheckPath()).isEqualTo(bootmonClient.getHealthCheckPath());
    }

    @After
    public void tearDown() throws Exception {
        redisServer.stop();
    }
}
