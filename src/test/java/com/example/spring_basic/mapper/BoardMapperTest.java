package com.example.spring_basic.mapper;

import com.example.spring_basic.domain.BoardVO;
import com.example.spring_basic.domain.PasswdVO;
import com.example.spring_basic.service.BoardService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

/**
 * BoardMapper 인터페이스의 메소드들을 테스트하기 위한 클래스입니다.<br>
 */
@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml") // 스프링 설정 파일 위치 지정
class BoardMapperTest {

    @Autowired(required = false)
    private BoardMapper boardMapper; // 스프링 컨테이너에서 BoardMapper 빈을 자동 주입

    private BoardService boardService;

    /**
     * 게시판 데이터베이스 삽입 기능을 테스트합니다.<br>
     * BoardVO 객체를 빌더 패턴을 이용하여 생성하고, insert 메소드를 호출하여 DB에 저장합니다.<br>
     * ✅ 테스트 완료.
     */
    @Test
    public void testInsert() {
        // VO를 빌더 패턴을 이용해 객체의 데이터 작성
        BoardVO boardVO = BoardVO.builder()
                .title("Board 테스트 제목11")
                .content("Board 테스트 내용11")
                .writer("user01")
                .passwd("1111")
                .build();

        log.info("boardVO 빌더 패턴 값 : " + boardVO);

        boardMapper.insert(boardVO);
    }

    /**
     * 게시판 데이터베이스에서 모든 게시글을 조회하는 기능을 테스트합니다.<br>
     * selectAll 메소드를 호출하여 결과 리스트를 검증<br>
     * ✅ 테스트 완료.
     */
    @Test
    public void testList() {
        List<BoardVO> BoardVOList = boardMapper.selectAll();

        log.info("BoardVO 리스트 출력 ");
        for (BoardVO board : BoardVOList) {
            log.info(board);
        }
    }

    /**
     * 게시판 데이터베이스에서 특정게시글만 조회하는 기능을 테스트합니다.<br>
     * selectOne()메소드를 호출하여 결과를 검증.<br>
     * ✅ 테스트 완료
     */
    @Test
    public void testSelectOne() {
        BoardVO boardVO = boardMapper.selectOne(31);
        log.info("boardVO select 결과 : " + boardVO);

        //if 만약 생성되지 않은 번호나 삭제되어 빈 no를 조회한다면 어떻게 될까?
        // no가 Integer 타입이므로 null 이 출력된다.
    }

    /**
     * 게시판 데이터베이스에서 특정게시글을 수정하는 기능을 테스트합니다.<br>
     * updateOne()메소드를 호출하여 결과를 검증.
     * ✅ 테스트 완료
     */
    @Test
    public void testUpdateOne() {
        int no = 12;
        BoardVO boardVO = BoardVO.builder()
                .no(no)
                .title("제목 수정3 update Mapper")
                .content("내용 수정3 update Mapper")
                .build();

        boardMapper.updateOne(boardVO);

        log.info(boardMapper.selectOne(no));
    }

    /**
     * 게시판 데이터베이스에서 특정게시글을 삭제하는 기능을 테스트합니다.<br>
     * deleteOne() 메소드를 호출하여 결과를 검증합니다.<br><br>
     *
     * ✅ 테스트 완료
     */
    @Test
    public void testDeleteOne() {
        Integer no = 21;
        BoardVO boardVO = boardMapper.selectOne(no);

        log.info("selectOne 테스트 : "+boardVO);
        // no = 15,16,17,18,19,20,21 삭제함.

        boardMapper.deleteOne(no);

        boardVO =boardMapper.selectOne(no);
        log.info("삭제 결과(null:정상) : "+boardVO);

        // 정상 출력  : 삭제 결과(null:정상) : null
    }

    @Test
    public void testSelectOneByPasswd(){
        PasswdVO passwdVO = PasswdVO.builder()
                .no(31)
                .passwd("1111").build();
        BoardVO boardVO = boardMapper.selectOneByPasswd(passwdVO);

        log.info(boardVO);

        // 틀린경우 null 값
    }
}
