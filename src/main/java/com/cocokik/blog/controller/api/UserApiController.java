package com.cocokik.blog.controller.api;

import com.cocokik.blog.dto.ResponseDto;
import com.cocokik.blog.model.RoleType;
import com.cocokik.blog.model.User;
import com.cocokik.blog.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserApiController {
    @Autowired
    private UserService userService;
    @PostMapping("/auth/joinProc")
    public ResponseDto<Integer> save(@RequestBody User user) {
        user.setRole(RoleType.USER);
        userService.회원가입(user);
        System.out.println("req complete");
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }


    //  옛날 전통적 방식의 로그인
//    @PostMapping("/auth/loginProc")
//    public ResponseDto<Integer> login(@RequestBody User user, HttpSession session) {
//        user.setRole(RoleType.USER);
//        User principal = userService.로그인(user); //principal (접근주체)
//        System.out.println("control service " + user.getUserName() + user.getPassWord());
//        if (principal != null){
//            session.setAttribute("principal", principal); //세션 시작
//            System.out.println("control service succ");
//            return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
//        } else {
//            session.invalidate();
//            System.out.println("control service fail");
//        }
//        return new ResponseDto<Integer>(HttpStatus.INTERNAL_SERVER_ERROR.value(), -1);
//    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        System.out.println("logout");
        return "index";
    }
}
