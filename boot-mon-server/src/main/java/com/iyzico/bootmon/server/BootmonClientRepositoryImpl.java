package com.iyzico.bootmon.server;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Repository
public class BootmonClientRepositoryImpl implements BootmonClientRepository {
    private static final String KEY = "bootmon-client:myclient";
    @Autowired
    private RedisTemplate redisTemplate;
    private HashOperations hashOps;

    @PostConstruct
    private void init() {
        hashOps = redisTemplate.opsForHash();
    }

    public void saveBootmonClient(BootmonClient bootmonClient) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        hashOps.put(KEY, bootmonClient.getName(), objectMapper.writeValueAsString(bootmonClient));
    }

    public BootmonClient findBootmonClient(String name) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(((String) hashOps.get(KEY, name)).getBytes(), BootmonClient.class);
    }
}
