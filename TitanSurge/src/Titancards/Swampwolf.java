package Titancards;

import Titan.*;
import Common.*;
//Class implementing Swampwolf. 


public class Swampwolf implements Titancard {
	int health = 200, timer = 2, attack = 140;
	String name = "Swamp Wolf"; 
	CardObserver observer;
	boolean poisen = false, frozen = false, stun = false;
	int poisenCount = 0;
	
	static int count = 1;
	String key = String.valueOf(count) + "SW";

	public Swampwolf(CardObserver obs){
		this.observer = obs;
		count += 1; 
	}
	
	public void onplay(){
		observer.update("play", key);
	}
	
	public String getName() {
		return name;
	}

	public int getHealth() {
		return health;
	}

	public String getkey() {
		return key;
	}

	public void reduceTimer() {
		if (timer > 0 )
			timer -= 1;
	}

	public void damaged(int n) {
		health -= n;
		if (health <= 0){
			observer.update("dead", key);
		}
		
	}

	public int getTimer() {
		return timer;
	}

	public int getAttack() {
		return attack;
	}
	
	//This card has not special ability. 
	public void ability() {
		
	}

	public void abilityDamage(int damage) {
		health -= damage;
		if (health <= 0){
			observer.update("dead", key);
		}
	}

	public void attack(int position) {
		if(frozen == false && stun == false){
			ability();
			observer.update("attack", position,attack);
		}
		else if(stun == true){
			stun = false;
			observer.update("attack", position,attack);
		}
		if(frozen == true){
			frozen = false;}
		if(poisen == true){
			
			health -= 20;
			poisenCount -=1;
			
			if(poisenCount <= 0)
				poisen = false;
			}
		}
	
	public void inflictedStatus(String status) {
		if(status.equalsIgnoreCase("stun")){
			stun = true;}
		
		else if(status.equalsIgnoreCase("frozen"))
		{	frozen = true;}
		
		else if(status.equalsIgnoreCase("poisen")){
			
			if(poisen == true)
				poisenCount +=2;
			
			else{
				poisen = true;
				poisenCount = 2;}
			}
		
	}

}
