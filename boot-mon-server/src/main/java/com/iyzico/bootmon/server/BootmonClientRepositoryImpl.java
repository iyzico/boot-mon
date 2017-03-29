package com.iyzico.bootmon.server;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Optional;

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

    public Optional<BootmonClient> findBootmonClientByIp(String ip) throws IOException {
        final String KEY = String.format(KEY_PREFIX, ip);
        String value = (String) redisTemplate.opsForValue().get(KEY);
        if (StringUtils.isNotBlank(value)) {
            return Optional.of(objectMapper.readValue(value, BootmonClient.class));
        }
        return Optional.empty();
    }
}
