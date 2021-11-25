package com.molecamp.molecamping.service.community;

import com.molecamp.molecamping.entity.community.CommunityPost;
import com.molecamp.molecamping.entity.user.UserEntity;
import com.molecamp.molecamping.repository.community.CommunityPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommunityPostService {

    @Autowired
    private CommunityPostRepository comPostRepository;


    //community 게시글 저장
    @Transactional
    public void savePost(CommunityPost post, UserEntity userEntity) {
        post.setCount(0);
        post.setUserEntity(userEntity);
        comPostRepository.save(post);
    }

    //community 게시글 전체 조회
    @Transactional(readOnly = true)
    public Page<CommunityPost> postListAll(Pageable pageable){
        return comPostRepository.findAll(pageable);
    }

    //community 게시글 id로 1회 조희
    @Transactional(readOnly = true)
    public CommunityPost postDetail(int id) {
        return comPostRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("상세 보기 실패: Cannot Found ID");
                });
    }

    //community 게시글 수정 및 저장
    @Transactional
    public void updatePost(int id, CommunityPost post) {
        CommunityPost exitstedPost = comPostRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("상세 보기 실패: Cannot Found ID");
                });
        exitstedPost.setTitle(post.getTitle());
        exitstedPost.setContent(post.getContent());

        exitstedPost.setImg_path(post.getImg_path());
    }

    @Transactional
    public void deletePost(int id) {
       comPostRepository.deleteById(id);
    }
}
