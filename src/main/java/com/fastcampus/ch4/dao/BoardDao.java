package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.domain.*;

import java.util.*;

public interface BoardDao {
    BoardDto select(Integer e_num) throws Exception;
    int delete(Integer e_num) throws Exception;
    int insert(BoardDto dto) throws Exception;
    int update(BoardDto dto) throws Exception;
    int increaseViewCnt(Integer e_num) throws Exception;

    List<BoardDto> selectPage(Map map) throws Exception;
    List<BoardDto> selectAll() throws Exception;
    int deleteAll() throws Exception;
    int count() throws Exception;

    int searchResultCnt(SearchCondition sc) throws Exception;
    List<BoardDto> searchSelectPage(SearchCondition sc) throws Exception;
}