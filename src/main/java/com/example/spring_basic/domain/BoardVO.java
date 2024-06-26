package com.example.spring_basic.domain;

import lombok.*;

import java.time.LocalDate;

/**
 * 게시판의 게시물을 나타내는 도메인 객체<br>
 * 이 객체는 데이터베이스의 게시판 테이블에 대응되며, 데이터의 영속성 처리를 위해 사용됩니다.
 */
@Getter // 클래스 필드에 대한 getter 메소드를 자동 생성합니다.
@ToString // 클래스의 인스턴스를 문자열로 쉽게 반환할 수 있는 toString 메소드를 자동 생성합니다.
@NoArgsConstructor // 매개변수가 없는 기본 생성자를 자동 생성합니다.
@AllArgsConstructor // 모든 필드 값을 매개변수로 받는 생성자를 자동 생성합니다.
@Builder // 빌더 패턴을 구현하여 객체 생성을 유연하게 할 수 있도록 돕습니다.
public class BoardVO {
    private Integer no; // 글 번호
    private String title; // 제목
    private String content; // 본문
    private String writer; // 작성자
    private String passwd; // 비밀번호
    private LocalDate addDate; // 작성일
    private Integer hit; // 조회수
}
