package com.molecamp.molecamping.entity.campsite;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "existed_campsite")
public class ExitstedCampsite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //주소
    @Column(nullable = false)
    private String addr1;
    //주소상세
    @Column
    private String addr2;
    //전체면적
    @Column
    private Long allar;
    //반려견 출입 가능 여부
    @Column
    private String animalCmgCl;
    //주요시설 자동차야영장
    @Column
    private int autoSiteCo;
    //사업자번호
    @Column
    private String bizrno;
    //화로대
    @Column
    private String brazierCl;
    //개인 카라반 동반 여부(Y/N)
    @Column
    private String caravAcmpnyAt;
    //주요시설 카라반
    @Column
    private int caravSiteCo;
    //자체문화행사 여부(Y,N)
    @Column
    private String clturEventAt;
    //콘텐츠ID
    @Column
    private int contentId;
    //생성날짜
    @Temporal(TemporalType.DATE)
    private Date createdtime;
    //도 이름
    @Column
    private String doNm;
    //켐핑장비 대여
    @Column
    private String eqpmnLendCl;
    //체험프로그램 여부(Y/N)
    @Column
    private String exprnProgrmAt;
    //소화기 개수
    @Column
    private int extshrCo;
    //업체 소유 여부
    @Column
    private String facltDivNm;
    //캠핑장 이름
    @Column
    private String facltNm;
    //특징
    @Column
    @Lob
    private String featureNm;
    //화재감지기 개수
    @Column
    private int fireSensorCo;
    //대표이미지
    @Column
    @Lob
    private String firstImageUrl;
    //방화사 개수
    @Column
    private int frprvtSandCo;
    //방화수 개수
    @Column
    private int frprvtWrppCo;
    //주요시설 글램핑
    @Column
    private int glampSiteCo;
    //주요시설 일반야영장
    @Column
    private int gnrlSiteCo;
    //홈페이지
    @Column
    private String homepage;
    //업종
    @Column
    private String induty;
    //주요시설 개인카라반
    @Column
    private int indvdlCaravSiteCo;
    //영업배상책임보험 가입여부(Y/N)
    @Column
    private String insrncAt;
    //소개
    @Column
    @Lob
    private String intro;
    //입지구분
    @Column
    private String lctCl;
    //한줄소개
    @Column
    private String lineIntro;
    //상주관리인원
    @Column
    private int manageNmpr;
    //운영상태 / 관리 상태
    @Column
    private String manageSttus;
    //운영주체. 관리 주체(직영/위탁)
    @Column
    private String mangeDivNm;
    //경도
    @Column
    private String mapX;
    //위도
    @Column
    private String mapY;
    //운영기관. 관리기관
    @Column
    private String mgcDiv;
    //수정날짜
    @Temporal(TemporalType.DATE)
    private Date modifiedtime;
    //운영기간(평일, 평일+주말,주말)
    @Column
    private String operDeCl;
    //운영계절
    @Column
    private String operPdCl;
    //주변이용가능시설
    @Column
    private String posblFcltyCl;
    //인허가날짜
    @Temporal(TemporalType.DATE)
    private Date prmisnDe;
    //예약구분
    @Column
    private String resveCl;
    //예약 홈페이지
    @Column
    @Lob
    private String resveUrl;
    //부대시설
    @Column
    private String sbrsCl;
    //부대시설 기타
    @Column
    private String sbrsEtc;
    //시군구이름
    @Column
    private String sigunguNm;
    //잔디
    @Column
    private int siteBottomCl1;
    //파쇄석
    @Column
    private int siteBottomCl2;
    //테크
    @Column
    private int siteBottomCl3;
    //자갈
    @Column
    private int siteBottomCl4;
    //맨흙
    @Column
    private int siteBottomCl5;
    //사이트 크기1 수량
    @Column
    private int siteMg1Co;
    //사이트 크기 1 세로
    @Column
    private int siteMg1Vrticl;
    //사이트 크기 1 가로
    @Column
    private int siteMg1Width;
    //사이트 크기 2 수량
    @Column
    private int siteMg2Co;
    //사이트 크기 2 세로
    @Column
    private int siteMg2Vrticl;
    //사이트 크기 2 가로
    @Column
    private int siteMg2Width;
    //사이트 크기 3 수량
    @Column
    private int siteMg3Co;
    //사이트 크기 3 세로
    @Column
    private int siteMg3Vrticl;
    //사이트 크기 3 가로
    @Column
    private int siteMg3Width;
    //사이트 간 거리
    @Column
    private int sitedStnc;
    //샤워실 개수
    @Column
    private int swrmCo;
    //전화번호
    @Column
    private String tel;
    //테마환경
    @Column
    private String themaEnvrnCl;
    //화장실 개수
    @Column
    private int toiletCo;
    //개인 트레일 동반 여부
    @Column
    private String trlerAcmpnyAt;
    //개수대 개수
    @Column
    private int wtrplCo;
    //우편번호
    @Column
    private int zipcode;
    //자체문화행사명
    @Column
    private String clturEvent;
    //체험프로그램명
    @Column
    private String exprnProgrm;
    //글램핑 - 내부시설
    @Column
    private String glampInnerFclty;
    //관광사업자번호
    @Column
    private String trsagntNo;
    //여행시기
    @Column
    private String tourEraCl;
    //길 안내
    @Lob
    private String direction;
    //툴팁
    @Column
    @Lob
    private String tooltip;
    //카라반 - 내부시설
    @Column
    private String caravInnerFclty;
    //휴장기간.휴무기간 시작일
    @Column
    @Temporal(TemporalType.DATE)
    private Date hvofBgnde;
    //휴장기간.휴무기간 종료일
    @Column
    @Temporal(TemporalType.DATE)
    private Date hvofEnddle;
    //주변이용가능시설 기타
    @Column
    private String posblFcltyEtc;
}
