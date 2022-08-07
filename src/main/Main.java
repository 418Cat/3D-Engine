package main;

import java.awt.Color;
import java.util.Date;

import engine.Engine;
import engine.math.Point3D;
import world.World;

public class Main {
	
	public static World world;
	public static Engine engine;

	public static void main(String[] args) {
		
		world = new World(Color.black, new int[] {600, 600}, 70);
		
		engine = new Engine(new int[] {1920, 1080}, new int[] {0, 0}, false, world);
		
		try {
			Thread.sleep(500); //wait a bit for the frame to initialize a bit
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		
		engine.ew.start();
		
		//max interval between frames in ms
		int interval = 100;
		
		
		Point3D[] planeCoords = {new Point3D(20, -0, 10)};
		world.content.addPlane("plane_001", planeCoords, Color.red);
		
		while(true) {
			
			if(Math.floorMod(new Date().getTime(), interval) == 0) { //limit to max interval
				
				//clear the frame
				engine.clear();
				
				//track mouse movement
				int[] mvmnt = engine.ew.trackMouse(new int[] {960, 540});
				world.getCam().turn(mvmnt);
				
				//render new frame
				engine.render();
				
			}
		}
	}
}
