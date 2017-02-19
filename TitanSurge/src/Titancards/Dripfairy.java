package Titancards;

import Titan.*;
import Common.*;

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
	}

	@Override
	public int getTimer() {
		// TODO Auto-generated method stub
		return timer;
	}

	
	@Override
	public int getAttack() {
		// TODO Auto-generated method stub
		return attack;
	}
	

	@Override
	public void ability() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void abilityDamage(int damage) {
		health -=damage;
		if(health <=0)
			observer.update("dead", key);
		
	}

	@Override
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
	
	@Override
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
