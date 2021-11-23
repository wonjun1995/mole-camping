package com.molecamp.molecamping.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/auth/joinForm")
    public String joinForm(){
        System.out.println("회원가입페이지");
        return "auth/signUp";
    }

    @GetMapping("/auth/loginForm")
    public String loginForm(){
        System.out.println("로그인페이지");
        return "auth/loginForm";
    }

}
