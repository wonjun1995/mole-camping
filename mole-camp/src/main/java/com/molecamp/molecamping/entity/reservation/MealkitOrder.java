package com.molecamp.molecamping.entity.reservation;


import com.molecamp.molecamping.entity.campsite.mealkit.MealKit;
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
@Table(name = "mealkit_order")
public class MealkitOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //주문 건수
    @Column(nullable = false)
    private int total_count;

    //주문 금액
    @Column(nullable = false)
    private int total_price;

    @OneToMany(fetch = FetchType.EAGER)
    private List<MealKit> mealKits;



}
