package Comets;

import java.util.Vector;

public class SmallComet extends Comet {
	
	public static double radius = 20;
	
	public SmallComet(double xPos, double yPos, double xVel, double yVel) {
		
		super(xPos, yPos, xVel, yVel, radius);
		
	}
	
	public java.util.Vector<Comet> explode(){
		
		return new Vector<Comet>();
		
	}

}
