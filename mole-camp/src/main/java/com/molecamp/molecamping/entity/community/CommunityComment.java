package com.molecamp.molecamping.entity.community;

import com.molecamp.molecamping.entity.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommunityComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 넘버링 전략을 따라감
    private int id;

    @Column(nullable = false,length = 200)
    private String content;

    @ManyToOne
    @JoinColumn(name="postId")
    private CommunityPost communityPost;

    @ManyToOne
    @JoinColumn(name="userId")
    private UserEntity userEntity;

    @CreationTimestamp
    private Timestamp createdDate;
}
