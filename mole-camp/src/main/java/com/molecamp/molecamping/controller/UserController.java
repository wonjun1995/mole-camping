package com.molecamp.molecamping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/auth/joinForm")
    public String joinForm(){
        System.out.println("회원가입페이지");
        return "signUp";
    }

    @GetMapping("/auth/loginForm")
    public String loginForm(){
        System.out.println("로그인페이지");
        return "loginForm";
    }

}
