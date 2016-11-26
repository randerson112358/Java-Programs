package Comets;




public abstract class Comet extends SpaceObject {
	
	public Comet(double xPos, double yPos, double xVel, double yVel, double radius)
	{
		super(xPos, yPos, xVel, yVel, radius);
	}
	
	public abstract java.util.Vector<Comet> explode();
	
	
	
}
