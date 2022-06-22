package engine;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import inputs.Keyboard;
import inputs.Mouse;

public class EngineWindow {
	
	Frame engineFrame;
	
	public EngineWindow(int[] size, int[] location, boolean fullscreen){
		
		engineFrame = new Frame(size, location, fullscreen);
		engineFrame.show();
	}
	
}





class Frame {
	
	public JFrame frame;
	
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
	
	public void listen() {
		frame.addKeyListener(new Keyboard());
		frame.addMouseListener(new Mouse());
	}
	
	public void show() {
		frame.setVisible(true);
	}
}
