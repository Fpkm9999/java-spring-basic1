package com.example.spring_basic.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

import java.util.List;



@Getter
@ToString
@Log4j2
public class PageResponseDTO<E> {
    @Builder(builderMethodName ="withAll")
    // PageResponseDTO 을 기준으로 빌더를 작성하기위함.
    // dtoList은 selectList 의 반환값
    // 아래는 빌더를 통해 받을 값들임.
    public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total){
        log.info(pageRequestDTO);
        this.page = pageRequestDTO.getPage();
        this.size = pageRequestDTO.getSize();

        this.total = total;
        this.dtoList = dtoList;

        this.end = (int) (Math.ceil(this.page / 10.0)) * 10;

        this.start = this.end - 9;

        int last = (int)(Math.ceil((total/(double)size)));

        this.end = end > last ? last : end;

        this.prev = this.start > 1;

        this.next = total > this.end * this.size;
    }


    private int page; // 현재 페이지 번호
    private int size; // 페이지당 보여줄 게시물
    private int total; // 전체 게시물 숫자

    // 위 3 개의 변수를 계산해서 아래 4개의 변수에 값을 줄거임.



    // 시작 페이지 번호
    private int start;

    // 끝 페이지 번호
    private int end;

    // 이전 페이지의 존재 여부
    private boolean prev;
    // 다음 페이지의 존재 여부
    private boolean next;

    // TodoDTOList 뿐만 아니라 다른 곳에서 페이징 처리할때도 수정없이 사용하기 위해
    // 제네릭을 사용함
    private List<E> dtoList;


}
