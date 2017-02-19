package Titancards;

import Titan.*;

public class Nocard implements Titancard {
	int health = 190, timer = 2, attack = 130;
	String name = "No Card";

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public int getHealth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getkey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reduceTimer() {
		// TODO Auto-generated method stub

	}

	@Override
	public void damaged(int n) {
	}

	@Override
	public int getTimer() {
		// TODO Auto-generated method stub
		return 0;
	}
/*
	@Override
	public int getAttack() {
		// TODO Auto-generated method stub
		return 0;
	}
*/
	@Override
	public void ability() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void abilityDamage(int damage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inflictedStatus(String status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attack(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onplay() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getAttack() {
		// TODO Auto-generated method stub
		return 0;
	}

}
