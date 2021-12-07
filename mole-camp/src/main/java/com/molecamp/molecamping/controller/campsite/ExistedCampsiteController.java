package com.molecamp.molecamping.controller.campsite;

import com.molecamp.molecamping.service.ExistedCampsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExistedCampsiteController {

    @Autowired
    private ExistedCampsiteService existedCampsiteService;

    //캠핑장 목록
    @GetMapping("/campsite")
    public String campsite(Model model,
                           @RequestParam(name="region",required = false) String region,
                           @RequestParam(value = "keyword",required = false) String keyword,
                           @PageableDefault(size=10,sort = "id",direction = Sort.Direction.DESC) Pageable pageable){
        System.out.println(region);
        if(region == null && keyword == null){
            model.addAttribute("campsite",existedCampsiteService.listAll(pageable));
        }else if(region != null){
            model.addAttribute("campsite",existedCampsiteService.searchByRegion(region,pageable));
        }else if(keyword !=null){
            model.addAttribute("campsite",existedCampsiteService.keywordSearch(keyword,pageable));
        }
        model.addAttribute("RegionType",existedCampsiteService.dividedByRegion());
        model.addAttribute("previous",pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next",pageable.next().getPageNumber());
        return "campsite/campsite_main";
    }

    //캠핑장 상세보기
    @GetMapping("/campsite/{id}")
    public String campsiteDetail(Model model, @PathVariable int id){
        model.addAttribute("campsite",existedCampsiteService.campsiteDetail(id));
        return "campsite/campsite_detail";
    }
}
