
package TitanSurge;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fredpad
 */
public class Move {
	Player one; 
	
	
	Move(Player obj){one = obj;}
	
	public void choices(String word){
		one.strat.setStrategy(word);
	}
	
	
}
