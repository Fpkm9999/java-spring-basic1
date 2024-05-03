package com.example.spring_basic.service;

import com.example.spring_basic.dto.PageRequestDTO;
import com.example.spring_basic.dto.PageResponseDTO;
import com.example.spring_basic.dto.TodoDTO;

import java.util.List;

public interface TodoService {
    void register(TodoDTO todoDTO);

//    List<TodoDTO> getAll();

    // 페이징 처리를 위한 메소드
    PageResponseDTO<TodoDTO> getList(PageRequestDTO pageResponseDTO);

    public abstract TodoDTO getOne(Long tno);

    void remove(Long tno);

    void modify(TodoDTO todoDTO); // TodoDTO객체를 전달
}
