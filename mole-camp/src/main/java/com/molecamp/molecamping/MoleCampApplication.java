package com.molecamp.molecamping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// TODO : 소셜 로그인 기능 추가 -> 카카오 로그인 추가 완료
// TODO : 페이징 처리 (페이지가 10개 정도만 보이도록) -> (11/26일 해결완료)
// TODO : 로그인 실패 메시지 (11/26일 해결완료)
// TODO : cannot simultaneously fetch multiple bags 에러 원인 확인 (UserEntity의 roles의 FetchType이 EAGER로 수정하면 에러가 발생하여서 List<UserRoleEntity>를 Set<UserRoleEntity>로 수정함.
// TODO : campingspot,community의 Summernote > uploadImages 기능 대신 파일업로드 기능 따로 추가하여 이미지와 컨텐츠 분리 필요(2021.11.29)
// TODO : campingSpot > Category -> 지역별 검색 기능 만들어야 하는데 Region_1depth_name의 정확한 정보를 찾지 못하여 테이블 생성을 못함. 해결 필요
// TODO : 캠핑장 > 길찾기 기능 개발 필요(2021.12.07) -> 카카오맵 길찾기api 링크 사용하여 개발 완료 (2021.12.07)
// TODO : 배포 시 외부파일(이미지) 안보임(2021.12.14) ->외부경로 재설정 완료(2021.12.15)
@SpringBootApplication
public class MoleCampApplication {
    public static void main(String[] args) {
        SpringApplication.run(MoleCampApplication.class, args);
    }
}
