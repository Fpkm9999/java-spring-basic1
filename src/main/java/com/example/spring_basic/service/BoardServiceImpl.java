package com.example.spring_basic.service;

import com.example.spring_basic.domain.BoardVO;
import com.example.spring_basic.domain.PasswdVO;
import com.example.spring_basic.domain.TodoVO;
import com.example.spring_basic.dto.BoardDTO;
import com.example.spring_basic.dto.PageRequestDTO;
import com.example.spring_basic.dto.PasswdDTO;
import com.example.spring_basic.dto.TodoDTO;
import com.example.spring_basic.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 게시판 관련 비즈니스 로직을 처리하는 서비스 클래스입니다.<br>
 * BoardService 인터페이스를 구현합니다.
 */
@Log4j2
@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper; // 게시판 데이터를 처리하기 위한 MyBatis 매퍼
    private final ModelMapper modelMapper; // 객체 간의 매핑을 돕는 ModelMapper

    /**
     * 새로운 게시글을 데이터베이스에 등록합니다.<br>
     * 객체 전달 : DTO -> VO
     * DTO에서 VO로의 변환 과정을 ModelMapper를 통해 자동화합니다.
     *
     * @param boardDTO 게시글 등록에 필요한 데이터를 담은 DTO
     */
    @Override
    public void register(BoardDTO boardDTO) {
        log.info("boardDTO 객체 : " + boardDTO); // DTO 객체 테스트

        // DTO를 VO로 매핑하고 데이터베이스에 삽입
        BoardVO boardVO = modelMapper.map(boardDTO, BoardVO.class);
        log.info("boardVO 객체 : " + boardVO); // VO 객체 테스트

        boardMapper.insert(boardVO); //
    }

    /**
     * 데이터베이스에서 모든 게시글을 조회하고, 그 결과를 DTO 리스트로 반환합니다.<br>
     * VO 객체들을 DTO 객체로 변환하는 과정을 포함합니다.<br>
     * VO 객체 -> DTO 객체로 매핑
     *
     * @return 게시글 정보를 담은 DTO 객체 리스트
     */
    @Override
    public List<BoardDTO> getAll() {
        List<BoardVO> boardVOList = boardMapper.selectAll();
        List<BoardDTO> boardDTOList = new ArrayList<>();

        for (BoardVO boardVO : boardVOList) {
            // 개별 VO 객체를 DTO 객체로 매핑
            BoardDTO boardDTO = modelMapper.map(boardVO, BoardDTO.class);
            boardDTOList.add(boardDTO); // boardDTOList에 요소를 추가.
        }

        return boardDTOList;
    }


    /**
     * @param no
     * @return 게시글 정보를 담은 DTO 객체 1개
     */
    @Override
    public BoardDTO getOne(Integer no) {

        boardMapper.updateHit(no);

        BoardVO boardVO = boardMapper.selectOne(no);

        // VO 객체를 DTO 객체로 매핑 후 반환
        return modelMapper.map(boardVO, BoardDTO.class);
    }

    @Override
    public void modify(BoardDTO boardDTO) {
        log.info(boardDTO);

        BoardVO boardVO = modelMapper.map(boardDTO, BoardVO.class);

        log.info(boardVO);

        boardMapper.updateOne(boardVO);
    }

    @Override
    public void removeOne(Integer no) {
        log.info(boardMapper.selectOne(no));

        boardMapper.deleteOne(no);
    }

    @Override
    public boolean isCurrentPasswd(PasswdDTO passwdDTO) {
        log.info(passwdDTO);

        // DTO -> VO 변환
        PasswdVO passwdVO = modelMapper.map(passwdDTO, PasswdVO.class);

//        boardMapper.selectOneByPasswd(passwdVO);

//        log.info(passwdVO);

        return boardMapper.selectOneByPasswd(passwdVO) != null;

    }


}
