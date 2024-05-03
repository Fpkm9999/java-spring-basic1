package com.example.spring_basic.service;

import com.example.spring_basic.dto.BoardDTO;
import com.example.spring_basic.dto.PasswdDTO;

import java.util.List;

/**
 * 게시판 관련 서비스의 인터페이스를 정의 합니다.
 * <br>
 * 이 인터페이스는 게시판 데이터에 대한 기본적인 CRUD 작업을 수행합니다.
 */
public interface BoardService {

    /**
     * 새로운 게시글을 등록합니다.
     *
     * @param boardDTO 등록할 게시글 정보가 담긴 DTO 객체<br>
     * ✅ 테스트 완료
     */
    void register(BoardDTO boardDTO);

    /**
     * 모든 게시글의 목록을 조회합니다.
     * <br>
     * @return : 게시글 DTO 객체의 리스트를 반환합니다.<br><br>
     *
     * ⚠️리스트인 이유 : DTO 객체를 여러 개를 가져오기 위해서 리스트타입을 사용.<br><br>
     * ✅ 테스트 완료.
     */
    List<BoardDTO> getAll();

    /**
     * 게시물에서 원하는 번호(no)의 게시물을 조회.<br>
     * @return 게시글 DTO 객체를 반환.<br><br>
     *
     * ✅ 테스트 완료.
     */
    public abstract BoardDTO getOne(Integer no);

    /**
     * 게시물에서 특정 게시물을 수정.
     * @param boardDTO
     */
    public abstract void modify(BoardDTO boardDTO);

    /**
     * 게시물 삭제
     * @param no
     */
    void removeOne(Integer no);

    /**
     * BoardMapper의 selectOneByPasswd() 를 호출해서 비밀번호가 맞는지 여부를 반환
     * @param passwdDTO
     * @return boolean
     */
    boolean isCurrentPasswd(PasswdDTO passwdDTO);





}
