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
    Course course;
    //수강신청 데이터 조회 시 학생 정보 강좌 정보 포함 조회해야 하므로
    //Student속성 Course 속성 구현
}

