package engine;

import java.awt.image.BufferedImage;

import world.World;
import world.objects.Shape;
import world.objects.UserCamera;


/**
 * A class that contains a {@link World} instance, and using its {@link UserCamera}, renders a frame when {@link #render()} is called
 * @version 07 aug. 2022
 * @author 418cat
 */
public class Engine {
	
	UserCamera cam;
	public EngineWindow ew;
	World world;
	BufferedImage nextFrame;
	
	
	/**
	 * initialize a new rendering engine
	 * @param size : size of the jframe in px
	 * @param location : location on screen of the jframe in px
	 * @param fullscreen : set to fullscreen
	 * @param world: world the engine will render
	 */
	public Engine(int[] size, int[] location, boolean fullscreen, World world){
		ew = new EngineWindow(size, location, fullscreen);
		this.world = world;
		this.cam = world.getCam();
	}
	
	
	/**
	 * clear the engine frame
	 */
	public void clear() {
		ew.g.clearRect(0, 0, ew.engineFrame.frame.getWidth(), ew.engineFrame.frame.getHeight());
	}

	
	/**
	 * render a new frame
	 */
	public void render() {
		//iterate over each shape of the world
		for(Shape shape : world.content.shapes.values()) {
			ew.drawShape(this, shape);
		}
	}
	
	
}
