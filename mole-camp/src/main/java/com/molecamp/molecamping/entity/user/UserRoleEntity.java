package com.molecamp.molecamping.entity.user;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_role", uniqueConstraints = {@UniqueConstraint (
        name = "UNIQUE_USERNAME",
        columnNames = {"name", "user_id"})
})
public class UserRoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleType name;    // 권한 이름

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = UserEntity.class)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
}
