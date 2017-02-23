package Titancards;

import Common.CardObserver;
import Titan.TitanObserver;
import Titan.Titancard;
//This class is implementatoin of Line Card 
//pierce damage
public class Lion implements Titancard{
		int health = 200, timer = 2, attack = 130;
		String name = "Lion"; 
		CardObserver observer;
		boolean poisen = false, frozen = false, stun = false;
		int poisenCount = 0;
		
		static int count = 1;
		String key = String.valueOf(count) + "Li";
		
		public Lion(CardObserver  observer2){
			this.observer = observer2;
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

		public void damaged(int n) {
			health -= n;
			if(health <= 0)
				observer.update("dead", key);
			
		}

		public void reduceTimer() {
			if(timer > 0)
				timer -=1;
		}

		public int getTimer() {
			return timer;
		}

		
		public int getAttack() {
			return attack;
		}
		

		public String getkey() {
			return key;
		}
		// This card has no special ability. 
		public void ability() {
			
			
		}

		// Damage ability for the card. 
		public void abilityDamage(int damage) {
			// TODO Auto-generated method stub
			health -= damage;
			if(health <= 0)
				observer.update("dead", key);			
		}

		//Attack ability for the class. 
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