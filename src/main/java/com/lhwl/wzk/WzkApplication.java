package com.lhwl.wzk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class WzkApplication {

    public static void main(String[] args) {
        SpringApplication.run(WzkApplication.class, args);
    }

}
