package engine;

import java.awt.image.BufferedImage;

import world.World;
import world.objects.UserCamera;
import world.objects.Shapes.Shape;

public class Engine {
	
	UserCamera cam;
	EngineWindow ew;
	World world;
	BufferedImage nextFrame;
	
	public Engine(int[] size, int[] location, boolean fullscreen, World world){
		ew = new EngineWindow(size, location, fullscreen);
		this.world = world;
		this.cam = world.getCam();
	}

	public void render() {
		for(Shape shape : world.content.shapes) {
			ew.drawShape(this, shape);
		}
	}
	
	
}
