package com.javens.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.javens.java")
public class TccApplication {
    public static void main( String[] args ) {
        SpringApplication.run(TccApplication.class, args);
    }
}
