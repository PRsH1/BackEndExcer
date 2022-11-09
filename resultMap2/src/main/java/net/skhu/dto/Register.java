package net.skhu.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Register {
    int id;
    int studentId;
    int courseId;
    int grade;
    Date createDate;
    Student student;
    //자식 객체 student
    Course course;
    //자식 객체 course
}
