package Titancards;

import Titan.*;
//Class impelment No Card. 
public class Nocard implements Titancard {
	int health = 190, timer = 2, attack = 130;
	String name = "No Card";
// all methods are useles in this class with simple return value. 

	public String getName() {
		return name;
	}


	public int getHealth() {
		return 0;
	}

	public String getkey() {
		return null;
	}

	public void reduceTimer() {

	}

	public void damaged(int n) {
	}

	public int getTimer() {
		return 0;
	}

	public void ability() {
		
	}

	public void abilityDamage(int damage) {
		
	}

	public void inflictedStatus(String status) {
		
	}

	public void attack(int i) {
		// TODO Auto-generated method stub
		
	}

	public void onplay() {
		
	}

	public int getAttack() {
		return 0;
	}

}
