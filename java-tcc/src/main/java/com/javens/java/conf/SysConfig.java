/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.javens.java.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author wujn
 * @version SysConfig.java, v 0.1 2018-07-20 16:27
 */
@Configuration
public class SysConfig {


    /*********************redis 配置*******************/
    @Value("${redis.host}")
    private String redisHost;
    @Value("${redis.port}")
    private int redisPort;
    @Value("${redis.password}")
    private String redisPassword;
    @Value("${redis.connect.timeout}")
    private Integer redisConnectTimeout;


    /**
     * Getter method for property <tt>redisHost</tt>.
     *
     * @return property value of redisHost
     */
    public String getRedisHost() {
        return redisHost;
    }

    /**
     * Getter method for property <tt>redisPort</tt>.
     *
     * @return property value of redisPort
     */
    public int getRedisPort() {
        return redisPort;
    }

    /**
     * Getter method for property <tt>redisPassword</tt>.
     *
     * @return property value of redisPassword
     */
    public String getRedisPassword() {
        return redisPassword;
    }

    /**
     * Getter method for property <tt>redisConnectTimeout</tt>.
     *
     * @return property value of redisConnectTimeout
     */
    public Integer getRedisConnectTimeout() {
        return redisConnectTimeout;
    }
}
