package com.example.spring_basic.mapper;

import com.example.spring_basic.domain.MemberVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;


@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml") // 스프링 설정 파일 위치 지정
class MemberMapperTest {

    @Autowired (required = false)
    private MemberMapper memberMapper;

    @Test
    public void testInsert(){
        MemberVO memberVO = MemberVO.builder()
                .memberId("sssss")
                .passwd("1111")
                .name("ohsebin")
                .email("fpkm999@naver.com")
                .phone("01048072708")
                .zipcode("11123")
                .address1("율하동로24길42")
                .address2("옹옹송송송파트아3번지303호")
                .build();

        memberMapper.insert(memberVO);

        log.info(memberVO);

    }
    @Test
    public void testSelectOne(){
        MemberVO memberVO = MemberVO.builder().memberId("aaaa").passwd("aaaa").build();

        log.info(memberMapper.selectOne(memberVO));
    }


}