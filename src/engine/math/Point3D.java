package engine.math;

public class Point3D {
	
	public int[] coords;
	
	public Point3D(int[] coords){
		this.coords = coords;
	}

	public Point3D(int x, int y){
		
	}

	public Point3D(int x, int y, int z){
		coords = new int[] {x, y, z};
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

	public boolean isFromLine(Line3D line) {
		return(line.hasPoint(this));
	}
	
	public int distanceFromPoint(Point3D a) {
		return((int)Math.sqrt( this.x()*a.x() + this.y()*a.y() + this.z()*a.z()));
	}
}