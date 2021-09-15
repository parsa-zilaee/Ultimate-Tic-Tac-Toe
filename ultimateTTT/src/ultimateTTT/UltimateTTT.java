package ultimateTTT;
import java.io.*;
import java.util.*;
public class UltimateTTT {
	 //Create am Empty Board of 3 X 3
	   char board[][] = new char[3][3];

	   UltimateTTT(){

	       for(int lc = 0; lc < 3; lc++){

	           //Initialize the Board with '-' to mark empty spaces
	           Arrays.fill(board[lc],'-');
	       }
	   }

	   //Method to check whether all 3 characters are same or not
	   boolean checkRow(char r[]){

	       if((r[0] == r[1]) && (r[0]== r[2]) && (r[0] != '-') ) {

	           return true;
	       }
	       return false;
	   }

	   //Set a character on board at a specific Location
	   boolean setChar(char c, int p1, int p2){

	       //Print Error Message if a position with previous values is entered
	       if(board[p1][p2] == 'X' || board[p1][p2] == 'O'){

	           System.out.println("Place Already Occupied !!!\tEnter Again");
	           return false;
	       }
	       else if (c == 'X' || c == 'O'){

	           board[p1][p2] = c;
	           return true;
	       }
	       else
	           return false;

	   }

	   //Display The Entire Board
	   void display(int no){

	       System.out.println("Displaying Board Number - " + no);
	       System.out.println();
	       for(int olc = 0; olc < 3; olc++){

	           for(int ilc = 0; ilc < 3; ilc++){

	               System.out.print(board[olc][ilc] + "\t");
	           }

	           System.out.println("\n");
	       }
	   }

	   //After every input Check for Winning Positions
	   char checkResult(){

	       char myrow[] = new char[3];

	       //Check Win Row wise
	       for(int olc = 0; olc < 3; olc++){

	           if(checkRow(board[olc])){

	               return board[olc][0];
	           }
	       }

	       //Check Win Column wise
	       for(int olc = 0; olc < 3; olc++){

	           for(int ilc = 0; ilc < 3; ilc++){

	               myrow[ilc] = board[ilc][olc];

	           }

	           if(checkRow(myrow)){

	               return board[0][olc];
	           }
	       }

	       //Check Win Diagonally
	       myrow[0] = board[0][0];
	       myrow[1] = board[1][1];
	       myrow[2] = board[2][2];

	       if(checkRow(myrow)){

	           return board[0][0];
	       }

	       myrow[0] = board[0][2];
	       myrow[1] = board[1][1];
	       myrow[2] = board[2][0];

	       if(checkRow(myrow)){

	           return board[1][1];
	       }
	       return ' ';
	   }
	}


	class Game {

	   public static void main(String[] args) throws IOException {

	       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	       int b_no = 0, x = 0, y = 0,p = 1,turns = 0;
	       char c = ' ';

	       System.out.println("All the Boards are filled with \'-\' \n");
	       //Create 9 Empty Boards
	       UltimateTTT boards[] = new UltimateTTT[9];

	       for(int lc = 0; lc < 9; lc++){

	           boards[lc] = new UltimateTTT();
	           boards[lc].display(lc);
	       }

	       //User choice to select any board to play
	       System.out.println("Select a Board to play");
	       b_no = Integer.parseInt(br.readLine());

	       while(true) {

	           //Switch Players alternatively
	           if(p == 1){

	               System.out.println("Player 1");
	               c = 'X';
	               p = 2;
	           }
	           else {

	               System.out.println("Player 2");
	               c = 'O';
	               p = 1;
	           }

	           //Position Input for X or O
	           System.out.println("Enter x (0,1,2) and y (0,1,2) cordinates of the Boards to place X or O");

	           while(true){

	               x = Integer.parseInt(br.readLine());
	               y = Integer.parseInt(br.readLine());

	               if(x >= 3 || y >= 3){

	                   System.out.println("Invalid Inputs, Co-ordinates cannot be greater than 2");
	                   System.out.println("Enter Again");
	               }
	               else if(x < 0 || y < 0 ){

	                   System.out.println("Invalid Inputs, Co-ordinates cannot be negative");
	                   System.out.println("Enter Again");
	               }
	               else

	                   if(boards[b_no].setChar(c,x,y)){

	                       break;
	                   }
	           }

	           System.out.println("Updated Board");
	           System.out.println();

	           //Display Updated board after the changes
	           boards[b_no].display(b_no);

	           //Check for Win Results after every move
	           char res = boards[b_no].checkResult();

	           if(res == 'X'){

	               System.out.println("Player-1 Wins");
	               break;
	           }
	           else if(res == 'O'){

	               System.out.println("Player-2 Wins");
	               break;
	           }
	       }
	   }

}
