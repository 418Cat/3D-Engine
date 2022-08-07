package world.objects;

import engine.math.Point3D;
import world.Obj;

/**
 * class used by {@link engine.Engine} to render a {@link world.World}
 * @author 418cat
 */
public class UserCamera extends Obj {
	
	public int fov;
	public float aspectRatio;
	public int[] angle = {0, 0};
	private Point3D point;
	
	
	/**
	 * initialize a new camera
	 * @param resolution : the camera's resolution in px
	 * @param fov : horizontal field of view
	 */
	public UserCamera(int[] resolution, int fov){
		point = new Point3D(0, 0, 0);
		aspectRatio = resolution[0]/resolution[1];
		this.fov = fov;
	}
	
	
	/**
	 * @return camera coordinates
	 */
	public int[] coords() {
		return(point.coords);
	}
	
	
	/**
	 * move the camera relative to its current coordinates
	 * @param x : x-axis coordinates to add
	 * @param y : y-axis coordinates to add
	 * @param z : z-axis coordinates to add
	 */
	public void move(int x, int y, int z) {
		point.coords[0]+=x;
		point.coords[1]+=y;
		point.coords[2]+=z;
	}
	
	
	/**
	 * turn the camera relative to its current angle
	 * @param angle : horizontal and vertical angle
	 */
	public void turn(int[] angle) {
		angle[0]+=angle[0];
		angle[1]+=angle[1];
	}
	
	
	/**
	 * @return the camera's point
	 */
	public Point3D point() {
		return(point);
	}

}
