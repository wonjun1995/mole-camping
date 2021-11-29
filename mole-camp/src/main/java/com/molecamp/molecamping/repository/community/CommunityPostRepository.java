package com.molecamp.molecamping.repository.community;

import com.molecamp.molecamping.entity.community.CommunityPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityPostRepository extends JpaRepository<CommunityPost,Integer> {

    //@Query("SELECT * FROM CommunityPost WHERE category_id=?1") 와 같음
    Page<CommunityPost> findByCategoryId(int category, Pageable pageable);

    //@Query("SELECT * FROM CommunityPost WHERE title LIKE '%keyword%') 와 같음
    Page<CommunityPost> findByTitleContaining(String keyword, Pageable pageable);
}
