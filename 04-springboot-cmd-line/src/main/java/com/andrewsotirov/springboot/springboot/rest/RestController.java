package com.andrewsotirov.springboot.springboot.rest;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World asdasd ";
    }
    @GetMapping("/workout")
    public String workout() {
        return "Workout asdas";
    }
}
