package com.example.spring_basic.domain;


import lombok.*;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
    private String  memberId; // 아이디
    private String passwd; // 비밀번호
    private String name; // 이름
    private String email; // 이메일
    private String phone; // 휴대폰 번호
    private String zipcode; // 우편번호
    private String address1; // 주소1
    private String address2; // 주소2
}
