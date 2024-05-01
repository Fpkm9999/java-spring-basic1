package com.example.spring_basic.dto;


import lombok.*;

import java.time.LocalDate;

@Builder
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
    private Integer no; // 글 번호
    private String title; // 제목
    private String content; // 본문
    private String writer; // 작성자
    private String passwd; // 비밀번호
    private LocalDate addDate; // 작성일
    private Integer hit; // 조회수
}
