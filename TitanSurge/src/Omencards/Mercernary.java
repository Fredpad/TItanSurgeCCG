package Omencards;

import Omens.*;
import Common.*;

public class Mercernary implements Omenscard{
	String name = "Mercernary"; 
	int health = 2, cost = 6;
	boolean intercepts = true;
	CardObserver observer;
	int count = 1;
	String key = String.valueOf(count) + "MR";
	
	public Mercernary(CardObserver obs) {this.observer = obs;	count +=1;}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getHealth() {
		return health;
	}

	@Override
	public void damaged() {
		health -=1;
		if(health <= 0){
			observer.update("dead", key);
			health =2;
		}
		double retaliate = Math.random()*100; 
		if(retaliate <= 50)
			observer.update("minion attack");
	}

	public void buy(){observer.update("buy", key);}
	
	@Override
	public void getOnturn() {
		observer.update("minion attack");
		
	}

	@Override
	public int getCost() {
		return cost;
	}

	@Override
	public boolean canIntercept() {
		return intercepts;
	}

	@Override
	public void consumeApples() {
		observer.update("lose apples", 1);
		if(health < 2 && health> 0)
			health +=1;
		observer.update("minion attack");

	}
	
	@Override
	public void consumeMagic() {
		observer.update("lose magic", 1);
		if(health < 2 && health> 0)
			health +=1;
		observer.update("minion attack");

	}
	
	@Override
	public boolean canconsume() {
		return true;
	}

	@Override
	public void onplay() {
		observer.update("play", key);
		observer.update("draw");
		}

	@Override
	public String getkey() {
		return key;
	}
	
}
