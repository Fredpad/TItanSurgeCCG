package Omencards;

import Omens.*;
import Common.*;

public class WealthyPatron implements Omenscard{
	String name = "Wealthy Patron";
	int health = 1, cost = 5;
	CardObserver observer;
	int count = 1;
	String key = String.valueOf(count) + "WP";
	
	public WealthyPatron(CardObserver obs) {this.observer = obs;	count +=1;}

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
		observer.update("play",key);
		observer.update("draw");
		}

	@Override
	public void damaged() {
		health -= 1;
		if(health <= 0){
			observer.update("dead", key);
			health = 1;
		}
		
	}

	@Override
	public void getOnturn() {
		observer.update("gold", 2);
		
	}

	@Override
	public void consumeApples() {
		observer.update("lose apples", 1);
		observer.update("gold", 1);

	}
	
	@Override
	public void consumeMagic() {
		observer.update("lose magic", 1);
		observer.update("gold", 1);
	}
	
	@Override
	public boolean canconsume() {
		return false;
	}

	@Override
	public String getkey() {
		return key;
	}
}
