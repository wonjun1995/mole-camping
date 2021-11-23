package com.molecamp.molecamping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// TODO : 소셜 로그인 기능 추가
// TODO : 전화번호 인증 기능 (카카오 인증)
// TODO : 페이징 처리 (페이지가 10개 정도만 보이도록)
// TODO : 로그인 실패 메시지
// TODO : cannot simultaneously fetch multiple bags 에러 원인 확인 (UserEntity의 roles의 FetchType이 EAGER로 수정하면 에러가 발생하여서 List<UserRoleEntity>를 Set<UserRoleEntity>로 수정함.
@SpringBootApplication
public class MoleCampApplication {
    public static void main(String[] args) {
        SpringApplication.run(MoleCampApplication.class, args);
    }
}
