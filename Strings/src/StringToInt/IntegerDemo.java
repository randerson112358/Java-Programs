package StringToInt;

import java.lang.*;

public class IntegerDemo {

   public static void main(String[] args) {

     // parses the string argument
     int a = Integer.parseInt("12");
     int b = Integer.parseInt("26");
     int c = Integer.parseInt("54");
     int digit = Integer.parseInt("3456789".substring(0, 1));

     int m = a * b * c;
     System.out.print("Value after multiplying = " + m);
   }
} 