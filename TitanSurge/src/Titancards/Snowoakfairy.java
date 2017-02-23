package Titancards;

import java.util.Random;
import Common.*;

import Titan.*;
//Class implementing Snowoakfairy

public class Snowoakfairy implements Titancard {
	int health = 180, timer = 4, attack = 80, snowball = 20;
	String name = "Snow Oak Fairy";
	CardObserver observer;
	boolean poisen = false, frozen = false, stun = false;
	int poisenCount = 0;
	
	static int count = 1;
	String key = String.valueOf(count) + "SF";

	public Snowoakfairy(CardObserver obs){
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
		if(health <= 0)
			observer.update("dead", key);
	}

	public int getTimer() {
		return timer;
	}

	public int getAttack() {
		return attack;
	}

	public void ability() {
		int enemycards = observer.get("fieldlength");
		double d = Math.random() *100;
		
		if(enemycards > 0){
			if(enemycards == 1){
				
				if(d <= 35)
					observer.update("damage", snowball, "frozen", 0);
				else
					observer.update("damage", snowball, null, 0);
			}
		}
		else if(enemycards ==2){
			for(int i = 0; i < 2; i+=1){
				d = Math.random()*100;
				if(d <= 35)
					observer.update("damage", snowball, "frozen", i);
				else
					observer.update("damage", snowball, null, i);
			}
		}
		
		else if(enemycards ==3){
			for(int i = 0; i < 3; i+=1){
				d = Math.random()*100;
				if(d <= 35)
					observer.update("damage", snowball, "frozen", i);
				else
					observer.update("damage", snowball, null, i);
			}
		}
		
		else{
			final int[] ints = new Random().ints(0, enemycards).distinct().limit(3).toArray();
			for(int i = 0; i < 3; i+=1){
				d = Math.random()*100;
				if(d <= 35)
					observer.update("damage", snowball, "frozen", ints[i]);
				else
					observer.update("damage", snowball, null, ints[i]);
			}
		}
		
	}

	public void abilityDamage(int damage) {
		health -= damage;
		if(health <= 0)
			observer.update("dead", key);
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
