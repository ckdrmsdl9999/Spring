package com.fastcampus.ch4.domain;

import java.util.Date;
import java.util.Objects;

public class User {
    private int m_num;
    private String m_id;
    private String m_nick;
    private String m_pwd;
    private String m_email;
    private String m_phone;
    private int m_point; //회원가입시 0
    private Date m_date;

    public User(){}
    public User(int m_num, String m_id, String m_nick, String m_pwd, String m_email, String m_phone, int m_point, Date m_date) {
        this.m_num = m_num;
        this.m_id = m_id;
        this.m_nick = m_nick;
        this.m_pwd = m_pwd;
        this.m_email = m_email;
        this.m_phone = m_phone;
        this.m_point = m_point;
        this.m_date = m_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return m_num == user.m_num && m_point == user.m_point && Objects.equals(m_id, user.m_id) && Objects.equals(m_nick, user.m_nick) && Objects.equals(m_pwd, user.m_pwd) && Objects.equals(m_email, user.m_email) && Objects.equals(m_phone, user.m_phone) && Objects.equals(m_date, user.m_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(m_num, m_id, m_nick, m_pwd, m_email, m_phone, m_point, m_date);
    }

    @Override
    public String toString() {
        return "User{" +
                "m_num=" + m_num +
                ", m_id='" + m_id + '\'' +
                ", m_nick='" + m_nick + '\'' +
                ", m_pwd='" + m_pwd + '\'' +
                ", m_email='" + m_email + '\'' +
                ", m_phone='" + m_phone + '\'' +
                ", m_point=" + m_point +
                ", m_date=" + m_date +
                '}';
    }

    public int getM_num() {
        return m_num;
    }

    public void setM_num(int m_num) {
        this.m_num = m_num;
    }

    public String getM_id() {
        return m_id;
    }

    public void setM_id(String m_id) {
        this.m_id = m_id;
    }

    public String getM_nick() {
        return m_nick;
    }

    public void setM_nick(String m_nick) {
        this.m_nick = m_nick;
    }

    public String getM_pwd() {
        return m_pwd;
    }

    public void setM_pwd(String m_pwd) {
        this.m_pwd = m_pwd;
    }

    public String getM_email() {
        return m_email;
    }

    public void setM_email(String m_email) {
        this.m_email = m_email;
    }

    public String getM_phone() {
        return m_phone;
    }

    public void setM_phone(String m_phone) {
        this.m_phone = m_phone;
    }

    public int getM_point() {
        return m_point;
    }

    public void setM_point(int m_point) {
        this.m_point = m_point;
    }

    public Date getM_date() {
        return m_date;
    }

    public void setM_date(Date m_date) {
        this.m_date = m_date;
    }
}