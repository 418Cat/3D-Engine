package main3DPkg;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import MathPkg.Points.Point3D;
import worldObjects.Triangle;

public class MousePos implements MouseMotionListener {

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		/*Triangle tr = (Triangle) Main.triangles[0];
		tr.points[0] = new Point3D(tr.points[0].x, (e.getX() - (double)Main.frameRes[0]/2)/10, (e.getY() - (double)Main.frameRes[1]/2)/10);*/
		Frame.camera.point.y = (e.getX() - (double)Main.frameRes[0]/3);
		Frame.camera.point.z = (e.getY() - (double)Main.frameRes[1]/3);
		Frame.drawFrame();
		
		
	}

}
