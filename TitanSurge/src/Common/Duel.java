package Common;

import Omens.*;
import Titan.TitanPlayer;

public final class Duel {

	public static boolean battle(OmenPlayer one, OmenPlayer two){
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
		}
	}
	
	public static boolean battle(TitanPlayer one, TitanPlayer two){
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
		}
	}
}
