package com.fastcampus.ch4.dao;

import javax.inject.Inject;

import com.fastcampus.ch4.domain.MemberVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao {

    @Inject SqlSession sql;
    // 회원가입

    @Override
    public void register(MemberVO vo) throws Exception {
        sql.insert("memberMapper.register", vo);
    }
}