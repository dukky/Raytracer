package im.duk.raytracer;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Camera camera = new Camera(1,1000,1000);
		BufferedImage bi = camera.takePicture(new Sphere(new Coord3D(-4, 1, 30), 8, new Color(0xBBFFBB)),
				new Light(new Coord3D(8, -4, 20), 0.5));
	//	g.scale(0.1, 0.1);
		ImageDisplayPanel panel = new ImageDisplayPanel(bi);

		// Coord3D loc = new Coord3D(1, 1, 1);
		// Sphere myS = new Sphere(loc, 2);
		// System.out.println(myS);
		//
		// Coord3D loc2 = new Coord3D(2,2,2);
		// loc = loc.add(loc2);
		// System.out.println(loc);
		// loc = loc.subtract(loc2);
		// System.out.println(loc);
		//
		// Coord3D loc3 = new Coord3D(1,2,3);
		// loc3 = loc3.normalize();
		// System.out.println(loc3);
	}

}
