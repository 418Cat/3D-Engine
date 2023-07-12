package worldObjects;

import MathPkg.Points.Point3D;
import MathPkg.Segments.Segment3D;

public interface WorldShape {
	
	public boolean hasEdges();
	
	public Segment3D[] getEdges();
	
	public Point3D[] getPoints();

}
