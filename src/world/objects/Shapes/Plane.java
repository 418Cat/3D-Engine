package world.objects.Shapes;

import java.awt.Color;

import world.objects.Shape;

public class Plane extends Shape {
	
	public Plane(int[][] points, Color color){
		this.pointCoords = points;
		this.color = color;
	}
	
}
