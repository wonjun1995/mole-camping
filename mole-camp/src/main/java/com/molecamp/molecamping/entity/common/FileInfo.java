package com.molecamp.molecamping.entity.common;

import com.molecamp.molecamping.entity.user.UserEntity;
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
@Table(name = "file_info")
public class FileInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String content_type;

    @Column(nullable = false)
    private String file_path;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    public UserEntity user;
}
