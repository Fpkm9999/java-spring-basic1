package com.example.spring_basic.service;

import com.example.spring_basic.dto.BoardDTO;
import com.example.spring_basic.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
class BoardServiceImplTest {

    @Autowired
    BoardService boardService;

    @Test
    public void testRegister() {
        BoardDTO boardDTO = BoardDTO.builder()
                .title("DTO 서비스 레지스터 테스트2..")
                .content("서비스 내용 테스트2")
                .writer("user01_S")
                .passwd("1111S")
                .build();
        boardService.register(boardDTO);
    }

    @Test
    public void testGetAll() {
        List<BoardDTO> boardDTOList = boardService.getAll();
        for (BoardDTO boardDTO : boardDTOList) {
            log.info(boardDTO);
        }
        log.info("서비스 testGetALl 출력 ");
        boardDTOList.forEach(log::info);
    }
}