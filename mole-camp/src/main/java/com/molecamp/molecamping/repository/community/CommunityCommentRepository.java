package com.molecamp.molecamping.repository.community;

import com.molecamp.molecamping.entity.community.CommunityComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityCommentRepository extends JpaRepository<CommunityComment,Integer> {

    @Modifying
    @Query(value = "INSERT INTO CommunityComment(userId,postId,content,createdDate) VALUES(?1,?2,?3,now())",nativeQuery = true)
    int replySave(int userId,int postId,String content);

}
