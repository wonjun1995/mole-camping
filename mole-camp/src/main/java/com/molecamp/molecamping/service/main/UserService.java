package com.molecamp.molecamping.service.main;

import com.molecamp.molecamping.entity.user.RoleEntity;
import com.molecamp.molecamping.entity.user.RoleType;
import com.molecamp.molecamping.entity.user.UserEntity;
import com.molecamp.molecamping.repository.main.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Transactional
    public void join(@RequestBody UserEntity userEntity) {
        String rawPassword= userEntity.getPassword();
        String encPassword= encoder.encode(rawPassword);

        // 캠퍼 권한 설정
        List<RoleEntity> roles = new ArrayList<>();
        RoleEntity camperRole = new RoleEntity();
        camperRole.setName(RoleType.ROLE_CAMPER);
        roles.add(camperRole);

        userEntity.setPassword(encPassword);
        userEntity.setRoles(roles);

        try {
            userRepository.save(userEntity);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Transactional(readOnly = true)
    public int idcheck(String username) {
        int count=0;
        count=(int) userRepository.findByUsername(username).stream().count();
        return count;
    }
}
