package com.example.spring_basic.domain;

import lombok.*;

@Getter // 클래스 필드에 대한 getter 메소드를 자동 생성합니다.
@ToString // 클래스의 인스턴스를 문자열로 쉽게 반환할 수 있는 toString 메소드를 자동 생성합니다.
@NoArgsConstructor // 매개변수가 없는 기본 생성자를 자동 생성합니다.
@AllArgsConstructor // 모든 필드 값을 매개변수로 받는 생성자를 자동 생성합니다.
@Builder // 빌더 패턴을 구현하여 객체 생성을 유연하게 할 수 있도록 돕습니다.
public class PasswdVO {
    private int no;
    private String passwd;
}
