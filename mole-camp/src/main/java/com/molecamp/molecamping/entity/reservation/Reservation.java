package com.molecamp.molecamping.entity.reservation;


import com.molecamp.molecamping.entity.campsite.CampSite;
import com.molecamp.molecamping.entity.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date check_in_date;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date check_out_date;

    //승인여부
    @Column(nullable = false)
    private int is_approve;

    //예약 인원수
    @Column(nullable = false)
    private int reserv_head_cnt;

    //예약 차량 수
    @Column(nullable = false)
    private int reserv_car_cnt;

    //총 가격
    @Column(nullable = false)
    private int total_price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "campsite_id")
    private CampSite campSite;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "booker_id")
    private UserEntity user;
}