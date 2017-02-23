package Omens;

import Common.*;

public interface Omenscard extends Card{
	//Omen cards can have an on turn ability that activates when
	//a new turn starts
	 void getOnturn();
	 
	 //method needed to have the card recieve damage
	 void damaged();
	 
	 //returns the cost of buying the card
	 int getCost();
	 
	 //what does the card do when given an apple
	 void consumeApples();
	 
	 //what does the card do when given magic
	 void consumeMagic();
	 
	 //methods used to see if a card can actually use resources
	 boolean canconsume();
	 
	 //used to check if a card can intercept an attack
	 boolean canIntercept();
	 
	 //method that calls the observer to carry out the purchase of the card
	 void buy();
	 
}
