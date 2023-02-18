package com.cocokik.blog.controller;

import com.cocokik.blog.config.auth.PrincipalDetail;
import com.cocokik.blog.model.KakaoProfile;
import com.cocokik.blog.model.OAuthToken;
import com.cocokik.blog.model.RoleType;
import com.cocokik.blog.model.User;
import com.cocokik.blog.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @Value("${cocokik.key}")
    private String cocokikKey;
    @GetMapping("/auth/joinForm")
    public String joinForm() {

        return "user/joinForm";
    }
    @GetMapping("/auth/loginForm")
    public String loginForm() {

        return "user/loginForm";
    }

    @GetMapping("/user/updateForm")
    public String userUpdateForm(){
        return "user/updateForm";
    }
    @GetMapping("/auth/kakao/callback")
    public String kakaoCallback(String code, HttpServletRequest request) {
        System.out.println(code);
        System.out.println(code);
        System.out.println(code);
        System.out.println(code);
        System.out.println(code);
        System.out.println(code);
        System.out.println(code);
        System.out.println(code);
        System.out.println(code);

        //Retrofit2
        //OkHttp
        //HttpsURLConnection
        //RestTemplate
        RestTemplate rt = new RestTemplate();
        //헤더
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
        //바디
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String,String>();
        params.add("client_id", "4bbc99f4047d689792b910febf22f9a6");
        params.add("redirect_uri", "http://localhost/auth/kakao/callback");
        params.add("grant_type", "authorization_code");
        params.add("code", code);
        //헤더 바디 하나의 오브젝트에 담기
        HttpEntity<MultiValueMap<String , String >> kakaoTokenRequest =
                new HttpEntity<>(params,headers);
        //http 요청
        ResponseEntity<String> response = rt.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class);

        //Gson, Json Simple, ObjectMapper
        ObjectMapper obMapper = new ObjectMapper();
        OAuthToken oAuthToken = null;
        try {
            oAuthToken = obMapper.readValue(response.getBody(), OAuthToken.class);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        // 사용자 정보 받아오기
        RestTemplate rt2 = new RestTemplate();
        HttpHeaders headers2 = new HttpHeaders();
        headers2.add("Authorization", "Bearer " + oAuthToken.getAccess_token());
        headers2.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
        HttpEntity<MultiValueMap<String , String >> kakaoTokenRequest2 =
                new HttpEntity<>(headers2);
        ResponseEntity<String> response2 = rt2.exchange(
                "https://kapi.kakao.com/v2/user/me",
                HttpMethod.POST,
                kakaoTokenRequest2,
                String.class);
        ObjectMapper obMapper2 = new ObjectMapper();
        KakaoProfile kakaoProfile = null;
        try {
            kakaoProfile = obMapper2.readValue(response2.getBody(), KakaoProfile.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("아이디 : " + kakaoProfile.getId());
        System.out.println("이메일 : " + kakaoProfile.getKakao_account().getEmail());
        User user = User.builder()
                .userName("kakako_" + kakaoProfile.getId())
                .passWord(cocokikKey).role(RoleType.USER).oauth("kakao").build();
        if (kakaoProfile.getKakao_account().has_email) user.setEmail(kakaoProfile.getKakao_account().getEmail());
        System.out.println("key = " + cocokikKey);
        if (null == userService.회원찾기(user).getUserName()) {
            userService.회원가입(user);
            System.out.println("회원가입 완료");
        } else {
            System.out.println("기존 회원 로그인");
        }
        userService.autoLogin(user.getUserName(),user.getPassWord(),request);
        return "redirect:/";
    }


}
