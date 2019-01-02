/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.javens.java.conf;

import com.fshows.fsframework.extend.redis.RedisCache;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.mengyun.tcctransaction.repository.RedisTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

/**
 * @author yangdw
 * @version SpringRedisConfig.java, v 0.1 2018-10-12 17:29 yangdw
 */
@Configuration
public class TccConfig {
    @Autowired
    private SysConfig sysConfig;
    private JedisPool getJedisPool(){
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxTotal(1000);
        poolConfig.setMaxWaitMillis(1000);
        return new JedisPool(poolConfig, sysConfig.getRedisHost(),sysConfig.getRedisPort(),1000);
    }

    @Bean
    public RedisTransactionRepository getTransactionRepository(){
        RedisTransactionRepository repository = new RedisTransactionRepository();
        repository.setKeyPrefix("tcc_ut_");
        repository.setJedisPool(getJedisPool());
        return repository;
    }
}