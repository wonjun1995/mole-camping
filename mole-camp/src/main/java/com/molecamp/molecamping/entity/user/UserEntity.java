package com.molecamp.molecamping.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user", uniqueConstraints = {@UniqueConstraint (
        name = "UNIQUE_USERNAME",
        columnNames = {"username"})
        })
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = "username", nullable = false, unique = true, length = 255)
    private String username;    // 유저의 아이디

    @Column(name = "password", nullable = false, length = 255)
    private String password;    // 비밀번호

    @CreationTimestamp
    @Column(name = "create_date", nullable = false)
    private Timestamp createDate;   // 가입일

    @Column(name = "tel", nullable = false, length = 255)
    private String tel; // 전화번호

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, targetEntity = UserRoleEntity.class)
    @JsonIgnoreProperties({"user"})
    private Set<UserRoleEntity> roles = new HashSet<>();
}
