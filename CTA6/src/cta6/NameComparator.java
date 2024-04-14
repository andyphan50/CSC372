package cta6;

public class NameComparator implements Comparable<Student>{
	//Comparable interface
		public int compare(Student currStudent, Student otherStudent) {
			int l1 = this.getName().length(); 
			int l2 = otherStudent.getName().length(); 
			int lmin = Math.min(l1, l2); 
			
			for(int i = 0; i < lmin; i++) {
				int string1char = (int)this.getName().charAt(i); 
				int string2char = (int)otherStudent.getName().charAt(i); 
				
				if(string1char != string2char) {
					return string1char - string2char; 
				}
				}
				return 0; 
			}

		@Override
		public int compareTo(Student o) {
			// TODO Auto-generated method stub
			return 0;
		}
}
