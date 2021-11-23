package com.molecamp.molecamping.entity.campingspot;

import com.molecamp.molecamping.entity.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "camping_spot")
public class CampingSpot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    @Lob
    private String description;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String detail_address;

    @Column(nullable = false)
    private String latitude_y;

    @Column(nullable = false)
    private String longtitude_x;

    @Column(nullable = false)
    private String region_1depth_name;

    @Column(nullable = false)
    private String region_2depth_name;

    @CreationTimestamp
    private Timestamp create_date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="writer_id")
    public UserEntity userEntity;

    //캠핑스팟 댓글과 양방향 맵핑
    @OneToMany(mappedBy = "camping_spot", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @OrderBy("id desc")
    private List<CampingSpotComment> reply;


}
