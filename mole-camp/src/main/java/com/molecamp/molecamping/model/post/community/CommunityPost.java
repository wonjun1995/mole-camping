package com.molecamp.molecamping.model.post.community;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.molecamp.molecamping.model.common.Category;
import com.molecamp.molecamping.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CommunityPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,length = 100)
    private String title;

    @Lob    //대용량 데이터
    private String content; //섬머노트 라이브러리 <html>태그가 섞여서 디자인 됨

    private int count;  //조회수

    // Board가 Many, User는 One 한명의 유저는 여러 개의 게시글을 쓸 수 있다.
    @ManyToOne(fetch = FetchType.EAGER) //Many=Many, User=one
    @JoinColumn(name="userId")
    private User user;  //DB는 오브젝트를 저장할 수 없다. FK,자바는 오브젝트를 저장할 수 있다.

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="categorytypeId")
    private Category category;

    //그냥 값을 얻기 위해 board와 매핑하는 거
    @OneToMany(mappedBy = "communityPost",fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)  //mappedBy 연관관계의 주인이 아니다.(FK가 아니다) DB에 칼럼을 만들지 마라.
    @JsonIgnoreProperties({"CommunityPost"})
    @OrderBy("id desc")
    private List<CommunityComment> reply = new ArrayList<>();

    @CreationTimestamp
    private Timestamp createDate;
}
