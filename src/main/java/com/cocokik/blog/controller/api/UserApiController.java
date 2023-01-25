package com.cocokik.blog.controller.api;

import com.cocokik.blog.config.auth.PrincipalDetail;
import com.cocokik.blog.dto.ResponseDto;
import com.cocokik.blog.model.User;
import com.cocokik.blog.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserApiController {
    @Autowired
    private UserService userService;
    @PostMapping("/auth/joinProc")
    public ResponseDto<Integer> save(@RequestBody User user) {
        userService.회원가입(user);
        System.out.println("req complete");
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
    @PutMapping("/api/userUpdate")
    public ResponseDto<Integer> userUpdate(@RequestBody User user, @AuthenticationPrincipal PrincipalDetail principal) {
        userService.회원수정(user);
        //트랜잭션 종료로 디비값은 변경됐지만 세션값은 변경되지 않은 상태
        //세션값 변경
        principal.getUser().setEmail(user.getEmail());
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

//    @GetMapping("/logout")
//    public String logout(HttpSession session) {
//        session.invalidate();
//        System.out.println("logout");
//        return "index";
//    }
}
