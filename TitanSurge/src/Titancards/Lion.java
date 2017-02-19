package Titancards;

import Titan.TitanObserver;
import Titan.Titancard;

//pierce damage
public class Lion implements Titancard{
		int health = 190, timer = 2, attack = 130;
		String name = "Lion"; 
		TitanObserver observer;
		
		static int count = 1;
		String key = String.valueOf(count) + "Li";
		
		public Lion(TitanObserver  obs){
			observer = obs;
			count += 1;
		}
		
		@Override
		public String getName() {
			return name;
		}

		@Override
		public int getHealth() {
			return health;
		}

		@Override
		public void damaged(int n) {
			health -= n;
			if(health <= 0)
				observer.update("dead", key);
			
		}

		@Override
		public void reduceTimer() {
			if(timer > 0)
				timer -=1;
		}

		@Override
		public int getTimer() {
			return timer;
		}

		
		/*public int getAttack() {
			return attack;
		}*/
		

		@Override
		public String getkey() {
			// TODO Auto-generated method stub
			return key;
		}

		@Override
		public void ability() {
			// TODO Auto-generated method stub
			
			
		}

		@Override
		public void abilityDamage(int damage) {
			// TODO Auto-generated method stub
			health -= 30;
			if(health <= 0)
				observer.update("dead", key);			
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