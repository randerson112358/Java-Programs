package Comets;

import java.lang.Math;
import java.util.Vector;


public class LargeComet extends Comet {
	
	public static double radius = 40;
	
	
	public LargeComet(double xPos, double yPos, double xVel, double yVel){
		
		super(xPos, yPos, xVel, yVel, radius);
		
	}
	
	public java.util.Vector<Comet> explode(){
		
		
		 double randxVelocity;
		 double randyVelocity;
		
		randxVelocity = Math.random() * 100 %10;
		randyVelocity = Math.random() * 100 %10;
		
		MediumComet med1 = new MediumComet(super.x,super.y,randxVelocity,randyVelocity);
		
		randxVelocity = Math.random() * 100 %10;
		randyVelocity = Math.random() * 100 %10;
		
		MediumComet med2 = new MediumComet(super.x,super.y,randxVelocity,randyVelocity);
		
		Vector<Comet> vector = new Vector<Comet>();
		vector.add(med1);
		vector.add(med2);
		
		return vector;
		
	}

}
