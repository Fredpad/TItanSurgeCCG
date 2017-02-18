package Omencards;

import Omens.CardObserver;
import Omens.Omenscard;

public class CollectTaxes implements Omenscard{
	String name = "Collect Taxes";
	int health = 0, cost = 4;
	CardObserver observer;
	int count = 1;
	String key = String.valueOf(count) + "CT";
	
	public CollectTaxes(CardObserver obs){this.observer = obs; count +=1;}
	
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
		observer.update("gold", 1);
		observer.update("deck", name);
		observer.update("draw");
		}

	@Override
	public void damaged() {
		// does nothing
		
	}

	@Override
	public void getOnturn() {
		//does nothing
		
	}
	
	@Override
	public void consumeApples() {	}
	
	@Override
	public void consumeMagic() {	}

	@Override
	public String getkey() {
		return key;
	}

	@Override
	public boolean canconsume() {
		return false;
	}

}
