package engine;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import inputs.Keyboard;
import inputs.Mouse;
import world.objects.Shape;
import world.objects.UserCamera;
import engine.math.*;

public class EngineWindow {
	
	Frame engineFrame;
	Graphics g;
	
	protected EngineWindow(int[] size, int[] location, boolean fullscreen){
		
		engineFrame = new Frame(size, location, fullscreen);
	
	}
	
	public void start() {
		engineFrame.show();
		g = engineFrame.frame.getGraphics();
		engineFrame.listen();
	}
	
	public int[] trackMouse(int[] middleCoords) {
		return(engineFrame.mouse.trackMouse(middleCoords));
	}
	
	protected void drawShape(Engine eng, Shape shape) {
		int[] points2dX = new int[shape.points.length];
		int[] points2dY = new int[shape.points.length];
		
		UserCamera cam = eng.cam;
		
		for(int i = 0; i < shape.points.length; i++) {
			
			int x = (int)(cam.coords()[0] + Math.cos(Math.toRadians(cam.fov/2 + cam.angle[0]))*10);
			int z = (int)(cam.coords()[1] + Math.sin(Math.toRadians(cam.fov/2 + cam.angle[0]))*10);
			
			//System.out.println(x + ", 0, " + z);
			
			Vector3D vectTmp = new Vector3D(cam.point(), new Point3D(x, cam.point().y(), z));
			Vector3D camToPoint = new Vector3D(cam.point(), new Point3D(shape.points[0].x(), cam.point().y(), shape.points[0].z()));
			
			points2dX[i] = (camToPoint.angleDeg(vectTmp)/cam.fov)*engineFrame.frame.getWidth();
			System.out.println("camToPoint = " + camToPoint.x() + ", " + camToPoint.y() + ", " + camToPoint.z());
			System.out.println("vectTmp = " + vectTmp.x() + ", " + vectTmp.y() + ", " + vectTmp.z());
			System.out.println("angle = " + camToPoint.angleDeg(vectTmp));
			
			
			x = (int)(cam.coords()[0] + Math.cos(Math.toRadians(cam.aspectRatio*cam.fov/2 + cam.angle[1]))*100);
			int y = (int)(cam.coords()[1] + Math.sin(Math.toRadians(cam.aspectRatio*cam.fov/2 + cam.angle[1]))*100);
			
			vectTmp = new Vector3D(cam.point(), new Point3D(x, y, cam.point().z()));
			camToPoint = new Vector3D(cam.point(), new Point3D(shape.points[0].x(), shape.points[0].y(), cam.point().z()));
			
			points2dY[i] = (int) ((camToPoint.angleDeg(vectTmp)/(cam.fov*cam.aspectRatio))*engineFrame.frame.getHeight());
			
			//System.out.println("point = " + points2dX[i] + ", " + points2dY[i]);
			
			
		}
		
		g.setColor(shape.color);
		g.fillPolygon(points2dX, points2dY, points2dX.length);
		
	}
	
}

class Frame {
	
	protected JFrame frame;
	protected Mouse mouse;
	
	Frame(int[] size, int[] location, boolean fullscreen){
		
		Dimension paneSize = new Dimension();
		paneSize.setSize(size[0], size[1]);
		
		frame = new JFrame("3D Engine");
		frame.setUndecorated(fullscreen);
		frame.setSize(size[0], size[1]);
		frame.getContentPane().setPreferredSize(paneSize);
		frame.setLocation(location[0], location[1]);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		// Transparent 16 x 16 pixel cursor image.
		BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);

		// Create a new blank cursor.
		Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
		    cursorImg, new Point(0, 0), "blank cursor");

		// Set the blank cursor to the JFrame.
		frame.getContentPane().setCursor(blankCursor);
		
	}
	
	protected void listen() {
		frame.addKeyListener(new Keyboard());
		mouse = new Mouse();
		frame.addMouseListener(mouse);
	}
	
	protected void show() {
		frame.setVisible(true);
	}
}