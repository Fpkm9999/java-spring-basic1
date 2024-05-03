package com.example.spring_basic.mapper;

import com.example.spring_basic.domain.BoardVO;
import com.example.spring_basic.domain.MemberVO;
import com.example.spring_basic.domain.PasswdVO;

import java.util.List;

/**
 * 게시판 데이터에 대한 데이터베이스 접근을 위한 매퍼 인터페이스입니다.<br>
 * SQL 쿼리를 객체 메소드에 매핑합니다.
 */
public interface BoardMapper {

    /**
     * Create(생성)
     * 게시글을 DB에 등록합니다.<br>
     * VO 객체를 DB에 등록(저장)하기 때문에 반환은 없습니다.<br><br>
     *
     * @param boardVO 데이터베이스에 삽입될 게시글 정보를 담은 VO 객체<br>
     *
     *           ✅ 테스트완료.
*
     */
    void insert(BoardVO boardVO);

    /**
     * Read(읽기)
     * 데이터베이스에 저장된 모든 게시글을 조회합니다.<br><br>
     *
     * @return 모든 게시글 정보를 담은 VO 리스트를 반환<br>
     * ✅ 테스트 완료.
     */
    List<BoardVO> selectAll();

    /**
     * Read2
     * 데이터베이스에 저장된 no번째의 게시글의 조회합니다.<br>
     *
     * @return : 게시글 정보를 담은 VO 객체를 반환.<br>
     * ✅ 테스트 완료.
     */
    abstract BoardVO selectOne(Integer i);

    /**
     * Update(갱신)
     * 데이터베이스에 저장된 게시글의 제목을 클릭 할 때 마다 조회수(hit)를 1을 더합니다.<br>
     * ✅ 테스트 완료.
     */
    abstract void updateHit(Integer no);

    /**
     * Update(갱신)
     * 데이터베이스에 저장된 게시글의 데이터를 수정합니다.<br>
     *
     * 수정되는 변수 :title, content<br>
     * ✅ 테스트 완료.
     */
    abstract void updateOne(BoardVO boardVO);

    /**
     * Delete (삭제)<br>
     * 데이터베이스에 저장된 게시글을 삭제합니다.<br>
     *
     * @param no
     * <br>
     * ✅ 테스트 완료.
     */
    abstract void deleteOne(Integer no);

    abstract BoardVO selectOneByPasswd(PasswdVO passwdVO);

}
