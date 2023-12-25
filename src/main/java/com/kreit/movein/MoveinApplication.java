package com.kreit.movein;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@EnableJpaAuditing
public class MoveinApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoveinApplication.class, args);
    }

    @GetMapping("/health")
    public String healthCheck(){
        return "OK";
    }
}
