package cta6;

public class Student{
	int rollno; 
	String name; 
	String address; 
	
	//Student constructor
	public Student(int rollno,String name,String address) {
		this.rollno = rollno;
		this.name = name;
		this.address = address; 
	}
	
	//Getter and setters
	public String getName() {
		return this.name; 
	}
	
	public String getAddress() {
		return this.address; 
	}
	
	public int getRollno() {
		return this.rollno; 
	}
	
	public void setName(String name) {
		this.name = name; 
	}
	
	public void setAddress(String address) {
		this.address = address; 
	}
	
	public void setRollno(int rollno) {
		this.rollno = rollno; 
	}
	
	
	}

