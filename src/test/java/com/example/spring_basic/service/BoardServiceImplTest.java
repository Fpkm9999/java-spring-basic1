package com.example.spring_basic.service;

import com.example.spring_basic.domain.PasswdVO;
import com.example.spring_basic.dto.BoardDTO;
import com.example.spring_basic.dto.PasswdDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * BoardServiceImpl의 기능을 테스트하는 클래스입니다.
 */
@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
class BoardServiceImplTest {

    @Autowired
    private BoardService boardService;

    /**
     * 게시글 등록 기능을 테스트하는 메소드입니다.<br>
     * 새로운 BoardDTO 객체를 생성하고, register 메소드를 통해 게시글을 등록합니다.<br>
     * 등록 로직이 정상적으로 수행되는지 확인합니다.<br>
     * <br>
     * ✅ 테스트완료.
     */
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

    /**
     * 게시글 전체 조회 기능을 테스트하는 메소드입니다.<br>
     * ✅ 테스트완료.
     */
    @Test
    public void testGetAll() {
        List<BoardDTO> boardDTOList = boardService.getAll();
        boardDTOList.forEach(log::info); // 각 게시글의 정보를 로깅
        log.info("서비스 testGetAll 출력 완료.");
    }

    /**
     * 특정 게시글 조회 기능을 테스트하는 메소드입니다.<br><br>
     * <p>
     * ✅ 테스트완료.
     */
    @Test
    public void testGetOne() {
        BoardDTO boardDTO = boardService.getOne(23);
        log.info("게시글 조회 정보 GetOne(): " + boardDTO);
    }

    /**
     * 게시글 수정 기능을 테스트하는 메소드입니다.<br>
     * 지정된 게시글 번호(no)에 해당하는 게시글의 정보를 수정합니다.<br>
     * 수정된 게시글 정보를 로깅하여 수정 로직이 정상적으로 수행되었는지 확인합니다.<br>
     * <br>
     * ✅ 테스트완료.
     */
    @Test
    public void testModify() {
        int no = 6;
        log.info(boardService.getOne(no));

        BoardDTO boardDTO = BoardDTO.builder()
                .no(no)
                .title("modify 테스트 제목3 서비스layer")
                .content("modify 내용2")
                .build();

        log.info("빌더 테스트 : " + boardDTO);
        boardService.modify(boardDTO);
        log.info("modify 테스트 : " + boardDTO);
    }

    /**
     * 게시글 삭제 기능을 테스트하는 메소드입니다.<br>
     * 삭제 로직이 정상적으로 수행되었는지를 확인하기 위해 삭제 후 해당 게시글을 다시 조회합니다.<br>
     */
    @Test
    public void testRemoveOne() {
        int no = 26;  // 삭제할 게시글 번호

        BoardDTO boardDTO = boardService.getOne(no);

        log.info("삭제 전 : " + boardDTO);

        boardService.removeOne(no);

//        log.info("삭제 후 값 : " + boardService.getOne(26));


    }


    /**
     *
     */

    @Test
    public void testIsCurrentPasswd() {
        PasswdDTO passwdDTO = PasswdDTO.builder()
                .no(31)
                .passwd("1111")
                .build();


        log.info("testIsCurrentPasswd() 결과 : " + boardService.isCurrentPasswd(passwdDTO));
    }


}
