package im.duk.raytracer;

/**
 * A class to represent a point in 3D space.
 * 
 * @author Andreas
 * 
 */
public class Coord3D {

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	private double x;
	private double y;
	private double z;

	public Coord3D(double x, double y, double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Distance between two points
	 * @param other
	 * @return
	 */
	public double distanceBetween(Coord3D other) {
		double xs = Math.pow((this.x + other.x), 2);
		double ys = Math.pow((this.y + other.y), 2);
		double zs = Math.pow((this.z + other.z), 2);
		return Math.sqrt(xs + ys + zs);
	}
	
	/**
	 * Dot product
	 * @param other
	 * @return
	 */
	public double dot(Coord3D other) {
		double xs = this.x * other.x;
		double ys = this.y * other.y;
		double zs = this.z * other.z;
		return xs + ys + zs;
	}
	
	public Coord3D normalize() {
		double length = Math.sqrt(x * x + y * y + z * z);
		return new Coord3D(x/length, y/length, z/length);
	}
	
	public Coord3D add(Coord3D other) {
		return new Coord3D(this.x + other.x, this.y + other.y, this.z + other.z);
	}
	
	public Coord3D subtract(Coord3D other) {
		return new Coord3D(this.x - other.x, this.y - other.y, this.z - other.z);
	}
	
	public Coord3D scale(double s) {
		return new Coord3D(this.x * s, this.y * s, this.z * s);
	}
	
	public String toString() {
		return "Coord3D(" + x + ", " + y + ", " + z + ")";
	}
}
