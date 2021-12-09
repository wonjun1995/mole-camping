package com.molecamp.molecamping.service.campingspot;

import com.molecamp.molecamping.entity.campingspot.CampingSpot;
import com.molecamp.molecamping.entity.community.CommunityPost;
import com.molecamp.molecamping.entity.user.UserEntity;
import com.molecamp.molecamping.repository.campingspot.CampingspotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CampingSpotService {

    //campingspot repository
    @Autowired
    private CampingspotRepository campingspotRepository;

    //campingspot 저장
    @Transactional
    public void saveSpot(CampingSpot spot, UserEntity userEntity) {
        spot.setUserEntity(userEntity);
        campingspotRepository.save(spot);
    }
    //campingspot 메인화면 목록
    @Transactional(readOnly = true)
    public Page<CampingSpot> listAll(Pageable pageable) {
        return campingspotRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public List<CampingSpot> campingSpotListAll(){
        return campingspotRepository.findAll();
    }

    //campingspot 상세보기
    @Transactional(readOnly = true)
    public CampingSpot spotDetail(int id) {
        return campingspotRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("상세 보기 실패: Cannot Found ID");
                });
    }

    //campingspot 수정
    @Transactional
    public void updateSpot(int id, CampingSpot spot) {
        CampingSpot existedSpot= campingspotRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("게시글 수정 실패: Cannot Found ID");
                });
        existedSpot.setTitle(spot.getTitle());
        existedSpot.setDescription(spot.getDescription());
    }

    //campingspot 삭제
    @Transactional
    public void deleteSpot(int id){
        campingspotRepository.deleteById(id);
    }

    //키워드 검색
    @Transactional(readOnly = true)
    public Page<CampingSpot> keywordSearch(String keyword, Pageable pageable) {
        return campingspotRepository.findByTitleContaining(keyword,pageable);
    }

    //카테고리별 조회
    /*@Transactional(readOnly = true)
    public Page<CampingSpot> regionAll(@PathVariable String region, Pageable pageable){
        return campingspotRepository.findByRegion_1depth_name(region,pageable);
    }*/

    //카테고리별 검색

}
