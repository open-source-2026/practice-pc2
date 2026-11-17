package com.platform.practicepc2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Bootstrap class for the Practice PC2 application.
 *
 * <p>Initializes Spring Boot auto-configuration and JPA auditing infrastructure.</p>
 */
@EnableJpaAuditing
@SpringBootApplication
public class PracticePc2Application {

    public static void main(String[] args) {

        SpringApplication.run(PracticePc2Application.class, args);

        System.out.println("App running on port 8080");

    }

}
