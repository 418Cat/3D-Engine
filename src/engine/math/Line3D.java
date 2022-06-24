package engine.math;

public class Line3D {

	public Vector3D vect;
	public Point3D point;

	Line3D(Point3D a, Point3D b){
		point = a;
		vect = new Vector3D(a, b);
	}

	Line3D(Vector3D vect, Point3D a){
		this.vect = vect;
		point = a;
	}

	public boolean hasPoint(Point3D a) {		
		return(vect.x()*a.x() + vect.y()*a.y() + vect.z()*a.z() == 0);
	}

}
