package inputs;

import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse implements MouseListener {
	
	private int[] mouse = {0, 0};
	private Robot r = null;

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public int[] trackMouse(int[] middleCoords) {
		int[] newCoords = {MouseInfo.getPointerInfo().getLocation().x - mouse[0], MouseInfo.getPointerInfo().getLocation().y - mouse[1]};
		mouse[0] = MouseInfo.getPointerInfo().getLocation().x;
		mouse[1] = MouseInfo.getPointerInfo().getLocation().y;
		
		try {
			r = new Robot();
			r.mouseMove(middleCoords[0], middleCoords[1]);
		} catch(Exception error) {
			System.err.println(error.toString());
		}
		
		return(newCoords);
	}

}
