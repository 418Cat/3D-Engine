package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.Main;

public class Keyboard implements KeyListener{
	
	private int movement = 3;

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
			case 81:
				Main.world.getCam().move(0, 0, movement*300);
				break;
			case 90:
				Main.world.getCam().move(movement, 0, 0);
				break;
			case 68:
				Main.world.getCam().move(0, 0, -movement*300);
				break;
			case 83:
				Main.world.getCam().move(-movement, 0, 0);
				break;
			case 87:
				Main.world.getCam().move(0, -movement*300, 0);
				break;
			case 88:
				Main.world.getCam().move(0, movement*300, 0);
				break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
