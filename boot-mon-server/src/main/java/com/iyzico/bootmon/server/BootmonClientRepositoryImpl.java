package com.iyzico.bootmon.server;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class BootmonClientRepositoryImpl implements BootmonClientRepository {

    private String KEY_PREFIX = "bootmon-client:%s";

    @Autowired
    private RedisTemplate redisTemplate;


    @Autowired
    private ObjectMapper objectMapper;


    public void saveBootmonClient(BootmonClient bootmonClient) throws JsonProcessingException {
        final String KEY = String.format(KEY_PREFIX, bootmonClient.getIp());
        redisTemplate.opsForValue().set(KEY, objectMapper.writeValueAsString(bootmonClient));
    }

    public BootmonClient findBootmonClientByIp(String ip) throws IOException {
        final String KEY = String.format(KEY_PREFIX, ip);
        return objectMapper.readValue(((String) redisTemplate.opsForValue().get(KEY)).getBytes(), BootmonClient.class);
    }
}
