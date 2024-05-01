package com.example.spring_basic.controller;


import com.example.spring_basic.dto.BoardDTO;
import com.example.spring_basic.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/add")
    public void add() {
        log.info("board/add 페이지 접속 성공");
    }

    // post로 add.jsp에 접근하는 경우
    @PostMapping("/add")
    public String  addPost(BoardDTO boardDTO) {
        log.info("board/add post() 접속 성공!");
        log.info("DTO 값 확인 : "+boardDTO);

        boardService.register(boardDTO);

        return "redirect:/board/list";
    }

    @GetMapping("/list")
    public void list(Model model){
        log.info("list 페이지 접근");

        log.info("BoardDTO list...");
        model.addAttribute("dtoList",boardService.getAll());
    }


}
