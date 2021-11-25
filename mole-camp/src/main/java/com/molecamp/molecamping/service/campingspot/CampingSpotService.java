package com.molecamp.molecamping.service.campingspot;

import com.molecamp.molecamping.entity.campingspot.CampingSpot;
import com.molecamp.molecamping.entity.user.UserEntity;
import com.molecamp.molecamping.repository.campingspot.CampingspotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CampingSpotService {

    //campingspot repository
    @Autowired
    private CampingspotRepository campingspotRepository;

    @Transactional
    public void saveSpot(CampingSpot spot, UserEntity userEntity) {
        spot.setUserEntity(userEntity);
        campingspotRepository.save(spot);
    }

    @Transactional(readOnly = true)
    public Page<CampingSpot> listAll(Pageable pageable) {
        return campingspotRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public CampingSpot spotDetail(int id) {
        return campingspotRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("상세 보기 실패: Cannot Found ID");
                });
    }

    @Transactional
    public void updateSpot(int id, CampingSpot spot) {
        CampingSpot existedSpot= campingspotRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("ID 찾기 실패: Cannot Found ID");
                });
        existedSpot.setTitle(spot.getTitle());
        existedSpot.setDescription(spot.getDescription());
    }

    @Transactional
    public void deleteSpot(int id){
        campingspotRepository.deleteById(id);
    }
}
