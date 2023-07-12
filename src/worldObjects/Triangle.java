package worldObjects;

import MathPkg.Points.Point3D;
import MathPkg.Segments.Segment3D;

public class Triangle implements WorldShape {
	
	public Point3D[] points = new Point3D[3];
	
	
	public Triangle(Point3D A, Point3D B, Point3D C)
	{
		this.points[0] = A;
		this.points[1] = B;
		this.points[2] = C;
	}
	
	
	public boolean hasEdges() {return true;}

	@Override
	public Segment3D[] getEdges() {
		return(new Segment3D[] {
				new Segment3D(this.points[0], this.points[1]),
				new Segment3D(this.points[0], this.points[2]),
				new Segment3D(this.points[1], this.points[2])
		});
	}
	
	@Override
	public Point3D[] getPoints() {
		return(points);
	}

}
