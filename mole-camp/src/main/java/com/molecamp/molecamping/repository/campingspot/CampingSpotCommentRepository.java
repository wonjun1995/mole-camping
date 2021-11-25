package com.molecamp.molecamping.repository.campingspot;

import com.molecamp.molecamping.entity.campingspot.CampingSpotComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CampingSpotCommentRepository extends JpaRepository<CampingSpotComment,Integer> {

    @Modifying
    @Query(value = "INSERT INTO camping_spot_comment(writer_id,camping_spot_id,content,create_date) VALUES(?1,?2,?3,now())",nativeQuery = true)
    int replySave(int writer_id, int camping_spot_id,String content);

}
