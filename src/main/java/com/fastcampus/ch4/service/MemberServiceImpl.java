package com.fastcampus.ch4.service;


import javax.inject.Inject;

import com.fastcampus.ch4.dao.MemberDao;
import com.fastcampus.ch4.domain.MemberVO;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Inject
    MemberDao dao;

    @Override
    public void register(MemberVO vo) throws Exception {

        dao.register(vo);

    }

}
