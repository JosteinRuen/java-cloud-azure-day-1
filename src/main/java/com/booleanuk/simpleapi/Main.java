package com.booleanuk.simpleapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.booleanuk.simpleapi"})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}