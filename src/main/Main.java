package main;

import java.awt.Color;

import engine.Engine;
import world.World;

public class Main {

	public static void main(String[] args) {
		
		World world = new World(new int[] {500, 500, 500}, Color.black, new int[] {600, 600}, 90);
		
		@SuppressWarnings("unused")
		Engine engine = new Engine(new int[] {1920, 1080}, new int[] {0, 0}, false, world);
		
		world.content.addPlane(new int[][] {{-1, -35, 0}, {-900, -50, 0}, {0, -20, -30}}, Color.red);
		
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		engine.render();
		
	}

}
