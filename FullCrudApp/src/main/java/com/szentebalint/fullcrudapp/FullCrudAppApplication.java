package com.szentebalint.fullcrudapp;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FullCrudAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(FullCrudAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(ApplicationArguments args){

        return runner -> System.out.println("Hello World");

    }

}
