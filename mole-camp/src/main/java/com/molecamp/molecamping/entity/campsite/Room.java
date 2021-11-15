package com.molecamp.molecamping.entity.campsite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private int campsiteId;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int price;
    @Column(nullable = false)
    private int roomNums;

    @Column(nullable = false)
    private int maxHeadCnt;
    @Column(nullable = false)
    private int baseHeadCnt;
    @Column(nullable = false)
    private int baseNumCars;

    //private FileInfoDto image;
}
