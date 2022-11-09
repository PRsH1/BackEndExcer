package net.skhu.dto;

public class Student {

    String studentNo;
    String name;
    int departmentId;
    String email;

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartmentId() {
    	switch(departmentId) {
    	case 0:
    		return "0";
		case 1:
    		return "소프트웨어공학(1)";
		case 2:
    		return "컴퓨터공학(2)";
		case 3:
			return "정보통신공학(3)";
		case 4:
			return "글로컬IT(4)";
    	}
		return null;


    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
