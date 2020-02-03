package com.avis.instantjob.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class InstantJobRestController {

    @Value("${my.greeting}")
    private String greeting_message;

    @GetMapping("/greeting")
    public String greeting() {
        return greeting_message;
    }
}
