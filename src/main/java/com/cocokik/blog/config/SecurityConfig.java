package com.cocokik.blog.config;

import com.cocokik.blog.config.auth.PrincipalDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.CorsFilter;

@Configuration //bean 등록
@EnableWebSecurity //시큐리티에 Filter 추가
@EnableMethodSecurity(prePostEnabled = false) //특정 주소로 접근시 권한 미리 체크하겠다
@RequiredArgsConstructor
public class SecurityConfig  {
    @Autowired
    private PrincipalDetailService principalDetailService;

    @Autowired
    private CorsFilter corsFilter;
    @Bean
    public BCryptPasswordEncoder encodedPWD(){
        return new BCryptPasswordEncoder();
    }


    //세션으로 로기인 할때 사용 - (카카오 or 회원가입 후)
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }
//    @Bean
//    public AuthenticationManager authenticationManager
//            (HttpSecurity http) throws Exception{
//        return http.getSharedObject(AuthenticationManagerBuilder.class)
//                .userDetailsService(principalDetailService)
//                .passwordEncoder(encodedPWD())
//                .and().build();
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); //session don't not use
        http.addFilter(corsFilter);
        http.formLogin().disable();
        http.httpBasic().disable();
        http.authorizeHttpRequests()
                .requestMatchers("/api/userUpdate").authenticated()
                .requestMatchers("updateForm").authenticated()
                .requestMatchers("/saveForm").authenticated()
                .anyRequest().permitAll();
//        http.getSharedObject(AuthenticationManagerBuilder.class)
//                .userDetailsService(principalDetailService)
//                .passwordEncoder(encodedPWD());
        return http.build();
    }
}
