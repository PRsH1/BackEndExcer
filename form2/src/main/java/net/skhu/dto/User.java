package net.skhu.dto;

import lombok.Data;

@Data
public class User {
    int id;
    String userid;
    String password;
    String name;
    String email;
    boolean enabled;
    String userType;
    Integer departmentId;
    //null값이 가능한 필드 따라서 Integer타입의 속성 부여
}
