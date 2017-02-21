package Omencards;

import Omens.*;
import Common.*;

public class Prayer implements Omenscard{
	String name = "Prayer";
	int health = 0, cost = 6;
	CardObserver observer;
	int count = 1;
	String key = String.valueOf(count) + "PR";
	
	public Prayer(CardObserver obs){this.observer = obs; count +=1;}
	
	public void buy(){observer.update("buy", key);}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getHealth() {
		return health;
	}

	@Override
	public int getCost() {
		return cost;
	}
	
	@Override
	public boolean canIntercept() {
		return false;
	}
	
	@Override
	public void onplay() {
		observer.update("magic", 1);
		observer.update("deck", key);
		}

	@Override
	public void damaged() {
		//does nothing
		
	}

	@Override
	public void getOnturn() {
		//does nothing
		
	}

	@Override
	public void consumeApples() {}
	
	@Override
	public void consumeMagic() {}
	
	@Override
	public boolean canconsume() {
		return false;
	}

	@Override
	public String getkey() {
		return key;
	}
}
