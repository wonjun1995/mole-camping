package com.molecamp.molecamping.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/auth/joinForm")
    public String joinForm(){
        return "auth/signUp";
    }

    @GetMapping("/auth/loginForm")
    public String loginForm(){
        return "auth/loginForm";
    }
}
