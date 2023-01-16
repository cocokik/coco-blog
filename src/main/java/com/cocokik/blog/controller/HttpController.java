package com.cocokik.blog.controller;

import com.cocokik.blog.domain.Member;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//Controller = 사용자 요청시 HTML 응답 (파일 리턴 : 기본 스태틱 폴더)
//RestController = 사용자 요청시 Data 응답
@RestController
public class HttpController {

    @GetMapping("/http/get")
    public String getTest(Member m){
        return  m.getName();
    }
    @GetMapping("/http/post")
    public String postTest(){
        return "post";
    }
    @GetMapping("/http/put")
    public String putTest(){
        return "put";
    }
    @GetMapping("/http/del")
    public String delTest(){
        return "del";
    }
}
