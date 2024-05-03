package com.example.spring_basic.mapper;

import com.example.spring_basic.domain.MemberVO;
import com.example.spring_basic.dto.MemberDTO;

public interface MemberMapper {


    /**
     * 2. MemberMapper인터페이스 생성 후 메서드 선언
     * @param memberVO
     */
    abstract void insert(MemberVO memberVO);

    abstract MemberVO selectOne(MemberVO memberVO);

}
