package com.fastcampus.ch4.domain;

import java.util.*;

public class BoardDto {
    private Integer e_num;
    private String  e_title;
    private String  e_text;
    private Date    e_date;
    private Date    e_edate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardDto boardDto = (BoardDto) o;
        return Objects.equals(e_num, boardDto.e_num) && Objects.equals(e_title, boardDto.e_title) && Objects.equals(e_text, boardDto.e_text) && Objects.equals(e_date, boardDto.e_date) && Objects.equals(e_edate, boardDto.e_edate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(e_num, e_title, e_text, e_date, e_edate);
    }

    public BoardDto() {}

    public BoardDto(String e_title, String e_text) {
        this.e_title = e_title;
        this.e_text = e_text;
    }

    public Integer getE_num() {
        return e_num;
    }

    public void setE_num(Integer e_num) {
        this.e_num = e_num;
    }

    public String getE_title() {
        return e_title;
    }

    public void setE_title(String e_title) {
        this.e_title = e_title;
    }

    public String getE_text() {
        return e_text;
    }

    public void setE_text(String e_text) {
        this.e_text = e_text;
    }

    public Date getE_date() {
        return e_date;
    }

    public void setE_date(Date e_date) {
        this.e_date = e_date;
    }

    public Date getE_edate() {
        return e_edate;
    }

    public void setE_edate(Date e_edate) {
        this.e_edate = e_edate;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "e_num=" + e_num +
                ", e_title='" + e_title + '\'' +
                ", e_text='" + e_text + '\'' +
                ", e_date=" + e_date +
                ", e_edate=" + e_edate +
                '}';
    }
}