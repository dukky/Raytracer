package im.duk.raytracer;

import java.awt.image.BufferedImage;

public class Camera {
	private int picNum = 0;
	private double focalLength;
	private int filmResolutionX;
	private int filmResolutionY;

	public Camera() {
		this(1, 500, 500);
	}

	public Camera(double focalLength, int filmResolutionX, int filmResolutionY) {
		super();
		this.focalLength = focalLength;
		this.filmResolutionX = filmResolutionX;
		this.filmResolutionY = filmResolutionY;
	}

	public BufferedImage takePicture(Sphere s, Light l) {
		BufferedImage newImage = new BufferedImage(this.filmResolutionX, this.filmResolutionY,
				BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < this.filmResolutionX; ++x) {
			for (int y = 0; y < this.filmResolutionY; ++y) {
				if (x == 115 && y == 223) {
					System.out.println();
				}
				double planeX = -0.5 + x / (double)filmResolutionX;
				double planeY = 0.5 - y / (double)filmResolutionY;
				double planeZ = 1;
				Coord3D rayDir = new Coord3D(planeX, planeY, planeZ);
				Ray ray = new Ray(new Coord3D(0, 0, 0), rayDir);
				if (ray.intersectionPoint(s) != null) {
					newImage.setRGB(x, y, s.localReflectionModel(ray.intersectionPoint(s), l).getRGB());
					//System.out.println("x: " + x + " y: " + y);
				} else {
					newImage.setRGB(x, y, 0);
				}
			}
		}
		System.out.println("Image " + ++picNum +  " complete.");
		return newImage;
	}

}
