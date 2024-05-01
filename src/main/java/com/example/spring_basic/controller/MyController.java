package com.example.spring_basic.controller;

import com.example.spring_basic.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@Log4j2
public class MyController {

    @GetMapping("/test01")
    public void test1(){
        log.info("test01 페이지 접속");


    }

    @PostMapping("/test02")
    public void test2(TodoDTO todoDTO, String title, String dueDate, String writer, String finished, Model model){
        log.info("test02 결과 페이지 접속");
        log.info("----------------");
        log.info(title);
        log.info(dueDate);
        log.info(writer);
        log.info(finished);
        log.info("----------------");
        log.info(todoDTO);
        model.addAttribute("title", title);
        model.addAttribute("dueDate", dueDate);
        model.addAttribute("writer", writer);
        model.addAttribute("finished", finished);

    }

}
