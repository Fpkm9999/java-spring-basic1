package com.example.spring_basic.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.index.qual.Positive;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {

    @Builder.Default
    @Min(value = 1) // 최소값
    @Positive
    private int page = 1; // 현재 페이지 값 외부에서 getter로 읽음
    // 페이지 값이 없을 경우 디폴트 값을 1로 한다.

    @Builder.Default
    @Min(value = 10) // 최소 10개
    @Max(value = 100) // 최대 100개 의 데이터만 보여줄 수 있도록 설정
    @Positive // 양수만
    private int size = 10; // 최대 페이지 당 보여줄 개수
    // limit 로 치면 size는 뒤에 꺼임
    public int getSkip() {
        return (page - 1) * size;
    }



}
