package net.skhu.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Student {
    String name;
    int studentNumber;
    Date birthday;

    public Student() {
    }

    public Student(String name, int studentNumber, Date birthday) {
        this.name = name;
        this.studentNumber=studentNumber;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber=studentNumber;
    }

    public Date getBirthday() {
        return birthday;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd")
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }



}
