package Titan;

import Common.Card;

public interface Titancard extends Card{
	void reduceTimer();
	void damaged(int n);
	int getTimer();
	void ability();
	void abilityDamage(int damage);
	void inflictedStatus(String status);
	//int getAttack();
	void attack(int i);

}
