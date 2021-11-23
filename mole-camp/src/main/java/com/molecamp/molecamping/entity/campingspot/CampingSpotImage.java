package com.molecamp.molecamping.entity.campingspot;

import javax.persistence.*;

@Entity
@Table(name="camping_spot_image")
public class CampingSpotImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String img_path;

    private String camping_spot_id;

}
