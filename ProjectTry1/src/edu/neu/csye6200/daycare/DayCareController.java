package edu.neu.csye6200.daycare;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import org.omg.CORBA.DynAnyPackage.InvalidValue;

public class DayCareController {
	private static final String studentFileName = "student.csv";
	private static final String teacherFileName = "teacher.csv";
	private static List<Classroom> classroomList = new ArrayList<Classroom>();
	private static List<EnrollmentRules> enrollmentruleList = null;
	private static SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	
	
	public static String getDateformat() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate localDate = LocalDate.now();
		String date = DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate);
		return date;
	}
	
	public void addClassroom(Classroom classroom) {
		this.classroomList.add(classroom);
	}
	
	public void removeClassroom(Classroom classroom) {
		
	}
	
	public void addClassroomID(int classroomID) {
		
	}
	
	public void removeClassroomID(Classroom classroomID) {
		
	}
	
//	public Classroom getClassroomObj(int classroomID) {
//		
//	}
	
	public Classroom getClassDetails(Student student, EnrollmentRules rule) throws Exception {
		boolean classroomFound = false;
		if (classroomList.isEmpty()) {
			Classroom classObj = new Classroom(classroomList.size(), rule);
			classroomFound = true;
			return classObj;
		}
		else {
			for (Classroom classroom : classroomList) {
				if (classroom.getEnrollmentRule().equals(rule)) {
					System.out.println(classroom.getNumOfGroups() +" < "+rule.getGroupSize());
					if (classroom.getNumOfGroups()<= rule.getGroupSize()) {
						classroomFound = true;
						return classroom;
					}
					else {
						System.out.println("Classroom matching age group found but room is full");
					}
				}
				else {
					System.out.println("Classroom not for this age group");
				}
			}
			if (classroomFound == false) {
				System.out.println("Check Classroom objs");
				for (Classroom classroom : classroomList) {
					classroom.showClassDetails();
				}
				Classroom classObj = new Classroom(this.classroomList.size(), rule);
				classroomFound = true;
				return classObj;
			}	
		}
		throw new Exception("Invalid input while assigning Class ID");
		}

	public Group getGroupDetails(Classroom classroom) throws Exception {
		boolean groupFound = false;
		if ((classroom.getNumOfGroups())==0) {
			Group groupObj = new Group(classroom.getNumOfGroups(), classroom.getEnrollmentRule());
			groupFound = true;
			return groupObj;
		}
		else {
			for (Group group : classroom.getGroupList()) {
				if (group.getGroupSize() < group.getEnrollmentRule().getGroupSize()) {
					groupFound = true;
					return group;
				}
				else {
					System.out.println("Group found but currently full");
				}
			}
			if(groupFound == false) {
				Group groupObj = new Group(classroom.getNumOfGroups(), classroom.getEnrollmentRule());
				return groupObj;
			}
		}
		throw new Exception("Invalid input while assigning group ID");	
			
	}
	
	public EnrollmentRules getEnrollmentRulesObj(int age) throws InvalidValue {
		for (EnrollmentRules enrollmentRules : enrollmentruleList) {
			System.out.println(enrollmentRules.getMinAge());
			System.out.println(enrollmentRules.getMaxAge());
			if((enrollmentRules.getMinAge()<= age && age <= enrollmentRules.getMaxAge())) {
				System.out.println("Rule found");
				return enrollmentRules;
			}
			else {
				System.out.println("Invalid Age Input");
				
			}
		}
		throw new InvalidValue("Age not in range"); 
	}
	
	public static void demo() throws Exception {
		System.out.println("DayCare Demo ");
		//Creating Rules
		EnrollmentRulesFactory enrollFactoryObj = EnrollmentRulesFactory.getObj();
		System.out.println("Get Rules factory obj ");
		List<String> enrollmentRegulationList = new ArrayList<String>();
		//minAge, maxAge, num of Students, num of Teachers, groupSize 
		enrollmentRegulationList.add("6,12,4,1,3");
		enrollmentRegulationList.add("13,24,2,1,2");	//values changed for testing purpose only
		enrollmentRegulationList.add("25,35,6,1,3");
		enrollmentRegulationList.add("36,47,8,1,3");
		enrollmentRegulationList.add("48,59,12,1,2");
		enrollmentRegulationList.add("60,100,15,1,2");
		enrollmentruleList = enrollFactoryObj.getRuleObj(enrollmentRegulationList);
		for (EnrollmentRules EnrollmentRules : enrollmentruleList) {
			EnrollmentRules.showRuleDetails();
		}
		System.out.println("Rule objs created");

		//Get DayCare factory obj from DayCare factory
		DayCareFactory  factoryObj = DayCareFactory.getObj();
		System.out.println("DayCare Factory obj");

		DayCareController DayCare = factoryObj.getDayCareObj();
		System.out.println("DayCare obj");
		//Get Student factory obj from Student factory
		StudentFactory  studentFactoryObj = StudentFactory.getObj();
		System.out.println("Student Factory obj");
		 
		//enrollment begins here for single entry
//		String sampleStudentData = "Bilz, Tompson,20, #60 St Germain, Aron Tompson, Emma Tompson,8888888888,"+formatter.format(new Date());
//		Student student  = studentFactoryObj.getStudentObj(sampleStudentData);
//		System.out.println("Student obj created");
//		student.showStudentDetails();
//		
//		
//		int studentAge = student.getAge();
//		EnrollmentRules rule = DayCare.getEnrollmentRulesObj(studentAge);
//		System.out.println("Applicable rule is "+rule.getAgeRange());
//		rule.showRuleDetails();
//		Classroom classroomObj = DayCare.getClassDetails(student, rule);
//		classroomObj.showClassDetails();
//		DayCare.addClassroom(classroomObj);
//		System.out.println("Classroom added to classroom list");
//		for (Classroom classroom : classroomList) {
//			classroomObj.showClassDetails();
//		}
//		Group groupObj = DayCare.getGroupDetails(classroomObj);
//		groupObj.showGroupDetails();
//		System.out.println(" Applicable group selected");
//		student.setGroupID(groupObj.getGroupID());
//		System.out.println("groupID set");
//		student.setClassID(classroomObj.getClassroomID());
//		System.out.println("classID set");
//		groupObj.addStudent(student);
//		System.out.println("Added student to list under group");
//		classroomObj.addGroupObj(groupObj);
//		System.out.println("Added group to list under class");
//		student.showStudentDetails();
		
		
		
		//enrollment begins here for multiple entries (initialization -> push to static)
		FileUtil fileutil = new FileUtil();
		
		//Store data read from file in file_data, call readTextFile using FileUtil object passing filename
		List<String> student_data = fileutil.readTextFile(studentFileName);
		System.out.println("Student File read successfully");
		
		//Store data read from file in file_data, call readTextFile using FileUtil object passing filename
//		List<String> teacher_data = fileutil.readTextFile(teacherFileName);
//		System.out.println("Teacher File read successfully");
		
		List<Student> studentList = studentFactoryObj.initStudentObj(student_data);
		for (Student student : studentList) {
			student.showStudentDetails();
			int studentAge = student.getAge();
			EnrollmentRules rule = DayCare.getEnrollmentRulesObj(studentAge);
			System.out.println("Applicable rule is "+rule.getAgeRange());
			rule.showRuleDetails();
			Classroom classroomObj = DayCare.getClassDetails(student, rule);
			classroomObj.showClassDetails();
			DayCare.addClassroom(classroomObj);
			System.out.println("Classroom added to classroom list");
			for (Classroom classroom : classroomList) {
				classroomObj.showClassDetails();
			}
			Group groupObj = DayCare.getGroupDetails(classroomObj);
			groupObj.showGroupDetails();
			System.out.println(" Applicable group selected");
			student.setGroupID(groupObj.getGroupID());
			System.out.println("groupID set");
			student.setClassID(classroomObj.getClassroomID());
			System.out.println("classID set");
			groupObj.addStudent(student);
			System.out.println("Added student to list under group");
			classroomObj.addGroupObj(groupObj);
			System.out.println("Added group to list under class");
			student.showStudentDetails();
		}
		
		
		
		
		
		
		

		
		System.out.println("DayCare Demo Done");
	}
	
	

}
