package com.fastcampus.ch4.dao;


import com.fastcampus.ch4.domain.MemberVO;

public interface MemberDao {

    // 회원가입
    public void register(MemberVO vo) throws Exception;
}