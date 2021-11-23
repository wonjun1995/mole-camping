package com.molecamp.molecamping.controller.campingspot;

import com.molecamp.molecamping.config.auth.UserDetail;
import com.molecamp.molecamping.service.campingspot.CampingSpotService;
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
public class CampingSpotController {

    @Autowired
    private CampingSpotService campingSpotService;

    //캠핑스팟 메인 화면
    @GetMapping("/campingspot")
    public String campingspot(Model model,@PageableDefault(size=5,sort = "id",direction = Sort.Direction.DESC) Pageable pageable){
        model.addAttribute("spotAllList",campingSpotService.listAll(pageable));
        model.addAttribute("previous",pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next",pageable.next().getPageNumber());
        return "campingspot/campingspot_main";
    }

    //캠핑스팟 등록 화면
    @GetMapping("/campingspot/post/save")
    public String campingspot_post(){
        return "campingspot/campingspot_post";
    }

    //캠핑스팟 상세보기


}
