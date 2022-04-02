package com.fastcampus.ch4.controller;

import com.fastcampus.ch4.domain.MemberVO;
import com.fastcampus.ch4.service.MemberService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {

    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Inject
    MemberService service;

    // 회원가입 get
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public void getRegister() throws Exception {
        logger.info("get register");
    }

    // 회원가입 post
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String postRegister(MemberVO vo) throws Exception {
        logger.info("post register");

        service.register(vo);

        return null;
    }
}