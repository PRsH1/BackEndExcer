package net.skhu.dto;





public class Student {
    String name;
    String studentNumber;
    int semester;

    public Student() {
    }

    public Student(String name, String studentNumber, int semesster, int semester) {
        this.name = name;
        this.studentNumber=studentNumber;
        this.semester=semester;
       
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber=studentNumber;
    }

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}





}