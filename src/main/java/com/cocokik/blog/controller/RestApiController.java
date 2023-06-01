package com.cocokik.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiController {
    @GetMapping("/home")
    public String home(){
        return "<H1>Home</H1>";
    }

}


