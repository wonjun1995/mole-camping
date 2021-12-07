package com.molecamp.molecamping.entity.campsite.room;

import com.molecamp.molecamping.entity.campsite.CampSite;
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
@Table(name = "campsite_room_image")
public class CampsiteRoomImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "file_id")
    private FileInfo file;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id")
    private CampsiteRoom campsiteRoom;
}
