package com.iyzico.bootmon.server;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;

@Repository
public class BootmonClientRepositoryImpl implements BootmonClientRepository {
    private static final String KEY = "BootmonClient";
    @Autowired
    private RedisTemplate redisTemplate;
    private HashOperations hashOps;


    @PostConstruct
    private void init() {
        hashOps = redisTemplate.opsForHash();
    }

    public void saveBootmonClient(BootmonClient bootmonClient) {
        hashOps.put(KEY, bootmonClient.getName(), bootmonClient);
    }

    public void updateBootmonClient(BootmonClient bootmonClient) {
        hashOps.put(KEY, bootmonClient.getName(), bootmonClient);
    }

    public BootmonClient findBootmonClient(String name) {
        return (BootmonClient) hashOps.get(KEY, name);
    }

    public Map<Object, Object> findAllBootmonClients() {
        return hashOps.entries(KEY);
    }

    public void deleteBootmonClient(String name) {
        hashOps.delete(KEY, name);
    }

}
