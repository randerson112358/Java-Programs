package Comets;

public class Shot extends SpaceObject{
	
	public static double radius = 3;
	public int age=0;
	
	public Shot(double xPos, double yPos, double xVel, double yVel){
		
		super(xPos, yPos, xVel, yVel, radius);
		
	}
	
	public int getAge(){
		
		return age;
		
		
	}

	public void move(){
		
		super.move();
		age++;
		
	}
	
	
}
