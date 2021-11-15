package com.molecamp.molecamping.repository;

import com.molecamp.molecamping.entity.post.community.CommunityComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityCommentRepository extends JpaRepository<CommunityComment,Integer> {

    @Modifying
    @Query(value = "INSERT INTO CommunityComment(userId,postId,content,createdDate) VALUES(?1,?2,?3,now())",nativeQuery = true)
    int replySave(int userId,int postId,String content);

    @Modifying
    @Query(value = "SELECT * FROM CommunityComment WHERE postId = ?1",nativeQuery = true)
    Iterable<CommunityComment> replyAllByPostId(int postId);
}
