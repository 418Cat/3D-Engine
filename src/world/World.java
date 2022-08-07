package world;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import engine.math.Point3D;
import world.objects.Shape;
import world.objects.UserCamera;
import world.objects.Shapes.Plane;

/**
 * a class to contain different {@link world.Obj} and give an easy way for the renderer to access shapes
 * @author 418cat
 */
public class World {
	
	Color bgColor; //background color of the world TODO: implement hdri
	
	public Content content;
	
	UserCamera cam;
	
	/**
	 * create a new World instance
	 * @param bgColor : World's background color
	 * @param cam : the {@link UserCamera} to render the world
	 */
	public World(Color bgColor, UserCamera cam){
		this.bgColor = bgColor;
		this.cam = cam;
		content = new Content();
		content.addObj("user_cam", cam);
	}
	
	/**
	 * create a new World instance
	 * @param bgColor : World's background color
	 * @param camResolution : the new {@link UserCamera}'s resolution
	 * @param fov : the new camera's horizontal field of view
	 */
	public World(Color bgColor, int[] camResolution, int fov){
		this.bgColor = bgColor;
		this.cam = new UserCamera(camResolution, fov);
		content = new Content();
		content.addObj("user_cam", cam);
	}
	
	
	/**
	 * @return the world's background color
	 */
	public Color getBgColor() {
		return(bgColor);
	}
	
	/**
	 * @return the world's {@link UserCamera}
	 */
	public UserCamera getCam() {
		return(cam);
	}
	
	
	
	/**
	 * a container for a world's {@link Obj} & {@link Shape}s
	 * @author 418cat
	 */
	public class Content {
		
		public Map<String, Shape> shapes = new HashMap<String, Shape>();
		public Map<String, Obj> objects = new HashMap<String, Obj>();
		
		
		/**
		 * remove an object from the world
		 * @param id : id of the object to remove
		 */
		public void removeObjElement(String id) {
			if (objects.containsKey(id)) return;
			objects.remove(id);
		}
		
		/**
		 * add a {@link Plane} to the world
		 * @param id : plane's id
		 * @param points : all points that are composing the plane
		 * @param color : the plane's color
		 */
		public void addPlane(String id, Point3D[] points, Color color) {
			shapes.put(id, new Plane(points, color));
		}
		
		/**
		 * add an {@link Obj} to the world
		 * @param id : object's id
		 * @param obj : object to add to the world
		 */
		public void addObj(String id, Obj obj) {
			if(objects.containsKey(id)) return;
			objects.put(id, obj);
		}
	}

}

