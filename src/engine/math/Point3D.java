package engine.math;

/**
 * a point in 3d space
 * @author 418cat
 */
public class Point3D {
	
	public int[] coords = new int[3];
	
	
	/**
	 * create a new point
	 * @param coords : 3d coordinates of point
	 */
	public Point3D(int[] coords){
		this.coords = new int[] {coords[0], coords[1], coords[2]};
	}

	
	/**
	 * create a new point
	 * @param x : x coordinate of point
	 * @param y : y coordinate of point
	 * @param z : z coordinate of point
	 */
	public Point3D(int x, int y, int z){
		coords = new int[] {x, y, z};
	}

	/**
	 * @return x coordinate of point
	 */
	public int x() {
		return(coords[0]);
	}

	/**
	 * @return y coordinate of point
	 */
	public int y() {
		return(coords[1]);
	}

	/**
	 * @return z coordinate of point
	 */
	public int z() {
		return(coords[2]);
	}

	
	/**
	 * check if the point is contained in a line
	 * @param line to check
	 * @return 
	 */
	public boolean isFromLine(Line3D line) {
		return(line.hasPoint(this));
	}
	
	
	/**
	 * calculate the distance from another point
	 * @param a : other point3d
	 * @return distance from the other point
	 */
	public int distanceFromPoint(Point3D a) {
		return((int)Math.sqrt( this.x()*a.x() + this.y()*a.y() + this.z()*a.z()));
	}
}