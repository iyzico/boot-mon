package com.iyzico.bootmon.server;

import com.iyzico.bootmon.server.config.RedisConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationTest.class)
@ContextConfiguration(classes = RedisConfig.class)
public class BootmonClientServiceTest {
    @Autowired
    BootmonClientServiceImpl bootmonClientService;


    @Test
    public void should_redis_save_sucessfully() {
        BootmonClient bootmonClient = new BootmonClient();
        bootmonClient.setName("boot");
        bootmonClient.setIp("127.0.0.1");
        bootmonClient.setHealthCheckPath("/healht");
        bootmonClient.setPort("8080");
        bootmonClientService.saveBootmonClient(bootmonClient);
        BootmonClient bootmonClient1Actual = bootmonClientService.findBootmonClient(bootmonClient.getName());
        assertThat(bootmonClient1Actual.getName()).isEqualTo(bootmonClient.getName());
        assertThat(bootmonClient1Actual.getIp()).isEqualTo(bootmonClient.getIp());
        assertThat(bootmonClient1Actual.getPort()).isEqualTo(bootmonClient.getPort());
        assertThat(bootmonClient1Actual.getHealthCheckPath()).isEqualTo(bootmonClient.getHealthCheckPath());
    }
}
