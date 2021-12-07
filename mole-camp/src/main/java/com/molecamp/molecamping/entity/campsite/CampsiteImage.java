package com.molecamp.molecamping.entity.campsite;

import com.molecamp.molecamping.entity.common.FileInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "campsite_image")
public class CampsiteImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "file_id")
    private FileInfo file;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "campsite_id")
    private CampSite campSite;
}
