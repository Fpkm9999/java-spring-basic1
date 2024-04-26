package com.example.spring_basic.dto;


import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@ToString // toString 자동으로 만들어줌
@Data // getter setter 자동 생성
@Builder // builder 자동 생성
@AllArgsConstructor // 생성자인데 클래스의 맴버변수 매개변수로 만들어줌
@NoArgsConstructor // void 생성자 만들어줌
public class TodoDTO {
    private Long tno;

    @NotEmpty // null, 빈문자열 불가
    private String title;

    @Future // 현재 보다 미래인가? todo는 앞으로의 할일이므로 이전날짜는 못들어옴
    private LocalDate dueDate;

    private boolean finished;

    @NotEmpty
    private String writer;
}
