package battleship;
import java.util.Scanner;
public class Main {
	public static void main (String [] args) {
		Board board = new Board();
		Scanner reader = new Scanner (System.in);
		board.setBoard();
		System.out.println("BATTLESHIP");
		System.out.println("Hello Player 1. You will place 5 ships: Carrier(5), Battleship(4), Cruiser(3), Submarine(3), Destroyer(2). (i.e A1 to A5)");
		
		while(!board.getValidShip()) {
		System.out.print("Where do you want to place the Carrier? ");
		String Carrier = new String(reader.nextLine());
		String[] split5 =Carrier.split(" ");
		if(split5.length <3) {
			board.setValidShip(false);
			System.out.println("Inavlid input");
		}
		else 
			board.setShip(split5[0], split5[2],4);
		
		}
		board.setValidShip(false);
		
		while(!board.getValidShip()) {
		System.out.print("Where do you want to place the Battleship? ");
		String Battleship = new String(reader.nextLine());
		String split4[] =Battleship.split(" ");
		if(split4.length <3) {
			board.setValidShip(false);
			System.out.println("Inavlid input");
		}
		else
			board.setShip(split4[0], split4[2],3);
		}
		
		board.setValidShip(false);
		
		while(!board.getValidShip()) {
		System.out.print("Where do you want to place the Cruiser? ");
		String Cruiser = new String(reader.nextLine());
		String split3[] =Cruiser.split(" ");
		if(split3.length <3) {
			board.setValidShip(false);
			System.out.println("Inavlid input");
		}
		else
			board.setShip(split3[0], split3[2],2);
		}
		board.setValidShip(false);
		
		while(!board.getValidShip()) {
		System.out.print("Where do you want to place the Submarine? ");
		String Submarine = new String(reader.nextLine());
		String split2[] =Submarine.split(" ");
		if(split2.length <3) {
			board.setValidShip(false);
			System.out.println("Inavlid input");
		}
		else
			board.setShip(split2[0], split2[2],2);
		}
		board.setValidShip(false);

		
		while(!board.getValidShip()) {
		System.out.print("Where do you want to place the Destroyer? ");
		String Destroyer = new String(reader.nextLine());
		String split1[] =Destroyer.split(" ");
		if(split1.length <3) {
			board.setValidShip(false);
			System.out.println("Inavlid input");
		}
		else
			board.setShip(split1[0], split1[2],1);
		}
		board.setValidShip(false);

		//Player 2
		System.out.println("Hello Player 2. You will place 5 ships: Carrier(5), Battleship(4), Cruiser(3), Submarine(3), Destroyer(2). (i.e A1 to A5)");
		Board board2 = new Board();
		while(!board2.getValidShip()) {
		System.out.print("Where do you want to place the Carrier? ");
		String Carrier = new String(reader.nextLine());
		String[] split5 =Carrier.split(" ");
		if(split5.length <3) {
			board2.setValidShip(false);
			System.out.println("Inavlid input");
		}
		else
			board2.setShip(split5[0], split5[2],4);
		}
		board2.setValidShip(false);

		while(!board2.getValidShip()) {
		System.out.print("Where do you want to place the Battleship? ");
		String Battleship = new String(reader.nextLine());
		String split4[] =Battleship.split(" ");
		if(split4.length <3) {
			board2.setValidShip(false);
			System.out.println("Inavlid input");
		}
		else
			board2.setShip(split4[0], split4[2],3);
		}
		board2.setValidShip(false);

		while(!board2.getValidShip()) {
		System.out.print("Where do you want to place the Cruiser? ");
		String Cruiser = new String(reader.nextLine());
		String split3[] =Cruiser.split(" ");
		if(split3.length <3) {
			board2.setValidShip(false);
			System.out.println("Inavlid input");
		}
		else
			board2.setShip(split3[0], split3[2],2);
		}
		board2.setValidShip(false);

		while(!board2.getValidShip()) {
		System.out.print("Where do you want to place the Submarine? ");
		String Submarine = new String(reader.nextLine());
		String split2[] =Submarine.split(" ");
		if(split2.length <3) {
			board2.setValidShip(false);
			System.out.println("Inavlid input");
		}
		else
			board2.setShip(split2[0], split2[2],2);
		}
		board2.setValidShip(false);

		while(!board2.getValidShip()) {
		System.out.print("Where do you want to place the Destroyer? ");
		String Destroyer = new String(reader.nextLine());
		String split1[] =Destroyer.split(" ");
		board2.setShip(split1[0], split1[2],1);
		}
		board2.setValidShip(false);
		
		//Gameplay
		
		while (!board.isGameOver() && !board2.isGameOver()) {
		  while(!board2.isAttack()) {
			  System.out.print("Player 1, Choose a coordinate to attack: ");
			  String coordinate = new String(reader.nextLine());
		      board2.attack(coordinate);
		  }
		  if (board2.isGameOver()) {
			  System.out.println("\nPlayer 1's Grid");
		      board.printBoard();	
		      System.out.println("\nPlayer 2's Grid");
		      board2.printBoard(); 
			  System.out.println("Congratulations Player 1, you won!");
		      return;
		  }
		  
		  board2.setAttack(false);
		  while(!board.isAttack()) {
			  System.out.print("Player 2, Choose a coordinate to attack: ");
			  String coordinate = new String(reader.nextLine());
			  board.attack(coordinate);
		  }
		  board.setAttack(false);
		  System.out.println("\nPlayer 1's Grid");
	      board.printBoard();	
	      System.out.println("\nPlayer 2's Grid");
	      board2.printBoard(); 
		}
		
		if (board.isGameOver())
			System.out.println("Congratulations Player 2, you won!");
		
		
		
		
		
	}
}
