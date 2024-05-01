package com.example.spring_basic.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.index.qual.Positive;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Arrays;

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

    // 검색 조회 기능
    private String link;
    private String[] types; // 검색 경우의 수 1) title 2) writer 3) title, writer
    private String keyword; // 검색어
    private boolean finished;
    private LocalDate from;
    private LocalDate to;


    public int getSkip() {
        return (page - 1) * size;
    }

    public String getLink() {
        StringBuilder builder = new StringBuilder();
        builder.append("page=" + this.page);
        builder.append("&size=" + this.size);

        if (this.finished) {
            builder.append("&finished=on");
        }
        if (this.types != null && this.types.length > 0) {
            for (int i = 0; i < this.types.length; i++) {
                builder.append("&types=" + types[i]);
            }
        }
        if (this.keyword != null) {
            builder.append("&keyword=" + URLEncoder.encode(keyword, StandardCharsets.UTF_8));
        }
        if (this.from != null) {
            builder.append("&from=" + from.toString());
        }
        if (this.to != null) {
            builder.append("&to=" + to.toString());
        }

        //
        return builder.toString();
    }

    public boolean checkType(String type) {
        if (this.types == null || this.types.length == 0) {
            return false;
        }
        return Arrays.asList(this.types).contains(type);
    }

}
