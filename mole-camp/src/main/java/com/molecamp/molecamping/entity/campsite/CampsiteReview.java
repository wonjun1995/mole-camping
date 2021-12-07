package com.molecamp.molecamping.entity.campsite;

import com.molecamp.molecamping.entity.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "campsite_review")
public class CampsiteReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int score;

    @Column(nullable = false)
    @Lob
    private String content;

    @CreationTimestamp
    private Timestamp create_date;

    @ManyToOne
    @JoinColumn(name = "writer_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "campsite_id")
    private CampSite campSite;


}
