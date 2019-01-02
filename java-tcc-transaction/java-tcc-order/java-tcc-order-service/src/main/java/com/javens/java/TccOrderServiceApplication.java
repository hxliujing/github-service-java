/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.javens.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author liujing01
 * @version TccCallerServiceApplication.java, v 0.1 2018-12-30 16:45 
 */
@SpringBootApplication
@ComponentScan("com.javens.java.*")
public class TccOrderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(TccOrderServiceApplication.class, args);
    }
}
