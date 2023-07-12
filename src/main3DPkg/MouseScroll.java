package main3DPkg;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import MathPkg.Points.Point3D;
import MathPkg.Vectors.Vector3D;
import worldObjects.Triangle;

public class MouseScroll implements MouseWheelListener {

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		
		/*Triangle tr = (Triangle) Main.triangles[0];
		tr.points[0] = new Point3D(tr.points[0].x + e.getPreciseWheelRotation(), tr.points[0].y, tr.points[0].z);*/
		Frame.camera.point.x += e.getPreciseWheelRotation() * 5;
		Frame.drawFrame();
	}

}
