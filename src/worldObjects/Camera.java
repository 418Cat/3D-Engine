package worldObjects;

import java.awt.Color;
import java.awt.image.BufferedImage;

import MathPkg.Angle.Angle2D.AbsAngle;
import MathPkg.Angle.Angle2D.Angle;
import MathPkg.Points.Point2D;
import MathPkg.Points.Point3D;
import MathPkg.Vectors.Vector2D;
import MathPkg.Vectors.Vector3D;
import main3DPkg.Frame;
import main3DPkg.Main;

public class Camera {
	
	public int[] resolution = new int[2];
	public Point3D point;
	public double[] FOV = new double[2];
	public Vector3D front;
	
	public final boolean WIREFRAME = true;
	public final boolean POINTS = false;
	
	
	public Camera(int[] resolution, Point3D point, double horizontalFOV, Vector3D orientation)
	{
		this.resolution = resolution;
		this.point = point;
		this.FOV[0] = horizontalFOV;
		this.FOV[1] = horizontalFOV * ((double)resolution[1] / (double)resolution[0]);
		
		if(FOV[0] >= 180 || FOV[0] <= 0)
		{
			throw new IllegalArgumentException("The FOV can't be equal to or more than 180 or less than 0.");
		}
		if(FOV[1] >= 180)
		{
			throw new IllegalArgumentException("You entered an horizontal FOV between 0 and 180, but the vertical FOV is not between 0 and 180.\nTry either lowering the vertical resolution or the horizontal FOV.");
		}
		
		front = orientation.unit().multiply((double)resolution[0]/2 * Math.tan((double)FOV[0]/2));
	}
	
	public void changeFOV(double fov)
	{
		this.FOV[0] = fov;
		this.FOV[1] = fov * ((double)resolution[1] / (double)resolution[0]);
		
		/*if(FOV[0] >= 180 || FOV[0] <= 0)
		{
			throw new IllegalArgumentException("The FOV can't be equal to or more than 180 or less than 0.");
		}
		if(FOV[1] >= 180)
		{
			throw new IllegalArgumentException("You entered a horizontal FOV between 0 and 180, but the vertical FOV is not between 0 and 180.\nTry either lowering the vertical resolution or the horizontal FOV.");
		}*/
	}
	
	public void changeFront(Vector3D vect)
	{
		front = vect.unit().multiply((double)resolution[0]/2 * Math.tan((double)FOV[0]/2));
	}
	
	public BufferedImage render()
	{
		BufferedImage bfImg = new BufferedImage(this.resolution[0], this.resolution[1], BufferedImage.TYPE_4BYTE_ABGR);
		
		for(Triangle tr : Main.triangles)
		{
			Point2D AFlat = getPointOnCam(tr.points[0]);
			Point2D BFlat = getPointOnCam(tr.points[1]);
			Point2D CFlat = getPointOnCam(tr.points[2]);
			
			if(POINTS)
			{
				if(AFlat != null) {
					bfImg.setRGB((int)(AFlat.x), (int)(AFlat.y), 255 << 24 + 255);
				};
				if(BFlat != null) {
					bfImg.setRGB((int)(BFlat.x), (int)(BFlat.y), 255 << 24 + 255);
				};
				if(CFlat != null) {
					bfImg.setRGB((int)(CFlat.x), (int)(CFlat.y), 255 << 24 + 255);
				};
			}
			
			if(WIREFRAME)
			{
				if(AFlat != null && BFlat != null && CFlat != null)
				{
					int[] xPnt = {(int)AFlat.x * Main.frameRes[0]/this.resolution[0], (int)BFlat.x * Main.frameRes[0]/this.resolution[0], (int)CFlat.x * Main.frameRes[0]/this.resolution[0]};
					int[] yPnt = {(int)AFlat.y * Main.frameRes[1]/this.resolution[1], (int)BFlat.y * Main.frameRes[1]/this.resolution[1], (int)CFlat.y * Main.frameRes[1]/this.resolution[1]};
					
					/*Frame.g.setColor(Color.gray);
					Frame.g.fillPolygon(xPnt, yPnt, 3);*/
					Frame.g.setColor(Color.red);
					Frame.g.drawPolygon(xPnt, yPnt, 3);
				}
			}
		}
		
		return bfImg;
	}
	
	public Point2D getPointOnCam(Point3D pnt)
	{
		
		double divider = 1.2;
		
		Vector2D thisToPntXY = new Vector2D(new Point2D(this.point.x, this.point.y), new Point2D(pnt.x, pnt.y));
		double XYAngle = AbsAngle.angle(thisToPntXY, new Vector2D(this.front.x, this.front.y));
		if(XYAngle > FOV[0]/divider) return null;
		
		double x = Angle.angle(thisToPntXY, new Vector2D(this.front.x, this.front.y)) > (FOV[0]/divider) ? resolution[0]/2 - Math.tan(XYAngle * Math.PI/180) * front.norm() : resolution[0]/2 + Math.tan(XYAngle * Math.PI/180) * front.norm();
		
		Vector2D thisToPntXZ = new Vector2D(new Point2D(this.point.x, this.point.z), new Point2D(pnt.x, pnt.z));
		double XZAngle = AbsAngle.angle(thisToPntXZ, new Vector2D(this.front.x, this.front.z));
		if(XZAngle > FOV[1]/divider) return null;
		
		double y = Angle.angle(thisToPntXZ, new Vector2D(this.front.x, this.front.z)) > (FOV[1]/divider) ? resolution[1]/2 - Math.tan(XZAngle * Math.PI/180) * front.norm() : resolution[1]/2 + Math.tan(XZAngle * Math.PI/180) * front.norm();
		
		return new Point2D(x, y);
	}
	
}
