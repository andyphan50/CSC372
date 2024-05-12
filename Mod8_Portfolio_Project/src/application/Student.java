package application;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student implements Comparable<Student>{
	private final StringProperty name; 
	private final StringProperty address;
	private final DoubleProperty gpa; 
	private final StringProperty major; 
	
	//Student constructor 
	public Student(String name, String address,double gpa, String major) {
		this.name = new SimpleStringProperty(name); 
		this.address = new SimpleStringProperty(address);
		this.gpa = new SimpleDoubleProperty(gpa);
		this.major = new SimpleStringProperty(major);
	}
	
	//Getters and setters
	public String getName() {
		return name.get();  
	}
	
	 public StringProperty nameProperty() {
	        return name;
	    }
	 
	public String getAddress() {
		return address.get(); 
	}
	
	 public StringProperty addressProperty() {
	        return address;
	    }
	
	public double getGpa() {
		return gpa.get(); 
	}
	
	 public DoubleProperty gpaProperty() {
	        return gpa;
	    }
	
	public String getMajor() {
		return major.get(); 
	}
	
	 public StringProperty majorProperty() {
	        return major;
	    }

	public void setName(String name) {
		this.name.set(name);
	}
	
	public void setAddress(String address) {
		this.address.set(address);
	}
	
	public void setGpa(double gpa) {
		this.gpa.set(gpa);
	}
	
	public void setMajor(String major) {
		this.major.set(major);
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
