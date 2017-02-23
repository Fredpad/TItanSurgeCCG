package Omencards;

import Omens.*;
import Common.*;

public class Serf implements Omenscard{
	String name = "Serf";
	int health = 1, cost = 3;
	CardObserver observer;
	int count = 1;
	String key = String.valueOf(count) + "SF";
	
	public Serf(CardObserver obs) {this.observer = obs;	count +=1;}

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
		return true;
	}
	
	@Override
	public void onplay() {
		observer.update("play", key);
		observer.update("draw");
		}
	
	@Override
	public void damaged() {
		health -= 1;
		if(health <=0){
			observer.update("dead", key);
			health = 1;
		}
		
	}

	@Override
	public void getOnturn() {
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
