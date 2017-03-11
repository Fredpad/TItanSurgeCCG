package Common;

import java.io.IOException;

import Omens.*;
import Titan.TitanPlayer;

public final class Duel {

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
