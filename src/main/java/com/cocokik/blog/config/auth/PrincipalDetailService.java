package com.cocokik.blog.config.auth;

import com.cocokik.blog.model.User;
import com.cocokik.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service //
public class PrincipalDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    //스프링이 로그인 할때 유저네임 패스워드를 가로채는데
    //패스워드는 스프링에서 알아서 체크하고
    //아이디만 있는지 디비에서 확인하는걸 오버라이드 해주면 된다.ser.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username).orElseThrow(
                () -> new UsernameNotFoundException("해당 유저를 찾을 수 없습니다." + username)
        );
        PrincipalDetail principalDetail = new PrincipalDetail(user);
        return principalDetail; //시큐리티 세션에 유저정보가 저장됨
    }
}
