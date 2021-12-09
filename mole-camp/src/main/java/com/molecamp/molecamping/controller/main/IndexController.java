package com.molecamp.molecamping.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    //메인화면
    @GetMapping("/")
    public String index(){
        return "main/index";
    }

    //about us
    @GetMapping("/about")
    public String about(){
        return "main/about";
    }


    //캠핑장터
    @GetMapping("/campingmarket")
    public String campingmarket(){
        return "campingmarket/campingmarket_main";
    }

    //공지사항
    @GetMapping("/notice")
    public String notice(){
        return "main/notice";
    }

    //마이페이지
    @GetMapping("/mypage")
    public String mypage(){
        return "main/mypage";
    }



}
