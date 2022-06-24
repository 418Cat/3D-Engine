package world.objects;

import engine.math.Point3D;
import world.Obj;

public class UserCamera extends Obj {
	
	public int fov;
	public float aspectRatio;
	public int[] angle = {0, 0};
	private Point3D point;
	
	public UserCamera(int[] frameSize, int fov){
		point = new Point3D(0, 0, 0);
		aspectRatio = frameSize[0]/frameSize[1];
		this.fov = fov;
	}
	
	public int[] coords() {
		return(point.coords);
	}
	
	public void move(int x, int y, int z) {
		point.coords[0]+=x;
		point.coords[1]+=y;
		point.coords[2]+=z;
	}
	
	public void turn(int x, int y) {
		angle[0]+=x;
		angle[1]+=y;
	}
	
	public void turn(int[] angle) {
		angle[0]+=angle[0];
		angle[1]+=angle[1];
	}
	
	public Point3D point() {
		return(point);
	}

}
