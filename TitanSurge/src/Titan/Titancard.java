package Titan;

import Common.Card;

public interface Titancard extends Card{
	void reduceTimer();
	void damaged(int n);
	int getTimer();
	int getAttack();
}
