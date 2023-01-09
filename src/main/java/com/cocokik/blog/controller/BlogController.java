package com.cocokik.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class BlogController {
    @GetMapping("/")
    public String Hello(){
        return "<h1>String Value</h1>";
    }
}
