package engine;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import inputs.Keyboard;
import inputs.Mouse;
import world.objects.Shape;
import world.objects.UserCamera;

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
		int[] points2dX = new int[shape.pointCoords.length];
		int[] points2dY = new int[shape.pointCoords.length];
		
		UserCamera cam = eng.cam;
		
		for(int i = 0; i < shape.pointCoords.length; i++) {
			
			/*points2dX[i] = (engineFrame.frame.getContentPane().getWidth()/2)+(int)(((float)cam.size[0]/2)-(cam.coords()[2]-shape.pointCoords[i][2]) 
					* ((float)1/(cam.coords()[0]-shape.pointCoords[i][0])));
			
			points2dY[i] = (engineFrame.frame.getContentPane().getHeight()/2)+(int)(((float)cam.size[1]/2)-(cam.coords()[1]-shape.pointCoords[i][1])
					* ((float)1/(cam.coords()[0]-shape.pointCoords[i][0])));*/
			//points2DX[i] = 
			//System.out.println("point " + i + " : " +  points2dX[i] + ", " + points2dY[i]);
		}
		
		g.setColor(shape.color);
		g.fillPolygon(points2dX, points2dY, points2dX.length);
		
	}
	
	private int distancebetweenPoints(int[] point1, int[] point2) {
		return((int)Math.sqrt(Math.pow((point1[0] - point2[0]), 2) + Math.pow((point1[1] - point2[1]), 2) + Math.pow((point1[2] - point2[2]), 2)));
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
