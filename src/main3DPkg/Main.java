package main3DPkg;

import java.io.File;

import MathPkg.Points.Point3D;
import MathPkg.Vectors.Vector3D;
import worldObjects.Camera;
import worldObjects.Triangle;

public class Main {
	
	public static Triangle[] triangles = parseObjFile.parseTriangles(new File("/home/418cat/Bureau/java.obj"));

	public static int[] frameRes = new int[] {1440, 1440};
	
	public static void main(String[] args) {
		
		Camera cam = new Camera(new int[] {1440, 1440}, new Point3D(-300, 0, 0), 40, new Vector3D(1, 0, 0));
		Frame.init("test", frameRes, new int[] {1000, 1000}, cam);
		Frame.drawFrame();
		

	}
	
	public static void loadFile()
	{
		triangles = parseObjFile.parseTriangles(new File("/home/418cat/Bureau/java.obj"));
	}
	
	/**
	 * KEYS :
	 * 
	 *  z = forward
	 *  s = backwards
	 *  r = reload file
	 *  a = up
	 *  e = down
	 *  q = left
	 *  d = right
	 *  scroll = faster forward and backwards
	 */

}
