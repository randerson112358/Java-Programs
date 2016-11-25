package tictactoe;
import java.util.Scanner; 
import java.math.*;

public class tictactoe2 {

	static int ROW = 3;
	static int COL = 3;
    static char[][] board = new char[ROW][COL];
    static int turnPlayer=1;
    static int firstMove;
    static int difficulty;
	
	public static void main(String[] args) {
		
		// Varibles to be used
		Scanner scan = new Scanner(System.in); 
		int i,j;// board positions Row and column (i=y coordinate, j=x coordinate)
		int usrChoice; // The users choice to play against friend or computer
		char player1, player2; // The human players
		
		
		//Main Menu for Tic Tac Toe
		System.out.println("Welcome to Rodney's Tic Tac Toe game !");
		System.out.println("Please Choose one of the following:");
		System.out.println("(1) Play with a friend");
		System.out.println("(2) Play with the computer");
		usrChoice = scan.nextInt();
		player1 ='x';//assign x's to player one
		
		if(usrChoice == 2)//Play with the computer
		{
			System.out.println("\t Choose Difficulty:");
			System.out.println("\t \t (3)Easy\n \t \t (4)Medium\n \t \t (5)Impossible\n");
			difficulty = scan.nextInt();
		}
		
		//Creates an empty tic tac toe board
		createBoard();
		
		//1st move for the computer
		firstMove = 1;
		
		do{
			//Play game
			System.out.println("Please Enter position (Row,Column):");
			System.out.print("Row:");
			i = scan.nextInt();//scans in the i position 
			System.out.print("Column:");
			j = scan.nextInt();// scans in the j position 
			
			//Checks the user places character in empty spot
			while(checkPosition(i,j) != 1){
				System.out.println("Spot is taken or unavailable, please choose a different position");
				i = scan.nextInt();//scans in the i position column
				j = scan.nextInt();// scans in the j position row
			}
			
				//board[i][j]= c;
			updateBoard(i,j,player1);//Places the character in the correct position
			System.out.println();//Print line
			
			
			if(usrChoice == 1 && (checkWin() != 1 && isTie() != 1))//Play with a friend
			{
				System.out.println("1");
			}
			else if(usrChoice == 2 && (checkWin() != 1 && isTie() != 1))//Play with the computer
			{
				
				computerMove(difficulty, player1);
			}
			
			printBoard();//prints the tic tac toe board
			
		}while(checkWin() != 1 && isTie() != 1);//Runs until a player has won or tied
	
		if(isTie() == 1)
		{System.out.println("It's a tie !");}
		else if(checkWin() == 1)
		{System.out.println("Congratulations you win!");}
	
	}//End Main Method
	
	//Creates an empty 3x3 board
	public static void createBoard(){
		for(int i=0; i<ROW; i++)
			for(int j=0; j<COL; j++){
				board[i][j] = ' ';
		    }
	}
	
	//Prints the board to the screen
	public static void printBoard(){
		
		for(int i=0; i<ROW; i++){
			for(int j=0; j<COL; j++){
		       System.out.print(board[i][j]);
		       //Prints | behind every column except column 2 
		       if(j!=2)
		    	   System.out.print("|");  
		    }
			//Prints the next line
			System.out.println();
			
			//Prints '- - -' to the bottom of every row except row 2
			if(i!=2)
		    System.out.println("_ _ _");
		    	   
		}
	}
	
	//Update positions on the board
	public static int updateBoard(int i, int j, char c){
	
		//if c = 'x' or 'y' and the position at (i,j) isn't already taken, then make position (i,j) the value of c
		if(checkChar(c)==1 && checkPosition(i,j) == 1){
			board[i][j] = c;
			return 1;
		}
		else
			return 0;
		
	}
	
	//Check if the position (i,j) is empty and within the board parameters (aka 0<=i<3 and 0<=j<3 )
	public static int checkPosition(int i, int j){
	    if((i>=0 && i<3) && (j>=0 && j<3) && ( board[i][j] == ' '))
	    {
			return 1;
		}
		else
			return 0;
	}
	
