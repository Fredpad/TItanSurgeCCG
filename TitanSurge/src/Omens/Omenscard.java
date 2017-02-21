package Omens;

import Common.*;

public interface Omenscard extends Card{
	 void getOnturn();
	 void damaged();
	 int getCost();
	 void consumeApples();
	 void consumeMagic();
	 boolean canconsume();
	 boolean canIntercept();
	 void buy();
	 
}
