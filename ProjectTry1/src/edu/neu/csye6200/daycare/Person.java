package edu.neu.csye6200.daycare;

public class Person extends AbstractPersonAPI {
	private String firstName = null;
	private String lastName = null;
	private String address = null;
	private Integer age = null;
	private String phoneNumber = null;
	
	@Override
	public int getAge() {
		return this.age;
	}

	@Override
	public void setAge(int age) {
		this.age = age;

	}

	@Override
	public String getFirstName() {
		return this.firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;

	}

	@Override
	public String getLastName() {
		return this.lastName;
	}

	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;

	}

	@Override
	public String getAddress() {
		return this.address;
	}

	@Override
	public void setAddress(String address) {
		this.address = address;

	}

	@Override
	public String getPhoneNumber() {
		// TODO Auto-generated method stub
		return this.phoneNumber;
	}

	public Person(String firstName, String lastName, String address, Integer age, String phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.age = age;
		this.phoneNumber = phoneNumber;
	}

	@Override
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public void show() {
		this.toString();
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", age=" + age
				+ ", phoneNumber=" + phoneNumber + "]";
	}

}
