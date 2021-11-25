package com.molecamp.molecamping.controller.api.community;

import com.molecamp.molecamping.dto.ReplyDto;
import com.molecamp.molecamping.dto.ResponseDto;
import com.molecamp.molecamping.repository.community.CommunityPostRepository;
import com.molecamp.molecamping.service.community.CommunityCommentService;
import com.molecamp.molecamping.service.community.CommunityPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommunityReplyApiController {

    @Autowired
    private CommunityCommentService communityCommentService;

    @PostMapping("/api/community/post/reply/save")
    public ResponseDto<Integer> replySave(@RequestBody ReplyDto replyDto) {
        communityCommentService.saveReply(replyDto);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @DeleteMapping("/api/community/post/reply/delete/{replyId}")
    public ResponseDto<Integer> replyDelete(@PathVariable int replyId){
        communityCommentService.deleteReply(replyId);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
}
