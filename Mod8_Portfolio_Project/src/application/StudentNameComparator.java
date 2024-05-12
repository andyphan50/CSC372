package application;

import java.util.Comparator;

public class StudentNameComparator implements Comparator<Student>{

	@Override
	public int compare(Student p1, Student p2) {
		// TODO Auto-generated method stub
		return p1.getName().compareTo(p2.getName()) ;
	}

}
