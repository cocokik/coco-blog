package com.cocokik.blog.controller;

import com.cocokik.blog.model.RoleType;
import com.cocokik.blog.model.User;
import com.cocokik.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Supplier;

@RestController
public class DummyController {
    @Autowired //Di 의존성 주입
    private UserRepository userRepository;
    @GetMapping("/dummy/users")
    public List<User> allUser(){
        List<User> all = userRepository.findAll();

        return all;
    }

    @GetMapping("/dummy/user/page")
    public List<User> pageList(@PageableDefault(size=2,sort="id",direction = Sort.Direction.DESC) Pageable pageable){
        Page<User> userPage = userRepository.findAll(pageable);
        return userPage.getContent();
    }

    @DeleteMapping("/dummy/user/{id}")
    public String deleteUser(@PathVariable int id){
        try {
            userRepository.deleteById(id);
        }catch (Exception e){
            return e.toString() + " 삭제 실패";
        }
        return "Success";
    }
    @GetMapping("/dummy/user/{id}") //주소로 파라미터 받기
    public User detail(@PathVariable int id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 유저가 없습니다. id : " + id));
        return user;
    }
    @Transactional //더티 체킹 //함수종료시에 자동 커밋
    @PutMapping("/dummy/user/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User requestUser){
        requestUser.setId(id);
        userRepository.save(requestUser);
        return requestUser;
    }

    @PostMapping("/dummy")
    public String join(User user) {
        System.out.println(user.getUserName());
        System.out.println(user.getEmail());
        System.out.println(user.getPassWord());
        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "회원가입 완료했습니다.";
    }
}
