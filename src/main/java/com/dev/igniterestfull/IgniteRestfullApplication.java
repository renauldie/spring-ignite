package com.dev.igniterestfull;

import org.apache.ignite.springdata.repository.config.EnableIgniteRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableIgniteRepositories
public class IgniteRestfullApplication {

    public static void main(String[] args) {
        SpringApplication.run(IgniteRestfullApplication.class, args);
    }

}
