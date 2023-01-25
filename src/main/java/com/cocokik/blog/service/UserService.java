package com.cocokik.blog.service;

import com.cocokik.blog.controller.LoginAuthenticationManager;
import com.cocokik.blog.model.RoleType;
import com.cocokik.blog.model.User;
import com.cocokik.blog.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder encode;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Transactional //여러 트랜잭션을 하나의 서비스로 관리하기 위해서 서비스 사용 -> 중간에 에러나면 롤백
    public void 회원가입(User user) {
            user.setRole(RoleType.USER);
            user.setPassWord(encode.encode(user.getPassWord()));
            userRepository.save(user);
    }

    //old version style
//    @Transactional(readOnly = true) // Select 할때 트랙잭션 시작 종료 할때 종료( 데이터의 정합성을 유지한다.)
//    public User 로그인(User user) {
//        System.out.println("login service" + user.getUserName() + user.getPassWord());
//        return userRepository.login(user.getUserName(), user.getPassWord());
//    }
    public User 회원찾기(User user) {
        return
                userRepository.findByUserName(user.getUserName()).orElseGet(User::new);
    }

    @Transactional
    public void 회원수정(User user) {
        User persist = userRepository.findById(user.getId()).orElseThrow(() ->
                new IllegalArgumentException("회원찾기 실패"));

        //validate check 홈페이지 회원가입 인 경우에만 비밀번호 변경 가능
        if(persist.getOauth() == "" || persist.getOauth() ==null){
            persist.setPassWord(encode.encode(user.getPassWord()));
        }
        persist.setEmail(user.getEmail());
    }

    //시큐리티 로그인 하기.. 회원가입 후 로그인이나 카카오톡 로그인 할때 사용

    public boolean autoLogin( String username, String password, HttpServletRequest request) {

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);

        Authentication authentication = authenticationManager.authenticate(token);

        SecurityContextHolder.getContext().setAuthentication(authentication );

        //this step is important, otherwise the new login is not in session which is required by Spring Security
        request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());


        return true;
    }

}
