package com.molecamp.molecamping.entity.campsite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RestaurantInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int campsiteId;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String desc;
    @Column(nullable = false)
    private String address;

    //private FileInfoDto image;
}
