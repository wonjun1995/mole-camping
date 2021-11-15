package com.molecamp.molecamping.repository;

import com.molecamp.molecamping.entity.post.community.CommunityPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityPostRepository extends JpaRepository<CommunityPost,Integer> {
}
