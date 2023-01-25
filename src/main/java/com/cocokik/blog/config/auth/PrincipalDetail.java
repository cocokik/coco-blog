package com.cocokik.blog.config.auth;

import com.cocokik.blog.model.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
public class PrincipalDetail implements UserDetails {
    private User user; //콤포지션 (객체를 품고있는걸 말함)
    public PrincipalDetail(User user){
        this.user = user;
    }
    @Override
    public String getPassword() {
        return user.getPassWord();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override //계정 만료됐는지 리턴 (트루는 만료 안됨)
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    @Override //계정의 권한목록을 리턴한다.
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new GrantedAuthority() {
//            @Override
//            public String getAuthority() {
//                return "ROLE_" + user.getRole().toString(); //스프링에서 롤을 받을때 규칙 : 앞에 ROLE_ 를 꼭 붙여줘야함
//            }
//        });
        authorities.add(()->"ROLE_" + user.getRole());
        return authorities;
    }
}
