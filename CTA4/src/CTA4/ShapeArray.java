package CTA4;

import java.util.Scanner;

public class ShapeArray {
	
	public static void main(String[] args) {
		double r; 
		double h; 
		try (Scanner scnr = new Scanner(System.in)) {
			//Prompt the user to enter values for each shape
			//Instantiate a sphere, cylinder, and cone for each value
			System.out.println("Please enter radius for a sphere:");
			r = scnr.nextDouble(); 
			Sphere sph = new Sphere(r); 
			System.out.println("Please enter radius for a cylinder:"); 
			r = scnr.nextDouble(); 
			System.out.println("Please enter height for a cylinder:");
			h = scnr.nextDouble(); 
			Cylinder cyl = new Cylinder(r,h); 
			System.out.println("Please enter radius for a cone:");
			r = scnr.nextDouble(); 
			System.out.println("Please enter height for a cone:");
			h = scnr.nextDouble(); 
			Cone co = new Cone(r,h);
					
			//Store insances into array
			Shape[] shapeArray = new Shape[] {sph,cyl,co}; 
			
			//Loop through array and print out the instance data of each Object
			for(Shape obj: shapeArray) {
				obj.printDimensions(); 
			}
		}
	};
}; 
