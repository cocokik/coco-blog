package com.cocokik.blog.service;

import com.cocokik.blog.model.User;
import com.cocokik.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional //여러 트랜잭션을 하나의 서비스로 관리하기 위해서 서비스 사용 -> 중간에 에러나면 롤백
    public void 회원가입(User user) {
            userRepository.save(user);
    }
    @Transactional(readOnly = true) // Select 할때 트랙잭션 시작 종료 할때 종료( 데이터의 정합성을 유지한다.)
    public User 로그인(User user) {
        System.out.println("login service" + user.getUserName() + user.getPassWord());
        return userRepository.login(user.getUserName(), user.getPassWord());
    }

}
