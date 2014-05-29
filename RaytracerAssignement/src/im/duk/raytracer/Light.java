package im.duk.raytracer;

public class Light {
	
	public Coord3D getOrigin() {
		return origin;
	}
	
	public double getIntensity() {
		return intensity;
	}
	
	private Coord3D origin;
	private double intensity;
	
	public Light(Coord3D origin, double intensity) {
		this.origin = origin;
		this.intensity = intensity;
	}
}
