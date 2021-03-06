package com.molecamp.molecamping.service.community;

import com.molecamp.molecamping.dto.ReplyDto;
import com.molecamp.molecamping.repository.community.CommunityCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommunityCommentService {

    @Autowired
    private CommunityCommentRepository communityCommentRepository;

    @Transactional
    public void saveReply(ReplyDto replyDto) {
        communityCommentRepository.replySave(replyDto.getUser_id(), replyDto.getPost_id(), replyDto.getContent());
    }

    @Transactional
    public void deleteReply(int id) {
        communityCommentRepository.deleteById(id);
    }
}
