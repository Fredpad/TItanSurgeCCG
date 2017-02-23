package Omencards;

import Omens.*;
import Common.*;

public class CourtlyIntrigue implements Omenscard{
	String name = "Courtly Intrigue";
	int health = 0, cost = 4;
	CardObserver observer;
	int count = 1;
	String key = String.valueOf(count) + "CI";
	
	public CourtlyIntrigue(CardObserver obs){this.observer = obs; count +=1;}
	
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
		observer.update("deck", key);
		observer.update("draw");
		}

	@Override
	public void damaged() {
		//does nothing 
		
	}

	public void buy(){observer.update("buy", key);}
	
	@Override
	public void getOnturn() {
		//does nothing 
	}
	@Override
	public void consumeApples() {}
	
	@Override
	public void consumeMagic() {}

	@Override
	public String getkey() {
		return key;
	}
	
	@Override
	public boolean canconsume() {
		return false;
	}

}
