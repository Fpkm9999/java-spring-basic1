package com.example.spring_basic.service;

import com.example.spring_basic.domain.MemberVO;
import com.example.spring_basic.dto.MemberDTO;
import com.example.spring_basic.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService{


    private final MemberMapper memberMapper;
    private final ModelMapper modelMapper;
    @Override
    public void register(MemberDTO memberDTO) {
        log.info("MemberDTO 객체 정보 : "+memberDTO);

        MemberVO memberVO = modelMapper.map(memberDTO, MemberVO.class);

        memberMapper.insert(memberVO);

    }

    @Override
    public MemberVO selectOne(MemberDTO memberDTO) {
        return null;
    }

    @Override
    public Boolean isMember(MemberDTO memberDTO) {
        return null;
    }

}
