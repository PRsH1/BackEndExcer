package net.skhu.dto;

import lombok.Data;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Data
public class User {
    int id;
    
    @NotEmpty
    @NotBlank
    String userid;
    
    @NotEmpty
    @NotBlank
    @Size(min=8)
    String password;
    
    @NotEmpty
    @NotBlank
    String name;
    
    @Email
    String email;
    
    int enabled;
    String userType;
    int departmentId;
    String departmentName;
    
    
}
