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
		
		world = new World(new int[] {500, 500, 500}, Color.black, new int[] {600, 600}, 70);
		
		engine = new Engine(new int[] {1920, 1080}, new int[] {0, 0}, false, world);
		
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		engine.ew.start();
		
		int interval = 100;
		
		
		Point3D[] planeCoords = {new Point3D(20, -0, 10)};
		world.content.addPlane(planeCoords, Color.red);
		
		//double sin = (Math.sin((float)new Date().getTime()*1));
		
		while(true) {
			
			if(Math.floorMod(new Date().getTime(), interval) == 0) {
				/*sin = Math.sin(new Date().getTime()*1);
				world.content.removeObjElement(0);*/
				engine.clear();
				/*planeCoords[1][2] = (int)(sin*9000);
				planeCoords[3][2] = (int)(-sin*9000);
				world.content.addPlane(planeCoords, Color.red);*/
				int[] mvmnt = engine.ew.trackMouse(new int[] {960, 540});
				
				world.getCam().turn(mvmnt);
				engine.render();
				
			}
		}
		
	}

}
