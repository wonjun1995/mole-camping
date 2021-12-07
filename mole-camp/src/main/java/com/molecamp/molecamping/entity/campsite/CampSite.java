package com.molecamp.molecamping.entity.campsite;

import com.molecamp.molecamping.entity.campsite.mealkit.MealKit;
import com.molecamp.molecamping.entity.campsite.restaurant.Restaurant;
import com.molecamp.molecamping.entity.campsite.room.CampsiteRoom;
import com.molecamp.molecamping.entity.reservation.Reservation;
import com.molecamp.molecamping.entity.user.UserEntity;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "campsite")
public class CampSite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String latitude_y;

    @Column(nullable = false)
    private String longtitude_x;

    @CreationTimestamp
    private Timestamp create_date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="owner_id")
    public UserEntity owner;

    //승인여부
    @Column(nullable = false)
    private int is_approve;

    @Column
    private String contact;

    //소개글
    @Column(nullable = false)
    private String introduction;

    //공지사항
    @Column
    private String notice;

    //인원 초과 비용
    @Column
    private int price_per_excess_person;

    //차량 초과 비용
    @Column
    private int price_per_excess_car;

    @OneToMany(mappedBy = "campSite", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @OrderBy("id desc")
    private List<CampsiteImage> campsiteImages;

    @OneToMany(mappedBy = "campSite", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<CampsiteRoom> campsiteRooms;

    @OneToMany(mappedBy = "campSite", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Restaurant> restaurants;

    @OneToMany(mappedBy = "campSite", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<MealKit> mealKits;

    @OneToMany(mappedBy = "campSite", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<CampsiteReview> campsiteReviews;

}
