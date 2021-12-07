package com.molecamp.molecamping.entity.campsite.restaurant;

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
@Table(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String detail_address;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "campsite_id")
    private CampSite campSite;

    @OneToMany(mappedBy = "restaurant", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<RestaurantImage> restaurantImages;

}
