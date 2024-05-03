package com.example.spring_basic.dto;

import lombok.*;

import java.time.LocalDate;

/**
 * 게시판 게시물의 데이터 전송 객체(Data Transfer Object)<br>
 * 게시판 게시물의 데이터를 전달하는데 사용되는 객체<br>
 * 데이터베이스 레코드를 클라이언트나 API 사용자에게 전달할 때 사용합니다.<br>
 */
@Builder // 객체의 불변성을 보장하며, 객체 생성 시 필드 설정을 간결하게 도와주는 빌더 패턴을 제공합니다.
@Data // 클래스에 대한 getter, setter, toString, equals, hashCode 메소드를 자동으로 생성합니다.
@ToString // 객체를 문자열로 표현할 때 사용할 toString() 메소드를 자동 생성합니다.
@AllArgsConstructor // 모든 필드를 포함한 생성자를 자동으로 생성합니다.
@NoArgsConstructor // 기본 생성자를 자동으로 생성합니다.
public class BoardDTO {
    private Integer no; // 게시글의 고유 번호
    private String title; // 게시글의 제목
    private String content; // 게시글의 본문 내용
    private String writer; // 게시글의 작성자
    private String passwd; // 게시글에 대한 접근 혹은 수정을 위한 비밀번호
    private LocalDate addDate; // 게시글의 작성 날짜
    private Integer hit; // 게시글의 조회수
}
