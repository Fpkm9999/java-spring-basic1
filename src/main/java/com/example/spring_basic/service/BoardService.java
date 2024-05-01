package com.example.spring_basic.service;

import com.example.spring_basic.dto.BoardDTO;

import java.util.List;

public interface BoardService {

    //
    void register(BoardDTO boardDTO);

    List<BoardDTO> getAll();

}
