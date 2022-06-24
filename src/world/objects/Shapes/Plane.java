package world.objects.Shapes;

import java.awt.Color;

import engine.math.Point3D;
import world.objects.Shape;

public class Plane extends Shape {
	
	public Plane(Point3D[] points, Color color){
		this.points = points;
		this.color = color;
	}
	
}
