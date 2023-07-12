package worldObjects;

import MathPkg.Points.Point3D;
import MathPkg.Segments.Segment3D;

public class Mesh implements WorldShape {
	
	public boolean hasEdges() {return true;}
	
	private Triangle[] triangles;
	
	@Override
	public Segment3D[] getEdges() {
		Segment3D[] segs = new Segment3D[triangles.length * 3];
		
		for(int triangle = 0; triangle < triangles.length; triangle++)
		{
			for(int seg = 0; seg < 3; seg++)
			{
				segs[triangle * 3 + seg] = triangles[triangle].getEdges()[seg];
			}
		}
		return(segs);
	}
	
	@Override
	public Point3D[] getPoints() {
		Point3D[] pnts = new Point3D[triangles.length * 3];
		
		for(int triangle = 0; triangle < triangles.length; triangle++)
		{
			for(int pnt = 0; pnt < 3; pnt++)
			{
				pnts[triangle * 3 + pnt] = triangles[triangle].points[pnt];
			}
		}
		return(pnts);
	}

}
