package com.molecamp.molecamping.controller.api.campingspot;

import com.molecamp.molecamping.dto.CampingSpotReplyDto;
import com.molecamp.molecamping.dto.ReplyDto;
import com.molecamp.molecamping.dto.ResponseDto;
import com.molecamp.molecamping.repository.community.CommunityPostRepository;
import com.molecamp.molecamping.service.campingspot.CampingSpotCommentService;
import com.molecamp.molecamping.service.campingspot.CampingSpotService;
import com.molecamp.molecamping.service.community.CommunityCommentService;
import com.molecamp.molecamping.service.community.CommunityPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CampingSpotReplyApiController {

    @Autowired
    private CampingSpotCommentService campingSpotCommentService;


    @PostMapping("/api/campingspot/{id}/reply/save")
    public ResponseDto<Integer> replySave(@RequestBody CampingSpotReplyDto replyDto) {
        campingSpotCommentService.saveReply(replyDto);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @DeleteMapping("/api/campingspot/{spotId}/reply/delete/{replyId}")
    public ResponseDto<Integer> replyDelete(@PathVariable int replyId){
        campingSpotCommentService.deleteReply(replyId);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
}
