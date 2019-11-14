package edu.neu.csye6200.daycare;

public class Teacher extends Person {
	
	public Teacher(String firstName, String lastName, String address, Integer age, String phoneNumber, int teacherID,
			double wage) {
		super(firstName, lastName, address, age, phoneNumber);
		this.teacherID = teacherID;
		this.wage = wage;
	}
	private int teacherID;
	private double wage;
}