	//Checks if the charcter 'c' is either an 'x' or a 'y' by returning the value 1 if true , 0 if false
	public static int checkChar(char c){
		
		if(c == 'x'  || c == 'y')
			return 1;
		else
			return 0;
	}
	
	//Checks if a player has won by returning the value 1 if true and 0 if false
	public static int checkWin(){
		
		//Check if the winning position is one of the 3 rows across or 3 rows down the board
		for(int j=0; j<ROW; j++){
			// Across
			if(board[j][0] == board[j][1] && board[j][1] == board[j][2] && board[j][0] != ' ')
				return 1;
			// Down
			else if(board[0][j] == board[1][j] && board[2][j] == board[1][j] && board[0][j] != ' ')
				return 1;
		}
		//Horizontal Right
		if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ')
			return 1;
		//Horizontal Left
		else if(board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ')
			return 1;

			return 0;
	}
	//Checks if the result is a tie
	public static int isTie(){
		
		for(int i=0; i<COL; i++)
			for(int j=0; j<ROW; j++)
			{
				// if an empty spot is found then it's not a tie
				if(board[i][j] == ' ')
					return 0;
			}
		return 1;
	}
	
	//Checks if a player could win by going to a position on the board and returns that position number 
        // bases off of the below idea of the matrix/board. NOTE: position (0,0) = 1 on the below board and so on.
	// [1,2,3]
	// [4,5,6]
	// [7,8,9]
	public static int couldWin(char c){
		
		//Checking Rows
		if(board[0][0] == c && board[0][1] == c && board[0][2] == ' ')
			return 3;
		else if (board[0][0] == c && board[0][2] == c && board[0][1] == ' ')
			return 2;
		else if (board[0][1] == c && board[0][2] == c && board[0][0] == ' ')
			return 1;
		else if(board[1][0] == c && board[1][1] == c && board[1][2] == ' ')
			return 6;
		else if (board[1][0] == c && board[1][2] == c && board[1][1] == ' ')
			return 5;
		else if (board[1][1] == c && board[1][2] == c && board[1][0] == ' ')
			return 4;
		else if(board[2][0] == c && board[2][1] == c && board[2][2] == ' ')
			return 9;
		else if (board[2][0] == c && board[2][2] == c && board[2][1] == ' ')
			return 8;
		else if (board[2][1] == c && board[2][2] == c && board[2][0] == ' ')
			return 7;
		
		//Check Columns
		if(board[0][0] == c && board[1][0] == c && board[2][0] == ' ')
			return 7;
		else if(board[0][0] == c && board[2][0] == c && board[1][0] == ' ')
			return 4;
		else if(board[1][0] == c && board[2][0] == c && board[0][0] == ' ')
			return 1;
		else if(board[0][1] == c && board[1][1] == c && board[2][1] == ' ')
			return 8;
		else if(board[0][1] == c && board[2][1] == c && board[1][1] == ' ')
			return 5;
		else if(board[1][1] == c && board[2][1] == c && board[0][1] == ' ')
			return 2;
		else if(board[0][2] == c && board[1][2] == c && board[2][2] == ' ')
			return 9;
		else if(board[0][2] == c && board[2][2] == c && board[1][2] == ' ')
			return 6;
		else if(board[1][2] == c && board[2][2] == c && board[0][2] == ' ')
			return 3;
		
		//Checking Diagnols
		if(board[0][0] == c && board[1][1] == c && board[2][2] == ' ')
			return 9;
		else if(board[1][1] == c && board[2][2] == c && board[0][0] == ' ')
			return 1;
		else if(board[0][0] == c && board[2][2] == c && board[1][1] == ' ')
			return 5;
		else if(board[0][2] == c && board[1][1] == c && board[2][0] == ' ')
			return 7;
		else if(board[1][1] == c && board[2][0] == c && board[0][2] == ' ')
			return 3;
		else if(board[0][2] == c && board[2][0] == c && board[1][1] == ' ')
			return 5;
		
		return 0;
		
	}
	
	/***Computer A.I. Method****/
	//Based on the difficulty level, determines the position the computer chooses.
	public static int computerMove(int difficulty, char opp){
		
		char ch;
		
		if(opp == 'x')
			ch = 'y';
		else
			ch = 'x';
		
		if(difficulty == 3)// Easy
		{
			//Choose next available position
			for(int y=0; y<3; y++)
				for(int x=0; x<3; x++)
				{
					if(checkPosition(y,x) == 1)
					{
						updateBoard(y,x,ch);
						return 1;
					}
				}
		}
		else if(difficulty == 4)// Medium
		{
			//Randomly choose x and y position for computer
			int x = (int)((Math.random()*10) %3);
			int y= (int)((Math.random()*10) %3);
			//System.out.println("x "+x+"y"+y);
			//Choose Random position in open space
			while(checkPosition(y,x) != 1)
			{
				x = (int)((Math.random()*10) %3);
			    y= (int)((Math.random()*10) %3);
				//updateBoard(y,x,ch);
			}
			
			updateBoard(y,x,ch);
		}
		else if(difficulty == 5)// Hard/Impossible to win
		{
			if(firstMove == 1)
			{
				if(checkPosition(1,1) == 1){
					updateBoard(1,1,ch);
				}
				else
				{
					//choose corner
					for(int i=0; i< 3; i+=2)
						for(int j=0; j<3; j+=2)
							if(checkPosition(i,j) == 1){
								updateBoard(i,j,ch);
								i=3;
								break;}
					
					
				}
				firstMove = 0;
					
			}
			else
			{
				if(couldWin(ch) != 0)// check if computer can win
				{
					if(couldWin(ch) == 1)
						updateBoard(0,0,ch);
					else if(couldWin(ch) == 2)
						updateBoard(0,1,ch);
					else if(couldWin(ch) == 3)
						updateBoard(0,2,ch);
					else if(couldWin(ch) == 4)
						updateBoard(1,0,ch);
					else if(couldWin(ch) == 5)
						updateBoard(1,1,ch);
					else if(couldWin(ch) == 6)
						updateBoard(1,2,ch);
					else if(couldWin(ch) == 7)
						updateBoard(2,0,ch);
					else if(couldWin(ch) == 8)
						updateBoard(2,1,ch);
					else if(couldWin(ch) == 9)
						updateBoard(2,2,ch);
					
				}
				else if(couldWin(opp) != 0)// check if opponent can win
				{
					if(couldWin(opp) == 1)
						updateBoard(0,0,ch);
					else if(couldWin(opp) == 2)
						updateBoard(0,1,ch);
					else if(couldWin(opp) == 3)
						updateBoard(0,2,ch);
					else if(couldWin(opp) == 4)
						updateBoard(1,0,ch);
					else if(couldWin(opp) == 5)
						updateBoard(1,1,ch);
					else if(couldWin(opp) == 6)
						updateBoard(1,2,ch);
					else if(couldWin(opp) == 7)
						updateBoard(2,0,ch);
					else if(couldWin(opp) == 8)
						updateBoard(2,1,ch);
					else if(couldWin(opp) == 9)
						updateBoard(2,2,ch);
				}
				else
				{
					//Randomly choose x and y position for computer
					int x = (int)((Math.random()*10) %3);
					int y= (int)((Math.random()*10) %3);
					//System.out.println("x "+x+"y"+y);
					//Choose Random position in open space
					while(checkPosition(y,x) != 1)
					{
						x = (int)((Math.random()*10) %3);
					    y= (int)((Math.random()*10) %3);
						
					}
					updateBoard(y,x,ch);
				}
					
			}
			
		}
		return 1;
	}
	
	

}
