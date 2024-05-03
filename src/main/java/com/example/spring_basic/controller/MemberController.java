package com.example.spring_basic.controller;


import com.example.spring_basic.dto.LoginDTO;
import com.example.spring_basic.dto.MemberDTO;
import com.example.spring_basic.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Log4j2
@RequestMapping("/member")
@RequiredArgsConstructor // 생성자 주입을 통해 필수 의존성을 자동 주입받습니다.
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/register")
    public void register() {
        log.info("register 페이지 Get");
    }

    @PostMapping("/register")
    public String registerPost(MemberDTO memberDTO) {
        log.info("registerPost() 진입");
        log.info("MemberDTO 객체 정보 " + memberDTO);

        memberService.register(memberDTO);
        return "/member/login";
    }

    @PostMapping("/login")
    public String loginPost(LoginDTO loginDTO, HttpServletRequest request) {
        log.info("...login()");
        log.info(loginDTO);

        MemberDTO memberDTO = MemberDTO.builder()
                .memberId(loginDTO.getMemberId())
                .passwd(loginDTO.getMemberPass())
                .build();
        if (memberService.isMember(memberDTO)) {
            HttpSession session = request.getSession();
            session.setAttribute("memberId", loginDTO.getMemberId());
            return "redirect:/member/modify";
        } else {
            return "redirect:/memeber/login";
        }

    }
}
