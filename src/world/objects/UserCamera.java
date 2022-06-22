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
	}
	
	public int[] coords() {
		return(xyz);
	}
	
	public void move(int x, int y, int z) {
		xyz[0]+=x;
		xyz[1]+=y;
		xyz[2]+=z;
	}

}
