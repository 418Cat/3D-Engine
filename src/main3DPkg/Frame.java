package main3DPkg;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import worldObjects.Camera;

public class Frame {
	
	public static final JFrame frame = new JFrame();
	public static int[] resolution = new int[2];
	public static Camera camera;
	public static Graphics g;
	
	public static void init(String name, int[] resolution, int[] coords, Camera cam)
	{
		frame.setName(name);
		frame.setSize(resolution[0], resolution[1]);
		frame.setLocation(coords[0], coords[1]);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.addMouseMotionListener(new MousePos());
		frame.addMouseWheelListener(new MouseScroll());
		frame.addKeyListener(new KeyBrListener());
		frame.setVisible(true);
		
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		Frame.resolution = resolution;
		Frame.camera = cam;
		g = frame.getGraphics();
	}
	
	public static void drawFrame()
	{
		g.clearRect(0, 0, resolution[0], resolution[1]);
		BufferedImage bfImg = camera.render();
		while (!g.drawImage(bfImg, 0, 0, resolution[0], resolution[1], 0, 0, bfImg.getWidth(), bfImg.getHeight(), frame));
	}
	
	

}
