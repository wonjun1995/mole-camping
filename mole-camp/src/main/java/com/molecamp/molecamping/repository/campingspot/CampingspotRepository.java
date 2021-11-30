package com.molecamp.molecamping.repository.campingspot;

import com.molecamp.molecamping.entity.campingspot.CampingSpot;
import com.molecamp.molecamping.entity.community.CommunityPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampingspotRepository extends JpaRepository<CampingSpot,Integer> {

    Page<CampingSpot> findByTitleContaining(String keyword, Pageable pageable);

    //지역별 조회
    //Page<CampingSpot> findByRegion_1depth_name(String region,Pageable pageable);
}
