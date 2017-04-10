package com.iyzico.bootmon.server.registration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Optional;

@Repository
public class BootmonClientRedisRepository implements BootmonClientRepository {

    private static final String KEY_PREFIX = "bootmon-client:%s";

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void save(BootmonClient bootmonClient) {
        String key = String.format(KEY_PREFIX, bootmonClient.getName());
        try {
            redisTemplate.opsForValue().set(key, objectMapper.writeValueAsString(bootmonClient));
        } catch (JsonProcessingException e) {
            throw new BootmonRequestNotValidException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<BootmonClient> findByName(String name) {
        final String KEY = String.format(KEY_PREFIX, name);
        String value = (String) redisTemplate.opsForValue().get(KEY);
        if (StringUtils.isNotBlank(value)) {
            try {
                return Optional.of(objectMapper.readValue(value, BootmonClient.class));
            } catch (IOException e) {
                throw new BootmonRequestNotValidException(e.getMessage(), e);
            }
        }
        return Optional.empty();
    }
}
