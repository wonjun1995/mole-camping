package com.molecamp.molecamping.entity.campingspot;

import com.molecamp.molecamping.entity.user.UserEntity;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "camping_spot_comment")
public class CampingSpotComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String content;

    @CreationTimestamp
    private Timestamp create_date;

    @ManyToOne
    @JoinColumn(name = "camping_spot_id")
    private CampingSpot camping_spot;

    @ManyToOne
    @JoinColumn(name = "writer_id")
    private UserEntity userEntity;
}
