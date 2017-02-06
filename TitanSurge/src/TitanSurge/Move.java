
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
	
	//The only optoin the player has in this game, due to the simplicity of it
	//by design, is the strategy
	public void choices(String word){
		one.strat.setStrategy(word);
	}
	
	
}
