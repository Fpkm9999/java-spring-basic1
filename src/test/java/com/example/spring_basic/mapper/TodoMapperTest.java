package com.example.spring_basic.mapper;

import com.example.spring_basic.domain.TodoVO;
import com.example.spring_basic.dto.PageRequestDTO;
import com.example.spring_basic.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
class TodoMapperTest {

    @Autowired(required = false)
    private TodoMapper todoMapper;

    @Test
    public void testGetTimer() {
        log.info(todoMapper.getTime());
    }

    @Test
    public void testInsert() {
        TodoVO todoVO = TodoVO.builder() // 빌더를 이용해서 TOdoVO 객체를 생성
                .title("스프링 테스트")
                .dueDate(LocalDate.of(2022, 10, 10))
                .writer("user00")
                .build();
        todoMapper.insert(todoVO);
    }

    @Test
    public void testList() {
        List<TodoVO> TodoVOList = todoMapper.selectAll();
//        log.info(test);
        // case 1
        for (TodoVO i : TodoVOList) {
//            log.info(i);
            System.out.println(i);
        }
        // case 2
        TodoVOList.forEach(item -> log.info(item));
    }

    @Test
    public void testSelectOne() {
        TodoVO todoVO = todoMapper.selectOne(2L); // 실제 있는 tno 값이어야 한다. // 2번 Long 타입
        log.info(todoVO);
    }

    @Test
    public void testDelete() {
        // 1) tno로 데이터를 반환해서 정상 출력 확인
        // 2) 삭제
        // 3) 다시 tno로 데이터를 반환해서 삭제 환인.
        Long tno = 3L;
        TodoVO todoVO = todoMapper.selectOne(tno);
        log.info(todoVO);

        todoMapper.delete(tno);

        todoVO = todoMapper.selectOne(tno);
        log.info(todoVO); // null 이 나와야 삭제된거임
    }

    @Test
    public void testUpdate() {
        Long tno = 7L;
        log.info(todoMapper.selectOne(tno));

        TodoVO todoVO = TodoVO.builder() // 빌더를 이용해서 TOdoVO 객체를 생성
                .tno(tno)
                .title("수정7L")
                .dueDate(LocalDate.of(2024, 04, 28))
                .finished(true)
                .build();
        todoMapper.update(todoVO);
        log.info(todoMapper.selectOne(tno));
    }

    @Test
    public void testSelectList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(6) // 현재페이지
                .size(20) // 페이지당 데이터 개수
                .build();
        List<TodoVO> todoVOList = todoMapper.selectList(pageRequestDTO);

        for (TodoVO todoVO : todoVOList) {
            log.info(todoVO);
//            System.out.println(i);
        }
    }
//    @Test
//    public void testGetCount(){
//        log.info(todoMapper.getCount(PageRequestDTO.builder().build()));
//    }

    @Test
    public void testGetCount() {
        log.info(todoMapper.getCount(PageRequestDTO.builder().build()));
    }


    @Test
    public void testSelectSearch() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
//                .types(new String[]{"t", "w"})
//                .types(new String[]{"t", "w"})
//                .keyword("김전일")
                .from(LocalDate.parse("2024-05-01"))
                .to(LocalDate.parse("2024-05-05"))
//                .finished(true)
                .build();
        List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);
        voList.forEach(vo -> log.info(vo));

        log.info("-----getCoount()-----");
        log.info(todoMapper.getCount(pageRequestDTO));
    }

}