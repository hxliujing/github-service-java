/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.javens.java.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author liujing01
 * @version HelloController.java, v 0.1 2018-10-10 19:36 
 */
@RestController
public class HelloController {
    @RequestMapping("/")
    public String index() {
        return "design-pipline-handler from Spring Boot!";
    }
}
