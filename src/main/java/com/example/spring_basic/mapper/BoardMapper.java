package com.example.spring_basic.mapper;

import com.example.spring_basic.domain.BoardVO;
import com.example.spring_basic.domain.TodoVO;

import java.util.List;

public interface BoardMapper {

    // DB 등록
    public abstract void insert(BoardVO boardVO);

    public abstract List<BoardVO> selectAll();

}
