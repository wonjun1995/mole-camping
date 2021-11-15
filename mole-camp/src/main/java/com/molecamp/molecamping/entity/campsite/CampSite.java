package com.molecamp.molecamping.entity.campsite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CampSite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String owner;
    private int isApprove;

    private String name;
    private String address;
    private String contact;

    private String introduction;
    private String notice;
    private int cheapestRoomPrice;

    private int pricePerExcessPerson;
    private int pricePerExcessCar;

    //private List<String> operatingTypes;
    //private List<String> facilities;

    //private Room rooms;
    //private MealkitInfo mealKits;

    //private TouristInfo touristInfos;
    //private RestaurantInfo restaurantInfos;

    //private List<ReviewDto> reviews;
}
