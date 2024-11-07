package com.inditext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class IndiTestApplication {

    public static void main(String[] args) {
        SpringApplication.run( IndiTestApplication.class, args); }
}
