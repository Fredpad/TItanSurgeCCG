package Titan;

import Common.Card;
//Basic interface class 
public interface Titancard extends Card{
	//Method used to reduce timer 
	void reduceTimer();
	// Method to reduce health by the amount of damage 
	//it will return new health 
	void damaged(int n);
	//Basic getter function for timer 
	int getTimer();
	//Card ability method to set the card ability
	void ability();
	//Setting the damage amount according to ability of the card
	void abilityDamage(int damage);
	//Method returning the status 
	void inflictedStatus(String status);
	//Basic attack getter method. 
	int getAttack();
	//Attack method to set the amount that will be deducted from health. 
	void attack(int i);

}
