package world;

import java.awt.Color;
import java.util.ArrayList;

import world.objects.UserCamera;
import world.objects.Shapes.Plane;
import world.objects.Shapes.Shape;

public class World {
	
	Color bgColor;
	int[] dimension = {0, 0, 0};
	
	public Content content;
	
	UserCamera cam;
	
	public World(int[] dimension, Color bgColor){
		this.bgColor = bgColor;
		this.dimension = dimension;
		content = new Content(cam);
	}
	
	public World(int[] dimension, Color bgColor, int[] camSize, int fov){
		this.bgColor = bgColor;
		this.dimension = dimension;
		this.cam = new UserCamera(camSize, fov);
		content = new Content(cam);
	}
	
	
	
	public Color getBgColor() {
		return(bgColor);
	}
	
	public int[] getWorldDimensions() {
		return(dimension);
	}
	
	public UserCamera getCam() {
		return(cam);
	}
	
	
	
	
	public class Content {
		
		public ArrayList<Shape> shapes = new ArrayList<>();
		public ArrayList<Obj> objects = new ArrayList<>();
		
		Content(UserCamera cam){
			objects.add(cam);
		}
		
		public void removeObjElement(int index) {
			if(objects.size()-1 < index || index < 0) return;
			objects.remove(index);
		}
		
		public void addPlane(int[][] points, Color color) {
			shapes.add(new Plane(points, color));
		}
	}

}

