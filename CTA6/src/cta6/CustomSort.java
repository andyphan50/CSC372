package cta6;

import java.util.Comparator;

public class CustomSort {
	
	//Public is an access specifier, static says that this method belongs to the class itself
	//<T> is a generic type parameter, the letter T is arbitrary and can be any letter
	//Void denotes the return type
	//<? super T> is known as a bounded wild card. ? represents an unknown type, super keyword specifies a lower bound
	public static <T> void sort(T[] array, Comparator<? super T> comparator){
		for(int i =0; i< array.length-1; i++) {
			int minIndex = i; 
			for (int j=i+1; j<array.length; j++) {
				if(comparator.compare(array[j], array[minIndex]) < 0) {
					minIndex = j; 
				}
			}
			
			T temp = array[i]; 
			array[i] = array[minIndex]; 
			array[minIndex] = temp; 
				}
			}

}
