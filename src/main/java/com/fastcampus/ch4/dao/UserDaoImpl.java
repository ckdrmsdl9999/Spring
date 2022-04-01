package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    DataSource ds;

    @Override
    public int deleteUser(String id) throws Exception {
        int rowCnt = 0;
        String sql = "DELETE FROM member WHERE m_id= ? ";

        try (  // try-with-resources - since jdk7
               Connection conn = ds.getConnection();
               PreparedStatement pstmt = conn.prepareStatement(sql);
        ){
            pstmt.setString(1, id);
            return pstmt.executeUpdate(); //  insert, delete, update
//      } catch (Exception e) {
//          e.printStackTrace();
//          throw e;
        }
    }

    @Override
    public User selectUser(String id) throws Exception {
        User user = null;
        String sql = "SELECT * FROM member WHERE m_id= ? ";

        try (
                Connection conn = ds.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ){
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery(); //  select

            if (rs.next()) {
                user = new User();
                user.setM_num(rs.getInt(1));
                user.setM_id(rs.getString(2));
                user.setM_nick(rs.getString(3));
                user.setM_pwd(rs.getString(4));
                user.setM_email(rs.getString(5));
                user.setM_phone(rs.getString(6));
                user.setM_point(rs.getInt(7));
                user.setM_date(new Date(rs.getTimestamp(8).getTime()));
            }
        }

        return user;
    }

    // 사용자 정보를 user_info테이블에 저장하는 메서드
    @Override
    public int insertUser(User user) throws Exception {
        int rowCnt = 0;
        String sql = "INSERT INTO member VALUES (?,?,?,?,?,?,0 ,now()) ";

        try(
                Connection conn = ds.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql); // SQL Injection공격, 성능향상
        ){
            pstmt.setInt(1, user.getM_num());
            pstmt.setString(2, user.getM_id());
            pstmt.setString(3, user.getM_nick());
            pstmt.setString(4, user.getM_pwd());
            pstmt.setString(5, user.getM_email());
            pstmt.setString(6, user.getM_phone());

            return pstmt.executeUpdate();
        }
    }

    @Override
    public int updateUser(User user) throws Exception {
        int rowCnt = 0;

        String sql = "UPDATE member " +
                "SET m_num = ?, m_nick=?, m_pwd=?, m_email =?, m_phone=?, m_point=?, m_date=? " +
                "WHERE m_id = ? ";

        try (
                Connection conn = ds.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ){
            pstmt.setInt(1, user.getM_num());
            pstmt.setString(2, user.getM_nick());
            pstmt.setString(3, user.getM_pwd());
            pstmt.setString(4, user.getM_email());
            pstmt.setString(5, user.getM_phone());
            pstmt.setInt(6, user.getM_point());
            pstmt.setTimestamp(7, new java.sql.Timestamp(user.getM_date().getTime()));
            pstmt.setString(8, user.getM_id());

            rowCnt = pstmt.executeUpdate();
        }

        return rowCnt;
    }

    @Override
    public int count() throws Exception {
        String sql = "SELECT count(*) FROM member ";

        try(
                Connection conn = ds.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
        ){
            rs.next();
            int result = rs.getInt(1);

            return result;
        }
    }

    @Override
    public void deleteAll() throws Exception {
        try (Connection conn = ds.getConnection();)
        {
            String sql = "DELETE FROM member ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
        }
    }
}