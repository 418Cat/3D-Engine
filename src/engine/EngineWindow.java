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

/**
 * a window to show rendered frames from an {@link engine.Engine} instance
 * @author 418cat
 *
 */
public class EngineWindow {
	
	Frame engineFrame;
	Graphics g;
	
	
	/**
	 * @param size : size of the jframe in px
	 * @param location : location of the jframe on screen in px
	 * @param fullscreen : set to fullscreen
	 */
	protected EngineWindow(int[] size, int[] location, boolean fullscreen){
		
		engineFrame = new Frame(size, location, fullscreen);
	
	}
	
	
	/**
	 * show the engine window and start listening to listen & mouse events
	 */
	public void start() {
		engineFrame.show();
		g = engineFrame.frame.getGraphics();
		engineFrame.listen();
	}
	
	/**
	 * track the mouse movement
	 * @param middleCoords : coordinates of the window's middle
	 * @return relativeCoords : coordinates relative to the middle of the window
	 */
	public int[] trackMouse(int[] middleCoords) {
		return(engineFrame.mouse.trackMouse(middleCoords));
	}
	
	/**
	 * a hell that i need to work on
	 * @param eng : engine to draw on
	 * @param shape : shape to draw
	 */
	protected void drawShape(Engine eng, Shape shape) {
		int[] points2dX = new int[shape.points.length];
		int[] points2dY = new int[shape.points.length];
		
		for(int i = 0; i < shape.points.length; i++) {
			
			
		}
		
		g.setColor(shape.color);
		g.fillPolygon(points2dX, points2dY, points2dX.length);
		
	}
	
}


/**
 * a private class used by {@link EngineWindow} to separate a bit the jframe code and the rendering code
 * @author 418cat
 *
 */
class Frame {
	
	protected JFrame frame;
	protected Mouse mouse;
	
	/**
	 * create a new Frame instance
	 * @param size : size of the frame on screen in px
	 * @param location : location of the frame on screen in px
	 * @param fullscreen : set to fullscreen
	 */
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
	
	/**
	 * start listening to mouse & keyboard events
	 */
	protected void listen() {
		frame.addKeyListener(new Keyboard());
		mouse = new Mouse();
		frame.addMouseListener(mouse);
	}
	
	/**
	 * set the frame visible
	 */
	protected void show() {
		frame.setVisible(true);
	}
}