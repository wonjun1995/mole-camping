package com.molecamp.molecamping.repository.community;

import com.molecamp.molecamping.entity.community.CommunityPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityPostRepository extends JpaRepository<CommunityPost,Integer> {

    Page<CommunityPost> findByCategoryId(int category, Pageable pageable);
}
