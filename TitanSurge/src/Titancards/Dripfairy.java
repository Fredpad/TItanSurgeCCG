package Titancards;

import Titan.*;
import Common.*;

//Class to implement the Dripfairy card 
public class Dripfairy implements Titancard {
	int health = 180, timer = 2, attack = 75;
	String name = "Dripfairy";
	CardObserver observer;
	boolean poisen = false, frozen = false, stun = false;
	int poisenCount = 0;
	
	static int count = 1;
	String key = String.valueOf(count) + "DF";

	public Dripfairy(CardObserver obs){
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
		if (timer > 0)
			timer -= 1;

	}

	
	public void damaged(int n) {
		health -= n;
	}

	
	public int getTimer() {
		return timer;
	}

	
	
	public int getAttack() {
		return attack;
	}
	

	
	public void ability() {
		//This card has no ability 
		
	}

	
	public void abilityDamage(int damage) {
		health -=damage;
		if(health <=0)
			observer.update("dead", key);
		
	}

	//Attack method used for
	//updating health
	//increase points 
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
	
	//Method used if other cards attack this card. 
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
