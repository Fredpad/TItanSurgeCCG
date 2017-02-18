package Omencards;

import Omens.CardObserver;
import Omens.Omenscard;

public class SpiceRoute implements Omenscard {
	String name = "Spice Route";
	int health = 0, cost = 4;
	CardObserver observer;
	int count = 1;
	String key = String.valueOf(count) + "SR";

	public SpiceRoute(CardObserver obs) {this.observer = obs;	count +=1;}

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
		observer.update("apples", 1);
		observer.update("deck", key);
		}

	@Override
	public void damaged() {
		// does nothing
		
	}

	@Override
	public void getOnturn() {
		//does not have one
		
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
