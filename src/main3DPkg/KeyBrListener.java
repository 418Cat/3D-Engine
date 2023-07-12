package main3DPkg;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBrListener implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		char key = e.getKeyChar();
		if(key == 'z') {
			Frame.camera.point.x += 15;
			System.out.println("avant");
		}
		if(key == 's') {
			System.out.println("arrière");
			Frame.camera.point.x -= 15;
		}
		
		if(key == 'r') Main.loadFile();
		
		if(key == 'q') {
			Frame.camera.point.y -= 5;
		}
		if(key == 'd') Frame.camera.point.y += 5;
		
		if(key == 'a') Frame.camera.point.z += 5;
		if(key == 'e') Frame.camera.point.z -= 5;
		
		Frame.drawFrame();
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
