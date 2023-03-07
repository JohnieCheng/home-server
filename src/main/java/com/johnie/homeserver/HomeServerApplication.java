package com.johnie.homeserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing //启用审计(Auditing)功能
@EnableJpaRepositories
public class HomeServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeServerApplication.class, args);
    }

}