package com.molecamp.molecamping.repository.campingspot;

import com.molecamp.molecamping.entity.campingspot.CampingSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampingspotRepository extends JpaRepository<CampingSpot,Integer> {
}
