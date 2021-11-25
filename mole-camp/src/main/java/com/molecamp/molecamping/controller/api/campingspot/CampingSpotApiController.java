package com.molecamp.molecamping.controller.api.campingspot;

import com.molecamp.molecamping.config.auth.UserDetail;
import com.molecamp.molecamping.dto.ResponseDto;
import com.molecamp.molecamping.entity.campingspot.CampingSpot;
import com.molecamp.molecamping.entity.community.CommunityPost;
import com.molecamp.molecamping.service.campingspot.CampingSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
public class CampingSpotApiController {

    @Autowired
    private CampingSpotService campingSpotService;

    @PostMapping("/api/campingspot/post")
    public ResponseDto<Integer> save(CampingSpot spot, @AuthenticationPrincipal UserDetail principal){
        campingSpotService.saveSpot(spot,principal.getUserEntity());
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @PutMapping("/api/campingspot/{id}/update")
    public ResponseDto<Integer> update(@PathVariable int id, CampingSpot spot){
        campingSpotService.updateSpot(id,spot);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @DeleteMapping("/api/campingspot/{id}/delete")
    public ResponseDto<Integer> delete(@PathVariable int id){
        campingSpotService.deleteSpot(id);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

}
