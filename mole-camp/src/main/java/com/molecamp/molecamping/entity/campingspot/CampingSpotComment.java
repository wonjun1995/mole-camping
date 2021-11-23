package com.molecamp.molecamping.entity.campingspot;

import com.molecamp.molecamping.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    private User user;
}
