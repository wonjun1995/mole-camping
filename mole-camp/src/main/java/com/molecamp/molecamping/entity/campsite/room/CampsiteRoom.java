package com.molecamp.molecamping.entity.campsite.room;


import com.molecamp.molecamping.entity.campsite.CampSite;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "campsite_room")
public class CampsiteRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    //최대 인원수
    @Column(nullable = false)
    private int max_head_cnt;

    //기준 인원수
    @Column(nullable = false)
    private int base_head_cnt;

    //기준 차량 수
    @Column(nullable = false)
    private int base_car_cnt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "campsite_id")
    private CampSite campSite;

    @OneToMany(mappedBy = "campsiteRoom", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<CampsiteRoomImage> campsiteRoomImages;

}
