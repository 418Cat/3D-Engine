package main3DPkg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import MathPkg.Points.Point3D;
import worldObjects.Triangle;

public class parseObjFile {
	
	public static Point3D[] parsePoints(File file)
	{
		
		ArrayList<Point3D> pnts = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    int iLine = 0;
		    String line;
		    while ((line = br.readLine()) != null) {
				if(line.startsWith("v ")) {
					
					String[] lineSplit = line.split(" ");
					
					double x = Double.valueOf(lineSplit[1]) * 50 + 50;
					double y = Double.valueOf(lineSplit[2]) * 50;
					double z = Double.valueOf(lineSplit[3]) * 50;
					
					pnts.add(new Point3D(x, y, z));
				}
		        iLine++;
		    }
		} catch( Exception ioe ){
		    System.out.println(ioe.toString());
		}
		
		Point3D[] pntsArr = new Point3D[pnts.size()];
		for(int pnt = 0; pnt < pnts.size(); pnt++)
		{
			pntsArr[pnt] = pnts.get(pnt);
		}
		
		return(pntsArr);
	}
	
	
	public static Triangle[] parseTriangles(File file)
	{
		ArrayList<Triangle> triangles = new ArrayList<>();
		Point3D[] pnts = parsePoints(file);
		System.out.println("pnts length " + pnts.length);
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    int iLine = 0;
		    String line;
		    while ((line = br.readLine()) != null) {
		    	if(line.startsWith("f ")) {
					
					String[] lineSplit = line.split(" ");
					
					Point3D A = pnts[Integer.valueOf(lineSplit[1].split("/")[0])-1];
					Point3D B = pnts[Integer.valueOf(lineSplit[2].split("/")[0])-1];
					Point3D C = pnts[Integer.valueOf(lineSplit[3].split("/")[0])-1];
					
					triangles.add(new Triangle(A, B, C));
					
				}
		        iLine++;
		    }
		} catch( Exception ioe ){
		    System.out.println(ioe.toString());
		}
		
		Triangle[] trianglesArr = new Triangle[triangles.size()];
		for(int triangle = 0; triangle < triangles.size(); triangle++)
		{
			trianglesArr[triangle] = triangles.get(triangle);
		}
		
		return(trianglesArr);
	}

}
