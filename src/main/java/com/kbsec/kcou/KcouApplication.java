package com.kbsec.kcou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class KcouApplication {

    public static void main(String[] args) {
        SpringApplication.run(KcouApplication.class, args);
    }

}
