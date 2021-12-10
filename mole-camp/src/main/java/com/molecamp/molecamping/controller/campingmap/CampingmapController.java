package com.molecamp.molecamping.controller.campingmap;

import com.molecamp.molecamping.service.campingspot.CampingSpotService;
import com.molecamp.molecamping.service.campsite.ExistedCampsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CampingmapController {

    @Autowired
    private ExistedCampsiteService existedCampsiteService;

    @Autowired
    private CampingSpotService campingSpotService;

    //마커 표시
    @GetMapping("/campingmap")
    public String campingmap(Model model){
        model.addAttribute("campsite",existedCampsiteService.campsiteAll());
        model.addAttribute("RegionType",existedCampsiteService.dividedByRegion());
        model.addAttribute("campingspot",campingSpotService.campingSpotListAll());
        return "campingmap/campingmap_main";
    }

}
