package com.molecamp.molecamping.repository.community;

import com.molecamp.molecamping.entity.community.CommunityComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityCommentRepository extends JpaRepository<CommunityComment,Integer> {

    @Modifying
    @Query(value = "INSERT INTO community_comment(user_id,post_id,content,create_date) VALUES(?1,?2,?3,now())",nativeQuery = true)
    int replySave(int user_id,int post_id, String content);

}
