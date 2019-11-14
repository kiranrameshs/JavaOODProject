package edu.neu.csye6200.daycare;

public abstract class AbstractPersonAPI {
	public abstract int getAge();
	public abstract void setAge(int age);
	public abstract String getFirstName();
	public abstract void setFirstName(String firstName);
	public abstract String getLastName();
	public abstract void setLastName(String lastName);
	public abstract String getAddress();
	public abstract void setAddress(String address);
	public abstract String getPhoneNumber();
	public abstract void setPhoneNumber(String phoneNumber);
	public abstract void show();
}
