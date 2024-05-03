package com.example.spring_basic.dto;

import lombok.*;

@Builder // 객체의 불변성을 보장하며, 객체 생성 시 필드 설정을 간결하게 도와주는 빌더 패턴을 제공합니다.
@Data // 클래스에 대한 getter, setter, toString, equals, hashCode 메소드를 자동으로 생성합니다.
@ToString // 객체를 문자열로 표현할 때 사용할 toString() 메소드를 자동 생성합니다.
@AllArgsConstructor // 모든 필드를 포함한 생성자를 자동으로 생성합니다.
@NoArgsConstructor // 기본 생성자를 자동으로 생성합니다.
public class PasswdDTO {

    private int no;

    private String passwd;

}
