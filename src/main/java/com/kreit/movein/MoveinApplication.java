package com.kreit.movein;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MoveinApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoveinApplication.class, args);
    }
}
