package net.skhu.dto;

import java.util.List;

import lombok.Data;

@Data
public class Project {
	int id;
	String title;
	int managerId;
	int progress;
	String priority;
	Manager managers;
	

}
