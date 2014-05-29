package im.duk.raytracer;

import java.awt.Color;

/**
 * A class to represent a sphere.
 * @author Andreas
 *
 */
public class Sphere {
	
	private Coord3D center;
	private double radius;
	private Color color;
	
	public Coord3D getCenter() {
		return center;
	}
	
	public double getRadius() {
		return radius;
	}

	public Sphere(Coord3D center, double radius, Color color) {
		super();
		this.center = center;
		this.radius = radius;
		this.color = color;
	}
	
	public String toString() {
		return "Sphere: (" + center.toString() + ", " + radius + ")";
	}
	
	public Color localReflectionModel(Coord3D intersectionPoint, Light l) {
		Coord3D N = intersectionPoint.subtract(this.center).normalize();
		Coord3D L = l.getOrigin().subtract(intersectionPoint).normalize();
		double diffuse = l.getIntensity() * N.dot(L);
		double ambient = l.getIntensity();
		int red = this.color.getRed();
		int green = this.color.getGreen();
		int blue = this.color.getBlue();
		Color ret = new Color((int)Math.min((red * (ambient + diffuse)),255), (int)Math.min((green * (ambient + diffuse)), 255), (int)Math.min((blue * (ambient + diffuse)),255));
		return ret;
	}
	
}
