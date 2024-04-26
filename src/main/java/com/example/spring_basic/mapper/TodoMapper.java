package com.example.spring_basic.mapper;

import com.example.spring_basic.domain.TodoVO;
import com.example.spring_basic.dto.PageRequestDTO;

import java.util.List;

public interface TodoMapper {
    String getTime();

    //
    void insert(TodoVO todoVO);

    // 리스트를 출력하는 메서드 추가
    List<TodoVO> selectAll(); // 반환형 TodoVO . 그리고 All인 이유는 데이터에 저장된 개수를 모두 가져오기 위해

    // DB에서 tno를 가져옴 1개
    TodoVO selectOne(Long tno);

    // DB에 tno를 1개 삭제 (반환 필요 없으므로 void)
    void delete(Long tno);

    // 수정기능추가

    public void update(TodoVO todoVO);

    // 전체를 다 들고 오는게 아니라 페이징 처리해서 들고옴 <-- limit 사용한다.
    List<TodoVO> selectList(PageRequestDTO pageRequestDTO);

    // 전체 게시물 숫자를 찾는 메소드(쿼리요청)
//    int getCount(PageRequestDTO pageRequestDTO);
    int getCount(PageRequestDTO pageRequestDTO);
}
