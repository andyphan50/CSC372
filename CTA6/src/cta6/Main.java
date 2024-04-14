package cta6;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student andy = new Student("Andy", "3401 Kilrush"); 
		Student isaac = new Student("Isaac", "6100 Harris"); 
		Student jimmy = new Student("Jimmy", "505 E Lamar"); 
		Student kevin = new Student("Kevin", "1393 Holleman"); 
		Student mindy = new Student("Mindy", "3441 Mayflower"); 
		Student maddie = new Student("Maddie", "1602 Manchester"); 
		
		System.out.print("Before Sorting: \n");
		Student[] unsortedStudent = {jimmy, andy, isaac,kevin,mindy,maddie}; 
		for(Student element: unsortedStudent) {
			System.out.print(element.getName()+":" + element.getRollno()+"\n"); 
		}
		//Sort by roll number using RollnoComparator
		RollnoComparator rollnoComparator = new RollnoComparator(); 
		Student[] studentByAge = {jimmy, andy, isaac,kevin,mindy,maddie}; 
		CustomSort.sort(studentByAge, rollnoComparator);
		
		System.out.print("\nAfter Sorting by Roll number: \n");
		for(Student element: studentByAge) {
			System.out.print(element.getName()+":" + element.getRollno()+"\n");
		}
		
		//Sort by name using Name Comparator 
		NameComparator nameComparator = new NameComparator(); 
		Student[] studentByName = {jimmy, andy, isaac,kevin,mindy,maddie};
		CustomSort.sort(studentByName, nameComparator); 
		System.out.print("\nAfter Sorting by Name: \n");
		for(Student element: studentByName) {
			System.out.print(element.getName()+":" + element.getRollno()+"\n");
		}
		
	}

}
