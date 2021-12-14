package com.molecamp.molecamping.entity.community;

import com.molecamp.molecamping.entity.user.UserEntity;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "community_comment")
public class CommunityComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 넘버링 전략을 따라감
    private int id;

    @Column(nullable = false,length = 200)
    private String content;

    @ManyToOne
    @JoinColumn(name="post_id")
    private CommunityPost communityPost;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity userEntity;

    @CreationTimestamp
    private Timestamp create_date;
}
