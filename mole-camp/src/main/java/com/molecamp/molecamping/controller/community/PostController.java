package com.molecamp.molecamping.controller.community;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {
    //게시글 목록 화면
    @GetMapping("/community/post")
    public String communityPostDetail(){
        return "communityPost/postDetailForm";
    }

    //게시글 작성 및 등록 화면
    @GetMapping("/community/post/save")
    public String communityPostSave(){
        return "communityPost/postSaveForm";
    }
}
