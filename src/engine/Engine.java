package engine;

import java.awt.image.BufferedImage;

import world.World;
import world.objects.Shape;
import world.objects.UserCamera;

public class Engine {
	
	UserCamera cam;
	public EngineWindow ew;
	World world;
	BufferedImage nextFrame;
	
	public Engine(int[] size, int[] location, boolean fullscreen, World world){
		ew = new EngineWindow(size, location, fullscreen);
		this.world = world;
		this.cam = world.getCam();
	}
	
	public void clear() {
		ew.g.clearRect(0, 0, ew.engineFrame.frame.getWidth(), ew.engineFrame.frame.getHeight());
	}

	public void render() {
		for(Shape shape : world.content.shapes) {
			ew.drawShape(this, shape);
		}
	}
	
	
}
