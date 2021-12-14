package com.molecamp.molecamping.service.user;

import com.molecamp.molecamping.entity.user.UserRoleEntity;
import com.molecamp.molecamping.entity.user.RoleType;
import com.molecamp.molecamping.entity.user.UserEntity;
import com.molecamp.molecamping.repository.user.UserRepository;
import com.molecamp.molecamping.repository.user.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Transactional
    public void join(@RequestBody UserEntity userEntity) {
        String rawPassword= userEntity.getPassword();
        String encPassword= encoder.encode(rawPassword);
        userEntity.setPassword(encPassword);

        // 캠퍼 권한 설정
        UserRoleEntity camperRole = new UserRoleEntity();
        camperRole.setName(RoleType.ROLE_CAMPER);
        camperRole.setUser(userEntity);

        try {
            userRepository.save(userEntity);
            userRoleRepository.save(camperRole);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Transactional
    public UserEntity validateJoin(String username){
        UserEntity userEntity = userRepository.findByUsername(username).orElseGet(()->{
            return new UserEntity();
        });
        return userEntity;
    }

    @Transactional(readOnly = true)
    public int idcheck(String username) {
        int count=0;
        count=(int) userRepository.findByUsername(username).stream().count();
        return count;
    }
}
