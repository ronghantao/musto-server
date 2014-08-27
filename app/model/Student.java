package model;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import entity.StudentInfo;
import entity.User;

public class Student extends Person{
	public String studentId;
	public String examId;
	public String college;
	public String major;
	public String grade;
	public String classTeam;
	public String apartment;
	public String archiveId;
	public String dorm;
	
	public void init(StudentInfo stu, User u){
		super.init(u);
		this.studentId = stu.studentId;
		this.examId = stu.examId;
		this.college = stu.college;
		this.major = stu.major;
		this.grade = stu.grade;
		this.classTeam = stu.classTeam;
		this.archiveId = stu.archiveId;
		this.dorm = stu.archiveId;
	}
	
}
