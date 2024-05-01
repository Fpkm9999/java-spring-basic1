package com.example.spring_basic.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder // DB와 관련되어서 사용되기에 지금은 필요 없음
@AllArgsConstructor // 위와 같음
@Data // 이건 필수
public class LoginDTO {
    String memberId; // 아이디

    String memberPass; // 비밀번호
}
