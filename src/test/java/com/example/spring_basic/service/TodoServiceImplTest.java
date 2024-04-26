package com.example.spring_basic.service;

import com.example.spring_basic.domain.TodoVO;
import com.example.spring_basic.dto.PageRequestDTO;
import com.example.spring_basic.dto.PageResponseDTO;
import com.example.spring_basic.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
class TodoServiceImplTest {

    @Autowired
    private TodoService todoService;

    @Test
    public void testRegister() {
        TodoDTO todoDTO = TodoDTO.builder()
                .title("TestTitle...")
                .dueDate(LocalDate.now())
                .writer("user01")
                .build();
        todoService.register(todoDTO);
    }

//    @Test
//    public void testGetAll() {
        // 테스트 대상은 getAll
//        List<TodoDTO> todoDTO = todoService.getAll();
//
//        log.info("fpkm999");
//        log.info(todoDTO);

//        List<TodoDTO> TodoDTOList = todoService.getAll();


//        log.info(test);

//
//        // case 1
//        log.info("999");
//        for (TodoDTO i : TodoDTOList) {
//            log.info(i);
////            System.out.println(i);
//        }
//        // case 2
//        log.info("100");
//        TodoDTOList.forEach(item -> log.info(item));
//    }

    @Test
    public void testModify() {

        Long tno = 7L;
        log.info(todoService.getOne(tno));
//        log.info(todoMapper.selectOne(tno));

        TodoDTO todoDTO = TodoDTO.builder() // 빌더를 이용해서 TOdoVO 객체를 생성
                .tno(tno)
                .title("수정7L")
                .dueDate(LocalDate.of(2024, 04, 28))
                .finished(true)
                .build();
        todoService.modify(todoDTO);
//        todoMapper.update(todoVO);
        log.info(todoService.getOne(tno));
    }

    @Test
    public void pagingTest() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();
        PageResponseDTO<TodoDTO> pageResponseDTO = todoService.getList(pageRequestDTO);

        log.info(pageResponseDTO);

        for (TodoDTO todoDTO : pageResponseDTO.getDtoList()) {
            log.info(todoDTO);
        }

    }


}