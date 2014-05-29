package im.duk.raytracer;

public class Ray {
	
	public Coord3D getOrigin() {
		return origin;
	}

	public Coord3D getDirectionVector() {
		return directionVector;
	}

	private Coord3D origin;
	private Coord3D directionVector;
	
	public Ray(Coord3D origin, Coord3D directionVector) {
		this.origin = origin;
		this.directionVector = directionVector.normalize();
	}
	
	/**
	 * Calculates whether a ray intersects with a given sphere.
	 * @param s
	 * @return
	 */
	public Coord3D intersectionPoint(Sphere s) {
		Coord3D c = s.getCenter();
		Coord3D d = this.directionVector;
		Coord3D o = this.origin;
		double B = 2 * (d.getX() * (-c.getX()) + (d.getY() * (-c.getY()) + (d.getZ() * (-c.getZ()))));
		double C = Math.pow(o.getX() - c.getX(), 2) + Math.pow(o.getY() - c.getY(), 2) + Math.pow(o.getZ() - c.getZ(), 2) - Math.pow(s.getRadius(), 2);
		double discriminant = Math.pow(B, 2) - (4*C);
		if(discriminant < 0) {
			return null;
		} else {
			double t1 = (-B - Math.sqrt(discriminant)) / 2;
			double t2 = (-B + Math.sqrt(discriminant)) / 2;
			if(t1 < t2) {
				return directionVector.scale(t1);
			} else {
				return directionVector.scale(t2);
			}
		}
	}
	
	public String toString() {
		return "Ray(Origin:" + this.origin.toString() + ", Direction:" + this.directionVector.toString() + ")";
	}

}
