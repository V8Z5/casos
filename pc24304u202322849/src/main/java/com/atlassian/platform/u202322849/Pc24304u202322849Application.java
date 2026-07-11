package com.atlassian.platform.u202322849;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Application entry point for the Atlassian access requests API.
 *
 * @author Marlon Packard Viza Quispe
 */
@EnableJpaAuditing
@SpringBootApplication
public class Pc24304u202322849Application {

    public static void main(String[] args) {
        SpringApplication.run(Pc24304u202322849Application.class, args);
    }
}
