package com.szentebalint.helloworld.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/test")
    public String teszt() {
        return "test";
    }

    @GetMapping("/error")
    public String error() {
        return "Valami nem oke";
    } 

}
