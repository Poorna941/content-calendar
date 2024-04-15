package com.abc.contentcalendar.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

// CommandLineRunner runs after dependency Injection is run.
@Profile("!dev")
@Component
public class DataLoader implements CommandLineRunner {

    @Override
    public void run(String... args) {
        System.out.println("Hello Spring Boot");
    }
}
