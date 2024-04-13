package CTA4;

public class Cone extends Shape {
	private double radius;
	private double height;
	
	double surface_area() {
		return Math.PI*radius*(radius+Math.sqrt(Math.pow(height, 2)+Math.pow(radius, 2)));
	}; 
	
	double volume() {
		return Math.PI*Math.pow(radius, 2)*height/3;
	};
	@Override
	public void printDimensions() {
		double a = this.surface_area(); 
		double b = this.volume();  
		System.out.printf("\n%s \nSurface area: %.2f \nVolume: %.2f\n\n", this.id,a,b);
	};

	Cone(double radius, double height) {
		this.id = "Cone"; 
		this.radius = radius; 
		this.height = height; 
	}
}
