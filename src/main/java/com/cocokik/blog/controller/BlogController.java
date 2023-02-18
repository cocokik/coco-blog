package com.cocokik.blog.controller;

import com.cocokik.blog.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@Controller
public class BlogController {
    @GetMapping("/user/aboutForm")
    public String aboutMe(){
        return "user/aboutForm";
    }

//    @GetMapping("/test")
//    public String jTest(Member m){
//        System.out.println(m.getId());
//        System.out.println("test start");
//        return "test.html";
//    }
//    @GetMapping("/aa/bb")
//    public String Hello(){
//        return "<h1>String Value</h1>";
//    }
//    @GetMapping("/jj")
//    public String testJsp(){
//        return "test";
//    }
//
}
