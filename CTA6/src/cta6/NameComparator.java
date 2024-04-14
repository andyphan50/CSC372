package cta6;
import java.util.Comparator; 

public class NameComparator implements Comparator<Student>{
	//Comparable interface
		@Override
		public int compare(Student currStudent, Student otherStudent) {
			return currStudent.getName().compareTo(otherStudent.getName()); 
			
		}

}
