package Comets;

import java.util.Vector;

public class MediumComet extends Comet {
	
	public static double radius = 30;
	
	MediumComet(double xPos, double yPos, double xVel, double yVel){
		
		super(xPos, yPos, xVel, yVel, radius);
		
	}

	public java.util.Vector<Comet> explode(){
		
		 double randxVelocity;
		 double randyVelocity;
		
		randxVelocity = Math.random() * 100 %10;
		randyVelocity = Math.random() * 100 %10;
		
		SmallComet sml1 = new SmallComet(super.x,super.y,randxVelocity,randyVelocity);
		
		randxVelocity = Math.random() * 100 %10;
		randyVelocity = Math.random() * 100 %10;
		
		SmallComet sml2 = new SmallComet(super.x,super.y,randxVelocity,randyVelocity);
		
		randxVelocity = Math.random() * 100 %10;
		randyVelocity = Math.random() * 100 %10;
		
		SmallComet sml3 = new SmallComet(super.x,super.y,randxVelocity,randyVelocity);
		
		Vector<Comet> vector = new Vector<Comet>();
		vector.add(sml1);
		vector.add(sml2);
		vector.add(sml3);
		
		return vector;
			
}
	
}
