package Common;

import java.io.IOException;
import java.util.Random;
import Titan.*;
import Omens.*;

public class Main {

	public static void main(String[] args) {
		OmensGame one = new OmensGame();
		OmenStrategy strat = new OmenStrategy(one.observer(), one);
		
		for(int i = 0; i < 5; i+=1){
			strat.handcards();
			strat.buycards();
			one.gainApples(5);
			one.gainMagic(3);
			strat.useresources();
			strat.player.endTurn();
		}
	}

}
