package com.molecamp.molecamping.entity.campsite.mealkit;

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
@Table(name = "mealkit")
public class MealKit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int stock;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "campsite_id")
    private CampSite campSite;

    //밀키트 이미지
    @OneToMany(mappedBy = "mealKit", fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    private List<MealkitImage> mealkitImages;
}
