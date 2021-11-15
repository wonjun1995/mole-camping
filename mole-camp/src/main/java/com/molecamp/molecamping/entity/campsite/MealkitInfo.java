package com.molecamp.molecamping.entity.campsite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MealkitInfo {
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
    private int numRemains;

    //private FileInfoDto image;
}
