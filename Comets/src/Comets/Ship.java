package Comets;

public class Ship extends SpaceObject {
	
	public static double radius = 10;
	public static double angle = 0; //radians; from radians to degrees, multiply by 180/pi
	public static double turningRate = .1;
	
	
	
	public Ship(double xPos, double yPos, double xVel, double yVel) {
		
		super(xPos, yPos, xVel, yVel, radius);
		
	}
	
	 public void accelerate() {
		 
		 double deltaVx = .1*Math.sin(angle);
		 double deltaVy = .1*Math.cos(angle);
		 
		 super.xVelocity = super.xVelocity + deltaVx;
		 super.yVelocity = super.yVelocity + deltaVy;
		 
		 double speed = Math.sqrt((super.xVelocity*super.xVelocity) + (super.yVelocity*super.yVelocity));
		 
		 
		 if(speed > 10){
			 super.xVelocity = super.xVelocity * 10/speed;
			 super.yVelocity = super.yVelocity * 10/speed;
		 	}
		 
		 
	 }
	 
	 public Shot fire() {
		
		 double shotVelocityX = 3*Math.sin(angle) + super.xVelocity;
		 double shotVelocityY = 3*Math.cos(angle) + super.yVelocity;
		 
		 Shot myShot = new Shot(super.x ,super.y , shotVelocityX, shotVelocityY);
		 
		 return myShot;
		 
	 }
	
	 public double getAngle(){
		 
		 return angle;
		 
	 }
	 
	 public void rotateLeft(){
		 //update the angle
		 angle = angle + .1;
		 
	 }
	 
	 public void rotateRight(){
		 //update the angle
		 angle = angle - .1;
		 
	 }

}
