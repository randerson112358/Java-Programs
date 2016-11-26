package Comets;

public class SpaceObject {
	
	static double playfieldHeight;
	static double playfieldWidth;
	protected double x;
	protected double y;
	protected double size;
	protected double xVelocity;
	protected double yVelocity;
	
	public SpaceObject (double xPos, double yPos, double xVel, double yVel, double radius){
		
		x = xPos;
		y = yPos;
		xVelocity = xVel;
		yVelocity = yVel;
		size = radius;	
	}
	
	public double getRadius(){
		return size;
	}
	
	public double getXPosition(){
		return x;
	}
	
	public double getYPosition(){
		return y;
	}
	
	public void move(){
		x = x + xVelocity;
		y = y + yVelocity;
		
	if(x > playfieldWidth)
		x = 0;
	if(y > playfieldHeight)
		y=0;
	if(x < 0)
		x = playfieldWidth;
	if(y < 0)
		y = playfieldHeight;
			
	}
	
	public boolean overlapping(SpaceObject rhs){
		if(Math.sqrt((rhs.x-x)*(rhs.x-x) + (rhs.y-y)*(rhs.y-y)) < rhs.size+ size)
			return true;
		else
			return false;
	}
	
	
}
