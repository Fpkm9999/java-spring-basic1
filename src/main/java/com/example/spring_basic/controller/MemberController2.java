//package com.example.spring_basic.controller;
//
//
//import com.example.spring_basic.dto.LoginDTO;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@Log4j2
//@RequestMapping("/member")
//public class MemberController2 {
//
//    @GetMapping("/login")
//    public void login() {
//        log.info("login 페이지 접근");
//
//    }
//
//    @PostMapping("/login")
//    public String loginPost(LoginDTO loginDTO) {
//        log.info("로그인 post 페이지");
//        log.info("MemberID : " + loginDTO.getMemberId());
//        log.info("MemberPass : " + loginDTO.getMemberPass());
//
//        log.info(loginDTO);
//
//        if (loginDTO.getMemberId().equals("admin") && loginDTO.getMemberPass().equals("1111")) {
////            return "redirect:/success";
//            return "redirect:/member/success";
//        } else {
//            return "redirect:/member/fail";
//        }
//
//    }
//
//    @GetMapping("/success")
//    public void success() {
//        log.info("로그인 성공 페이지");
//
//    }
//
//    @GetMapping("/fail")
//    public void fail() {
//        log.info("로그인 실패 페이지");
//
//    }
//}
