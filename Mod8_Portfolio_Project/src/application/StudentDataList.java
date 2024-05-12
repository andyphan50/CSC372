package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StudentDataList {
	private static ObservableList<Student> dataList; 
	private static	LinkedList<Student> studentList = new LinkedList<Student>(); 
	
	
	//Observable list constructor
	public StudentDataList() {
		dataList= FXCollections.observableArrayList(); 
	}
	
	//Get observable data list
	public ObservableList<Student> getDataList() {
		return dataList; 
	}
	
	//Add data to observable data list and linked list 
	public void addData(Student data) {
		dataList.add(data); 
		studentList.add(data); 
	}
	
	
	//Remove data to observable data list and linked list 
	public static void removeData(Student data) {
		dataList.remove(data); 
		studentList.remove(data); 
	}
	
	//Update linked list in a txt.file 
	public static void saveLinkedList() {
		String fileName = "output.txt"; 
		try(FileWriter writer = new FileWriter(fileName)) {
			Collections.sort(studentList, new StudentNameComparator());
			writer.write("Name      Address             GPA       Major\n");
			for(Student item: studentList) {
				String padName = String.format("%-10s",item.getName()); 
				String padAddress = String.format("%-20s",item.getAddress()); 
				String padGpa = String.format("%-10s",item.getGpa()); 
				String padMajor = String.format("%-10s",item.getMajor()); 
				writer.write(padName + padAddress+ padGpa + padMajor +"\n");
				
			}
			System.out.println("Successfuly wrote to file"); 
			} catch (IOException e) {
				System.err.println("Error writing to file!"); 
			}
	}
	//Get linked list 
	public LinkedList<Student> getLinkedList() {
		return studentList; 
	}

}
