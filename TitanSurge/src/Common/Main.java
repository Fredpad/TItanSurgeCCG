package Common;
import Omens.*;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import Titan.*;
//import Titan.Player;1

//import Omens.Player;
import Omens.*;

public class Main {

	public static void main(String[] args) { 
		Scanner read = new Scanner(System.in);
		String input;
		System.out.println("Welcome! We have two games to play: TitanSurge and War of Omens. \nWhich do you want to play? Input Titan or Omens");
		input = read.next(); 
		
		
		if(input.equalsIgnoreCase("Titan")){
			TitanPlayer one = new TitanPlayer(null);
			TitanAi two = new TitanAi(); 
			one.setEnemy(two); two.setEnemy(one);
			
			while(true){
				one.newTurn();
				one.playTurn();
				one.endTurn();
				if(two.gethealth() <= 0){
					System.out.println("\n THE WINNER IS " + one.getName());
					break;
				}
				two.newTurn();
				two.playTurn();
				two.endTurn();
				
				if(one.gethealth() <=0){
					System.out.println("\n THE WINNER IS " + two.getName());
					break;
					
				}
			}
			
			
		}
		else if(input.equalsIgnoreCase("Omens")){
			OmenPlayer one = new OmenPlayer(null);
			OmenAi two = new OmenAi();
			one.setEnemy(two); two.setEnemy(one);
			
			while(true){
				one.newTurn();
				one.playTurn();
				one.endTurn();
				if(two.gethealth() <= 0){
					System.out.println("\n THE WINNER IS " + one.getName());
					break;
				}
				two.newTurn();
				two.playTurn();
				two.endTurn();
				
				if(one.gethealth() <=0){
					System.out.println("\n THE WINNER IS " + two.getName());
					break;
					
				}
			}
			
		}
		else{
			while(input.equalsIgnoreCase("Titan") ==false && input.equalsIgnoreCase("Omens") == false){
			System.out.println("That input did not match Titan or Omens. Try again: ");
			input  = read.next();}
			
		}
	}

}
