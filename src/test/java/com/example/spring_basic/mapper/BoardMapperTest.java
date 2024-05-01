package com.example.spring_basic.mapper;

import com.example.spring_basic.domain.BoardVO;
import com.example.spring_basic.dto.BoardDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@ExtendWith(SpringExtension.class) // 이거 todo1
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
class BoardMapperTest {

    @Autowired(required = false)
    private BoardMapper boardMapper;


    // DB insert TEST
    @Test
    public void testInsert() {
        // VO를 빌더 패턴을 이용해 객체의 데이터 작성
        BoardVO boardVO = BoardVO.builder()
                .title("Board 테스트 제목5")
                .content("Board 테스트 내용5")
                .writer("user01")
                .passwd("1111")
                .build();

        log.info("boardVO 빌더 패턴 값 : " + boardVO);

        boardMapper.insert(boardVO);
    }

    @Test
    public void testList() {
        List<BoardVO> BoardVOList = boardMapper.selectAll();

        log.info("BoardVO 리스트 출력 ");
        for (BoardVO boardVO : BoardVOList) {
            log.info(boardVO);
        }
    }


}