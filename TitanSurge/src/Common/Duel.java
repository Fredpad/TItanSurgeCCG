package Common;

import java.io.IOException;

import Omens.*;
import Titan.TitanPlayer;

public final class Duel {

	//TAKES two players/ or a player and AI and have them face each other until a winner
	//is found. The boolean return signals who won the match
	public static boolean battle(OmenPlayer one, OmenPlayer two) throws IOException{
		one.setEnemy(two);
		two.setEnemy(one);
		while(true){
			one.newTurn();
			one.playTurn();
			one.endTurn();
			
			if(one.gethealth() <= 0){
				return false;
			}
			else if(two.gethealth() <= 0){
				return true;
			}
			
			two.newTurn();
			two.playTurn();
			two.endTurn();
			
			if(one.gethealth() <= 0){
				return false;
			}
			else if(two.gethealth() <= 0){
				return true;
			}
		}
	}
	
	//TAKES two players/ or a player and AI and have them face each other until a winner
	//is found. The boolean return signals who won the match
	public static boolean battle(TitanPlayer one, TitanPlayer two) throws IOException{
		one.setEnemy(two);
		two.setEnemy(one);
		while(true){
			one.newTurn();
			one.playTurn();
			one.endTurn();
			
			if(one.gethealth() <= 0){
				return false;
			}
			else if(two.gethealth() <= 0){
				return true;
			}
			
			two.newTurn();
			two.playTurn();
			two.endTurn();
			
			if(one.gethealth() <= 0){
				return false;
			}
			else if(two.gethealth() <= 0){
				return true;
			}
		}
	}
}
