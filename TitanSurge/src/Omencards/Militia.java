package Omencards;

import Omens.*;
import Common.*;

public class Militia implements Omenscard{
	String name = "Militia";
	int health = 1, cost = 5;
	CardObserver observer;
	int count = 1;
	String key = String.valueOf(count) + "MI";
	
	public Militia(CardObserver obs) {this.observer = obs;	count +=1;}

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
		health -=1;
		
		if(health <= 0){
			observer.update("dead", key);
			health = 1;}
		
		double retaliate = Math.random()*100; 
		if(retaliate <= 35)
			observer.update("minion attack");
		
	}

	public void buy(){observer.update("buy", key);}
	
	@Override
	public void getOnturn() {
		observer.update("minion attack");
		
	}

	@Override
	public void consumeApples() {
		observer.update("lose apples", 1);
		observer.update("minion attack");

	}
	
	@Override
	public void consumeMagic() {
		observer.update("lose magic", 1);
		observer.update("minion attack");
	}
	
	@Override
	public boolean canconsume() {
		return true;
	}


	@Override
	public String getkey() {
		return key;
	}

}
