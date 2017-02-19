package Omencards;

import Omens.*;
import Common.*;

public class Supplicant implements Omenscard{
	String name = "Supplicant";
	int health = 2, cost = 7;
	CardObserver observer;
	int count = 1;
	String key = String.valueOf(count) + "SP";
	
	public Supplicant(CardObserver obs) {this.observer = obs; count+=1;}

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
		observer.update("play", key);
		observer.update("draw");
		}

	@Override
	public void damaged() {
		health -=1;
		
		if(health <= 0){
			observer.update("dead", key);
			health = 2;
		}
		
	}

	@Override
	public void getOnturn() {
		observer.update("magic", 1);
		
	}

	@Override
	public void consumeApples() {
		if(health < 2 && health > 0)
			health +=1;
		observer.update("lose apples", 1);
		observer.update("magic", 1);

	}
	
	@Override
	public void consumeMagic() {
		if(health < 2 && health >0){
			health +=1;
			observer.update("lose magic", 1);}
			
		
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
