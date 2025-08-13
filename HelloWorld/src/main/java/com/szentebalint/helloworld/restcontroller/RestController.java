package com.szentebalint.helloworld.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World";
    }

}
