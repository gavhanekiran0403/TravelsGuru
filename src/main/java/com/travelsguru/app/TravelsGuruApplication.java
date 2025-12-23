package com.travelsguru.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(
    exclude = { UserDetailsServiceAutoConfiguration.class }
)
public class TravelsGuruApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravelsGuruApplication.class, args);
    }
}
