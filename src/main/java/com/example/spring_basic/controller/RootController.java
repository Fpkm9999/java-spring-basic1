package com.example.spring_basic.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 웹 어플리케이션의 루트 URL에 대한 요청을 처리하는 Spring MVC 컨트롤러입니다.<br>
 * 이 컨트롤러는 톰캣 서버가 시작될 때 홈 URL로 바로 접속하게 하여 사용자를 게시판 리스트 페이지로 리다이렉트 합니다.<br><br>
 *
 * {@link org.springframework.stereotype.Controller} 어노테이션은 이 클래스가 컨트롤러 역할을 함을 나타내며,<br>
 * {@link org.springframework.web.bind.annotation.RequestMapping} 어노테이션은 이 컨트롤러의 기본 경로가 '/'임을 명시합니다.
 */
@Controller
@Log4j2
@RequestMapping("/")
public class RootController {
    /**
     * 루트 URL('/')에 대한 GET 요청을 처리하고, 사용자를 '/board/list'로 리다이렉트합니다.
     *
     * @return 리다이렉트할 타깃 URL을 문자열로 반환합니다.
     */
    @GetMapping("/")
    public String root() {
        return "redirect:/board/list";
    }
}
