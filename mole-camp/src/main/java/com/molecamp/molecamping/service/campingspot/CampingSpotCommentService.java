package com.molecamp.molecamping.service.campingspot;

import com.molecamp.molecamping.dto.CampingSpotReplyDto;
import com.molecamp.molecamping.dto.ReplyDto;
import com.molecamp.molecamping.repository.campingspot.CampingSpotCommentRepository;
import com.molecamp.molecamping.repository.community.CommunityCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CampingSpotCommentService {
    @Autowired
    private CampingSpotCommentRepository campingSpotCommentRepository;

    @Transactional
    public void saveReply(CampingSpotReplyDto replyDto) {
        campingSpotCommentRepository.replySave(replyDto.getWriter_id(), replyDto.getCamping_spot_id(), replyDto.getContent());
    }

    @Transactional
    public void deleteReply(int id) {
        campingSpotCommentRepository.deleteById(id);
    }
}
