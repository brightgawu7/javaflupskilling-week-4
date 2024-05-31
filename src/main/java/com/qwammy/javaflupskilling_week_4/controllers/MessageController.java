package com.qwammy.javaflupskilling_week_4.controllers;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Tag(name = "Message Controller")
public class MessageController {

    @Value("${hello.message}")
    private String message;

    @GetMapping("/hello")
    public String hello() {
        return message;
    }
}
