package com.molecamp.molecamping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// TODO : 소셜 로그인 기능 추가
// TODO : 전화번호 인증 기능 (카카오 인증)
// TODO : 페이징 처리 (페이지가 10개 정도만 보이도록)
@SpringBootApplication
public class MoleCampApplication {
    public static void main(String[] args) {
        SpringApplication.run(MoleCampApplication.class, args);
    }
}
