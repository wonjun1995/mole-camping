package com.molecamp.molecamping.controller.main;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.molecamp.molecamping.entity.user.KakaoProfile;
import com.molecamp.molecamping.entity.user.OAuthToken;
import com.molecamp.molecamping.entity.user.UserEntity;
import com.molecamp.molecamping.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class UserController {

    //카카오 로그인 캡슐화
    @Value("${kakao.password}")
    private String kakaoKey;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @GetMapping("/auth/joinForm")
    public String joinForm(){
        return "auth/signUp";
    }

    @GetMapping("/auth/loginForm")
    public String loginForm(){
        return "auth/loginForm";
    }

    @GetMapping("/auth/login/kakao")
    public String kakaoCallback(String code){


        RestTemplate rt=new RestTemplate();

        //HttpHeader 오브젝트 생성
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");

        //HttpBody 오브젝트 생성
        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        params.add("grant_type","authorization_code");
        params.add("client_id","62e24697f7bc91876ca05e412964da74");
        params.add("redirect_uri","http://3.34.163.139:8080/auth/login/kakao");
        params.add("code",code);

        //HttpHeader와 HttpBody를 하나의 오브젝트에 담기
        HttpEntity<MultiValueMap<String,String>> kakaoTokenRequest =
                new HttpEntity<>(params,headers);

        //Http 요청하기 - Post 방식으로 - 그리고 response 변수의 응답 받음
        ResponseEntity<String> response = rt.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class
        );

        //Gson,Json Simple, ObjectMapper
        ObjectMapper objectMapper= new ObjectMapper();
        OAuthToken oAuthToken = null;
        try{
            oAuthToken=objectMapper.readValue(response.getBody(),OAuthToken.class);
        }catch (JsonMappingException e){
            e.printStackTrace();
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }


        RestTemplate rt2=new RestTemplate();

        //HttpHeader 오브젝트 생성
        HttpHeaders headers2 = new HttpHeaders();
        headers2.add("Authorization","Bearer " + oAuthToken.getAccess_token());
        headers2.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");

        //HttpHeader와 HttpBody를 하나의 오브젝트에 담기
        HttpEntity<MultiValueMap<String,String>> kakaoProfileRequest2 =
                new HttpEntity<>(headers2);

        //Http 요청하기 - Post 방식으로 - 그리고 response 변수의 응답 받음
        ResponseEntity<String> response2 = rt2.exchange(
                "https://kapi.kakao.com/v2/user/me",
                HttpMethod.POST,
                kakaoProfileRequest2,
                String.class
        );

        System.out.println(response2.getBody());

        ObjectMapper objectMapper2= new ObjectMapper();
        KakaoProfile kakaoProfile = null;
        try{
            kakaoProfile=objectMapper2.readValue(response2.getBody(),KakaoProfile.class);
        }catch (JsonMappingException e){
            e.printStackTrace();
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }

        UserEntity kakaoUser = UserEntity.builder().username(kakaoProfile.getKakao_account().getEmail())
                .password(kakaoKey)
                .oauth("kakao")
                .build();

        //가입자 혹은 비가입자 체크해서 처리
        UserEntity originuser=userService.validateJoin(kakaoUser.getUsername());

        if (originuser.getUsername() == null){
            System.out.println("기존 회원이 아니기에 자동 회원가입을 진행합니다.");
            userService.join(kakaoUser);
        }

        //로그인 처리
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(kakaoUser.getUsername(),kakaoKey));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "redirect:/";
    }

}
