package world.objects;

import world.Obj;

public class UserCamera extends Obj {
	
	public int[] size = new int[2];
	public int fov;
	public float aspectRatio;
	
	private int[] xyz = {0, 0, 0};
	
	public UserCamera(int[] frameSize, int fov){
		aspectRatio = frameSize[0]/frameSize[1];
		
		size[0] = 2*(int)Math.tan(Math.toRadians(fov/2));
		size[1] = (int)(size[0]/aspectRatio);
		System.out.println("camera : " + size[0] + ", " + size[1] + "; fov = " + fov + "; rads = " + Math.toRadians(fov) + "; tan = " + 2*Math.tan(Math.toRadians(fov/2)));
	}
	
	public int[] coords() {
		return(xyz);
	}

}
