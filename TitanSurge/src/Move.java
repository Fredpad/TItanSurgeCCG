
package Titan;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fredpad
 */
public class Move {
	Player one; 
	
	
	Move(Player obj){one = obj;}
	
	public List options(){
		List<String> strats = new ArrayList<String>();
		if(one.strat.cardsReady() > 0){
			strats.add("Brute Force");
			strats.add("Wall");
			return strats;
		}
		else{
			strats.add("No Options");
			return strats;
		}
	}
	
	public void choices(String word){
		if(word.equalsIgnoreCase("Brute force")){
			one.strat.Bruteforce();
		}
		else if(word.equalsIgnoreCase("Wall")){
			one.strat.Wall(); 
		}
	}
	
    
	
	
}
