package com.molecamp.molecamping.service.campsite;

import com.molecamp.molecamping.dto.CampsiteRegionDto;
import com.molecamp.molecamping.entity.campingspot.CampingSpot;
import com.molecamp.molecamping.entity.campsite.ExitstedCampsite;
import com.molecamp.molecamping.repository.campsite.ExistedCampsiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class ExistedCampsiteService {

    @Autowired
    private ExistedCampsiteRepository existedCampsiteRepository;

    //캠핑여지도에 캠핑장 표시
    @Transactional(readOnly = true)
    public List<ExitstedCampsite> campsiteAll(){
        return existedCampsiteRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Page<ExitstedCampsite> listAll(Pageable pageable) {
        return existedCampsiteRepository.findAll(pageable);
    }

    //지역별 조회
    @Transactional(readOnly = true)
    public Page<ExitstedCampsite> searchByRegion(String region, Pageable pageable) {
        return existedCampsiteRepository.findByDoNm(region,pageable);
    }


    //키워드 검색
    @Transactional(readOnly = true)
    public Page<ExitstedCampsite> keywordSearch(String keyword, Pageable pageable) {
        return existedCampsiteRepository.findByFacltNmContaining(keyword,pageable);
    }

    //통합검색
    @Transactional(readOnly = true)
    public Page<ExitstedCampsite> totalSearch(String region,String keyword,Pageable pageable){
        return existedCampsiteRepository.findByDoNmAndFacltDivNmContaining(region,keyword,pageable);
    }

    @Transactional(readOnly = true)
    public List<CampsiteRegionDto> dividedByRegion() {
        return existedCampsiteRepository.dividedByDoNm();
    }

    @Transactional(readOnly = true)
    public ExitstedCampsite campsiteDetail(int id) {
        return existedCampsiteRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("상세 보기 실패: Cannot Found CampSite");
                });
    }
}
