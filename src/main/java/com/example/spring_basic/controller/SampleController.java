package com.example.spring_basic.controller;

import com.example.spring_basic.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Log4j2
@Controller
public class SampleController {
    @GetMapping("/hello")
    public void hello() {
        log.info("hello(_)...");
    }

    @GetMapping("/ex1") // 파라미터를 URL에서 직접 받아 처리
    public void ex1(String name, int age) {
        log.info("ex1()...");
        log.info("name: " + name);
        log.info("age: " + age);
        log.info("T A B I ");
    }

    @GetMapping("/ex2") // RequestParam 어노테이션을 사용하여 파라미터 기본값 지정
    public void ex2(@RequestParam(name = "name", defaultValue = "aaa") String name,
                    @RequestParam(name = "age", defaultValue = "16") int age) {
        log.info("ex2()...");
        log.info("name:" + name);
        log.info("age: " + age);
    }

    @GetMapping("/ex3")
    public void ex3(LocalDate duedate) {
        log.info("ex3()...");
        log.info("dueDate: " + duedate);
    }

    @GetMapping("/ex4")
    public void ex4(Model model) {
        log.info("-----");
        model.addAttribute("message", "Hello World");
    }

    @GetMapping("/ex4_1")
    public void ex4Extra(@ModelAttribute("dto") TodoDTO todoDTO, Model model) {
        log.info(todoDTO);
    }

    @GetMapping("/ex5")
    public String ex5(RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("name","ABC");
        redirectAttributes.addFlashAttribute("result","success");

        return "redirect:/ex6";
    }
    @GetMapping("/ex6")
    public void ex6(){
        log.info("TT A AB I ");
    }

    @GetMapping("/ex7")
    public void ex7(String p1, int p2){
        log.info("p1...." + p1);
        log.info("p2...." + p2);

    }
}
