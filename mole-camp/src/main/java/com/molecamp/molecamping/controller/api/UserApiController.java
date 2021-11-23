package com.molecamp.molecamping.controller.api;

import com.molecamp.molecamping.dto.ResponseDto;
import com.molecamp.molecamping.entity.user.User;
import com.molecamp.molecamping.service.main.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

    @Autowired
    private UserService userService;

    @PostMapping("/auth/joinProc" )
    public ResponseDto<Integer> save(User user){   //username,password,email
        System.out.println("UserApiController: save 호출됨");

        userService.join(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    //회원가입 시 아이디 중복확인
    @PostMapping("/auth/joinProc/idcheck")
    public int idCheck(String username) throws Exception{
        int count=0;
        count=userService.idcheck(username);
        return count;
    }

}
