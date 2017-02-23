package Titancards;

import java.util.Random;
import Common.*;

import Titan.*;

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
		if(health <= 0)
			observer.update("dead", key);
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

	@Override
	public void abilityDamage(int damage) {
		// TODO Auto-generated method stub
		health -= damage;
		if(health <= 0)
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
