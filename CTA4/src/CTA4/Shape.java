package CTA4;

abstract class Shape {
	protected String id; 
	abstract double surface_area(); 
	abstract double volume(); 
	abstract void printDimensions();
}
