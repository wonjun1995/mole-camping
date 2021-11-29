package com.molecamp.molecamping.controller.community;

import com.molecamp.molecamping.config.auth.UserDetail;
import com.molecamp.molecamping.service.community.CategoryService;
import com.molecamp.molecamping.service.community.CommunityCommentService;
import com.molecamp.molecamping.service.community.CommunityPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PostController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CommunityPostService communityPostService;
    @Autowired
    private CommunityCommentService communityCommentService;

    //게시글 목록 화면
    @GetMapping("/community/post")
    public String communityPostMain(Model model,@PageableDefault(size=5,sort = "id",direction = Sort.Direction.DESC) Pageable pageable){
        model.addAttribute("postAllList",communityPostService.postListAll(pageable));
        model.addAttribute("category_type",categoryService.type_all());
        model.addAttribute("previous",pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next",pageable.next().getPageNumber());
        return "community/communityMain";
    }

    //카테고리별 게시글 목록 화면
    @GetMapping("/community/post/category/{categoryId}")
    public String communityCategorySearch(@PathVariable int categoryId, Model model,@PageableDefault(size=5,sort = "id",direction = Sort.Direction.DESC) Pageable pageable){
        model.addAttribute("postAllList",communityPostService.postCategoryAll(categoryId,pageable));
        model.addAttribute("category_type",categoryService.type_all());
        model.addAttribute("previous",pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next",pageable.next().getPageNumber());
        return "community/communityMain";
    }

    //게시글 작성 및 등록 화면
    @GetMapping("/community/post/save")
    public String communityPostSave(Model model){
        model.addAttribute("category_type",categoryService.type_all());
        return "community/communityPost";
    }

    //게시글 상세보기
    @GetMapping("/community/post/{id}")
    public String communityPostDetail(Model model, @PathVariable int id, @AuthenticationPrincipal UserDetail userDetail) {
        model.addAttribute("authUser",userDetail.getUserEntity());
        model.addAttribute("post",communityPostService.postDetail(id));
        model.addAttribute("category_type",categoryService.type_all());
        return "community/communityDetail";
    }

    //게시글 수정
    @GetMapping("/community/post/{id}/update")
    public String communityPostUpdate(Model model, @PathVariable int id){
        model.addAttribute("post",communityPostService.postDetail(id));
        model.addAttribute("category_type",categoryService.type_all());
        return "community/communityUpdate";
    }
}
