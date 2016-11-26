package ScrambleWord;

import java.lang.*;
import java.util.*;



public class ScrambleWord {
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		String word = "word";
		int N = word.length();
		
		for(int i=1; i<N; i++)
		{
			int r = i + (int) (Math.random() * (N-i-1));
			 char t = word.charAt(r);
			 word.replace(word.charAt(r), word.charAt(i));
			 word.replace(word.charAt(i), t);
			 
			 System.out.println("replace "+word.charAt(r)+" with "+word.charAt(i));
			 System.out.println(word);
		}
		
		word.replace( 'r', word.charAt(0));
		 System.out.println(word);
		
		
	}

}
