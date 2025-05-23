public class Vector {

	private double x;
	private double y;
	
	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double magnitude() {
		return Math.sqrt(x * x + y * y);
	}
	
	public Vector add(Vector other) {
		return new Vector(this.x + other.x, this.y + other.y);
	}
	
}