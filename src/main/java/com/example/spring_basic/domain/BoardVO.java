package com.example.spring_basic.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardVO {
    private Integer no; // 글 번호
    private String title; // 제목
    private String content; // 본문
    private String writer; // 작성자
    private String passwd; // 비밀번호
    private LocalDate addDate; // 작성일
    private Integer hit; // 조회수
}
