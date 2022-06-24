package engine.math;

public class Vector3D {

	public int[] coords = new int[3];

	Vector3D(int[] coords) {
		this.coords = coords;
	}

	public Vector3D(int x, int y, int z) {
		coords = new int[] {x, y, z};
	}

	public Vector3D(Point3D point1, Point3D point2) {
		coords = new int[] {point2.x() - point1.x(), point2.y() - point1.y(), point2.z() - point1.z()};
	}

	public Vector3D(Line3D line) {
		coords = line.vect.coords;
	}

	public int x() {
		return(coords[0]);
	}

	public int y() {
		return(coords[1]);
	}

	public int z() {
		return(coords[2]);
	}

	public int[] add(int x, int y, int z) {
		coords[0]+=x;
		coords[1]+=y;
		coords[2]+=z;
		return(coords);
	}

	public int[] add(int[] coords) {
		this.coords[0]+=coords[0];
		this.coords[1]+=coords[1];
		this.coords[2]+=coords[2];
		return(this.coords);
	}

	public int scalarProduct(Vector3D vect) {
		return(this.x()*vect.x() + this.y()*vect.y() + this.z()*vect.z());
	}

	public int norm() {
		return((int)Math.sqrt( this.x()*this.x() +  this.y()*this.y() +  this.z()*this.z() ));
	}
	
	public double angleRad(Vector3D vect) {
		//TODO: FIX
		return(Math.acos(  (this.scalarProduct(vect) / (this.norm()*vect.norm())  )));
	}
	
	public int angleDeg(Vector3D vect) {
		//TODO: FIX
		return((int)Math.toDegrees(Math.acos(  ((float)this.scalarProduct(vect) / (float)(this.norm()*vect.norm())  ))));
	}
	

}
