package CTA4;


public class Cylinder extends Shape{
	private double radius;
	private double height;
	
	double surface_area() {
		return 2*Math.PI*radius*height + 2*Math.PI*Math.pow(radius, 2);
	}; 
	
	double volume() {
		return Math.PI*Math.pow(radius, 2)*height; 
	}
	@Override
	public void printDimensions() {
		double a = this.surface_area(); 
		double b = this.volume();  
		System.out.printf("\n%s \nSurface area: %.2f \nVolume: %.2f\n\n", this.id,a,b);
	}

	Cylinder(double radius, double height) {
		this.id = "Cylinder"; 
		this.radius = radius; 
		this.height = height; 
	}

}
