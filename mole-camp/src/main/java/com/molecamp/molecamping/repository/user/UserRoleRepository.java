package com.molecamp.molecamping.repository.user;

import com.molecamp.molecamping.entity.user.RoleType;
import com.molecamp.molecamping.entity.user.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity,Long> {
    Optional<UserRoleEntity> findByName(RoleType roleName);
}