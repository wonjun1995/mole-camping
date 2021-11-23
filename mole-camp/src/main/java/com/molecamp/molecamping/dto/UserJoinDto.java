package com.molecamp.molecamping.dto;

import com.molecamp.molecamping.entity.user.UserEntity;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
public class UserJoinDto {

    @NotBlank(message = "아이디를 입력해주세요.")
    private String username;
    @NotBlank(message = "비밀번호를 입력해주세요")
    @Size(min = 4,max = 10,message = "비밀번호는 4자 이상 10자 이하로 입력해주세요.")
    private String password;

    public UserJoinDto(UserEntity entity) {
        this.username = entity.getUsername();
        this.password = entity.getPassword();
    }
}
