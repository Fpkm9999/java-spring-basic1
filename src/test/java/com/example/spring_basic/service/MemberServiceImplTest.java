package com.example.spring_basic.service;

import com.example.spring_basic.dto.MemberDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;



@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
class MemberServiceImplTest {


    @Autowired
    private MemberService memberService;


    @Test
    public void testRegister(){
        MemberDTO memberDTO = MemberDTO.builder()
                .memberId("fpkm9991")
                .passwd("1111")
                .name("fpkm")
                .email("fpkm999@gmail.com")
                .phone("01044444444")
                .zipcode("11155")
                .address1("율하동로24길42번지")
                .address2("삼상오오아파트5단지506호3층")
                .build();

        memberService.register(memberDTO);
        log.info(memberDTO);
    }

}