/**
 * fshows.com
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package com.javens.java.conf;

import org.mengyun.tcctransaction.repository.RedisTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Tcc事务配置
 * @author liujing01
 * @version SpringTccConfig.java, v 0.1 2019-01-02 18:23 
 */
@Configuration
public class SpringTccConfig {
    @Autowired
    private SysConfig sysConfig;


    @Bean(name = "transactionRepository")
    public RedisTransactionRepository getTransactionRepository(){
        RedisTransactionRepository repository = new RedisTransactionRepository();
        repository.setKeyPrefix("tcc_ut_");
        repository.setJedisPool(getJedisPool());
        return repository;
    }

    private redis.clients.jedis.JedisPool getJedisPool() {
        JedisPool jedisPool = new JedisPool(getJedisPoolConfig(),sysConfig.getRedisHost(),sysConfig.getRedisPort(),1000);
        return jedisPool;
    }

    private JedisPoolConfig  getJedisPoolConfig(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(1000);
        config.setMaxWaitMillis(1000);
        return config;
    }

}
