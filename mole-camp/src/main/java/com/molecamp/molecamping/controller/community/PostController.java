package com.molecamp.molecamping.controller.community;

import com.molecamp.molecamping.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {

    @Autowired
    private CategoryService categoryService;

    //게시글 목록 화면
    @GetMapping("/community/post")
    public String communityPostDetail(){
        return "community/communityDetail";
    }

    //게시글 작성 및 등록 화면
    @GetMapping("/community/post/save")
    public String communityPostSave(Model model){
        model.addAttribute("category_type",categoryService.type_all());
        return "community/communityPost";
    }
}
