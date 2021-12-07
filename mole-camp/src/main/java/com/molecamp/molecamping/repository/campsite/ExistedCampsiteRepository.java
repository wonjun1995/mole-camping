package com.molecamp.molecamping.repository.campsite;

import com.molecamp.molecamping.dto.CampsiteRegionDto;
import com.molecamp.molecamping.entity.campsite.ExitstedCampsite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExistedCampsiteRepository extends JpaRepository<ExitstedCampsite, Integer> {

    Page<ExitstedCampsite> findByDoNm(String region, Pageable pageable);

    Page<ExitstedCampsite> findByFacltNmContaining(String keyword, Pageable pageable);

    //Page<ExitstedCampsite> findByDoNm(String region,Pageable pageable);

    @Query("SELECT new com.molecamp.molecamping.dto.CampsiteRegionDto(cp.doNm, COUNT(cp.doNm)) "
            + " FROM ExitstedCampsite cp "
            + " GROUP BY cp.doNm ")
    public List<CampsiteRegionDto> dividedByDoNm();
}
