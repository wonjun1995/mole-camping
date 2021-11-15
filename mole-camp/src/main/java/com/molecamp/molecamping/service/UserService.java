package com.molecamp.molecamping.service;

import com.molecamp.molecamping.entity.user.RoleType;
import com.molecamp.molecamping.entity.user.User;
import com.molecamp.molecamping.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Transactional
    public void join(@RequestBody User user) {
        String rawPassword=user.getPassword();
        String encPassword= encoder.encode(rawPassword);
        user.setPassword(encPassword);
        user.setRole(RoleType.USER);

        try {
            userRepository.save(user);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("userService:회원가입(): "+e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    public int idcheck(String username) {
        int count=0;
        count=(int) userRepository.findByUsername(username).stream().count();
        return count;
    }
}
