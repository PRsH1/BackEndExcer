package net.skhu.dto;

public class MyInfo {
	int studentNo;
	String name;
	int semester;
	  public MyInfo() {
	    }

	    public MyInfo(String name, int studentNo,int semester) {
	        this.name = name;
	        this.studentNo=studentNo;
	        this.semester=semester;
	   
	       
	    }

	public int getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}

}
