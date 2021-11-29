package com.molecamp.molecamping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// TODO : 소셜 로그인 기능 추가
// TODO : 전화번호 인증 기능 (카카오 인증)
// TODO : 페이징 처리 (페이지가 10개 정도만 보이도록) -> (11/26일 해결완료)
// TODO : 로그인 실패 메시지 (11/26일 해결완료)
// TODO : cannot simultaneously fetch multiple bags 에러 원인 확인 (UserEntity의 roles의 FetchType이 EAGER로 수정하면 에러가 발생하여서 List<UserRoleEntity>를 Set<UserRoleEntity>로 수정함.
// TODO : campingspot,community의 Summernote > uploadImages 기능 대신 파일업로드 기능 따로 추가하여 이미지와 컨텐츠 분리 필요(2021.11.29)
@SpringBootApplication
public class MoleCampApplication {
    public static void main(String[] args) {
        SpringApplication.run(MoleCampApplication.class, args);
    }
}
