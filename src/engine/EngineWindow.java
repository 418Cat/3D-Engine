package engine;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import inputs.Keyboard;
import inputs.Mouse;
import world.objects.UserCamera;
import world.objects.Shapes.Shape;

public class EngineWindow {
	
	Frame engineFrame;
	Graphics g;
	
	protected EngineWindow(int[] size, int[] location, boolean fullscreen){
		
		engineFrame = new Frame(size, location, fullscreen);
		engineFrame.show();
		g = engineFrame.frame.getGraphics();
	
	}
	
	protected void drawShape(Engine eng, Shape shape) {
		int[] points2dX = new int[shape.pointCoords.length];
		int[] points2dY = new int[shape.pointCoords.length];
		
		UserCamera cam = eng.cam;
		
		for(int i = 0; i < shape.pointCoords.length; i++) {
			
			points2dX[i] = (engineFrame.frame.getContentPane().getWidth()/2)+(int)(((float)cam.size[0]/2)-(cam.coords()[2]-shape.pointCoords[i][2]) 
					* ((float)1/(cam.coords()[0]-shape.pointCoords[i][0])));
			
			points2dY[i] = (engineFrame.frame.getContentPane().getHeight()/2)+(int)(((float)cam.size[1]/2)-(cam.coords()[1]-shape.pointCoords[i][1])
					* ((float)1/(cam.coords()[0]-shape.pointCoords[i][0])));
			System.out.println("point " + i + " : " + points2dX[i] + ", " + points2dY[i]);
		}
		
		g.setColor(shape.color);
		g.fillPolygon(points2dX, points2dY, points2dX.length);
		//g.fillRect(points2dX[1], points2dY[1], 50, 50);
		 
		
	}
	
}

class Frame {
	
	protected JFrame frame;
	
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
		frame.addMouseListener(new Mouse());
	}
	
	protected void show() {
		frame.setVisible(true);
	}
}
