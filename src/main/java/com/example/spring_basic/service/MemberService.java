package com.example.spring_basic.service;

import com.example.spring_basic.domain.MemberVO;
import com.example.spring_basic.dto.MemberDTO;

public interface MemberService {
    void register(MemberDTO memberDTO);

    MemberVO selectOne(MemberDTO memberDTO);

    Boolean isMember(MemberDTO memberDTO);
}
