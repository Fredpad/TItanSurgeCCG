package Titancards;
import Titan.*;

import java.util.Random;

import Titan.Titancard;

public class Flamewyvern implements Titancard {
	int health = 190, timer = 2, attack = 130;
	String name = "Flamewyvern"; 
	TitanObserver observer;
	
	static int count = 1;
	String key = String.valueOf(count) + "FW";

	public Flamewyvern(TitanObserver  obs){
		this.observer = obs;
		count += 1; 
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public int getHealth() {
		// TODO Auto-generated method stub
		return health;
	}

	@Override
	public String getkey() {
		// TODO Auto-generated method stub
		return key;
	}

	@Override
	public void reduceTimer() {
		// TODO Auto-generated method stub
		if (timer > 0)
			timer -=1 ;
	}

	@Override
	public void damaged(int n) {
		// TODO Auto-generated method stub
		health -= n;
		if(health <= 0)
			observer.update("dead", key);
	}

	@Override
	public int getTimer() {
		// TODO Auto-generated method stub
		return timer;
	}

	@Override
	public void attack(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ability() {
		int enemycards = observer.get("fieldlength");
		
		if(enemycards > 0){
			if(enemycards == 1){
				double d = Math.random() *100;
				if(d <= 45)
					observer.update("damage", 30, "stun", 0);
				else
					observer.update("damage", 30, null, 0);
			}
			else{
				double d = Math.random()*100;
				
				Random rand = new Random();
				int position = rand.nextInt(enemycards);
				
				if(d <=45)
					observer.update("damage", 30, "stun", position);
					
				else
					observer.update("damage", 30, null, position);

			}
		}
		
	}

	@Override
	public void abilityDamage(int damage) {
		health -= damage;
		if(health <= 0)
			observer.update("dead", key);
		
	}

	@Override
	public void inflictedStatus(String status) {
		// TODO Auto-generated method stub
		
	}

}
