
public class Conditional {

	public static void main(String[] args) {
		
		/*
		 * //Boolean Operators
				int a = 4;
				int b = 5;
				boolean result;
				result = a < b; // true
				result = a > b; // false
				result = a <= 4; // a smaller or equal to 4 - true
				result = b >= 6; // b bigger or equal to 6 - false
				result = a == b; // a equal to b - false
				result = a != b; // a is not equal to b - true
				result = a > b || a < b; // Logical or - true
				result = 3 < a && a < 6; // Logical and - true
				result = !result; // Logical not - false
		 * */
     
     int a = 8;
     boolean b = (a != 8); //true or false
     
     //If else statements
     if( b == true){
    	 System.out.println("Who let the dogs out !");
     }
     else if( a < 10){
    	 System.out.println("The dogs just ran away !");
     }
     else{
    	 System.out.println("I let the dogs out !");
     }
	  
     //A different way to write if and else statements without brackets
     if(a == 5)
    	 System.out.println("a is 5");
     else if(a == 6)
    	 System.out.println("a is 6");
     else
    	 System.out.println("a is NOT 5 or 6");
     
     /*TERNARY OPERATOR */
     int c1 = 1;
     int result; 
     
     if(c1 == 1){
    	 result = 1;
     }
     else{
    	 result = 2;
     }
     //Here is the above represented using the ternary operator
     result = c1 == 1 ? 1: 2;
     
     
     /*COMPARING OBJECTS TO USE IN CONDITIONAL STATEMENTS*/
     String str1 = new String("Hi"); 
     String str2 = new String("Hi");
     String sameStr1 = str1;
     
     boolean r1 = str1 == str2;// This will be false, since str1 and str2 are not the same object
     boolean r2 = str1.equals(str2); // This is true, since str1 and str2 are logically equal
     boolean r3 = str1 == sameStr1; // This is true, since str1 and sameStr1 are really the same object
     
     if(r3 == true){
    	 System.out.println("sameStr1 == str1");
     }
     if(r2 == true){
    	 System.out.println("str1.equals(str2)");
     }
     if(r1 == true){
    	 System.out.println("str1 == str2");
     }
     
	}
}
