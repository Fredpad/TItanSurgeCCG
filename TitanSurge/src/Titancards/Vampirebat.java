package Titancards;

import Titan.*;

public class Vampirebat implements Titancard {
	int health = 190, timer = 2, attack = 130;
	String name = "Vampirebat"; 
	TitanObserver observer;
	
	static int count = 1;
	String key = String.valueOf(count) + "VP";

	public Vampirebat(TitanObserver obs){
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
			timer -= 1;
	}

	@Override
	public void damaged(int n) {
		// TODO Auto-generated method stub
		health -= n;
		if (health <= 0)
		{
			observer.update("dead", key);
		}
	}

	@Override
	public int getTimer() {
		// TODO Auto-generated method stub
		return timer;
	}
/*
	@Override
	public int getAttack() {
		// TODO Auto-generated method stub
		return attack;
	}
*/
	@Override
	public void ability() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void abilityDamage(int damage) {
		// TODO Auto-generated method stub
		health -= damage;
		if (health <= 0){
			observer.update("dead", key);
		}
	}

	@Override
	public void inflictedStatus(String status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attack(int i) {
		// TODO Auto-generated method stub
		
	}

}
