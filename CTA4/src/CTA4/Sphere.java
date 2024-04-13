package CTA4;

public class Sphere extends Shape{
	private double radius; 

	double surface_area() {
		return 4*Math.PI*Math.pow(radius, 2); 
	};
	
	double volume() {
		return 4/3*Math.PI*Math.pow(radius, 3); 
	};
	
	@Override
	public void printDimensions() {
		double a = this.surface_area(); 
		double b = this.volume();  
		System.out.printf("\n%s \nSurface area: %.2f \nVolume: %.2f\n\n", this.id,a,b);
	};

	Sphere(double radius){
		this.id = "Sphere"; 
		this.radius = radius; 
	}
};
