package Titan;
import java.util.Random;

import Common.*;
import TitanSurge.Card;
import Titancards.*;

public class TitanGame extends Game{
	int cementarysize = 10, cementarylength = 0; 
	Titancard[] cementary = new Titancard[cementarysize]; 
	Titancard[] deck, hand, field;
	CardObserver observer = new TitanObserver(this);
	Cardlib lib = FactoryProducer.getLib("Titan", observer); 
	TitanGame enemy;
	

	public TitanGame(){
		
		health = 1000;
		handsize = 5 ;
		decksize = 10;
		fieldsize = 5;
		
		deck = new Titancard[decksize];
		field = new Titancard[fieldsize];
		hand = new Titancard[handsize];
		
		setdeck();
		shuffle();
		sethand();
		setfield();
		setcementary();
	}
	//Method used to pring deck to the screen
	//It will show the card name on the secreen. 
	public void printDeck(){
		for(Titancard card: deck){
			System.out.println(card.getName());
		}
	}
	//Set up hand method by drawing cards from the deck
	public void setup(){
		draw();
		draw();
		draw();
	}
	//Method used to print the card in the player hand to the screen 
	public void printhand(){
		for(Titancard card: hand){
			System.out.println(card.getName());
		}
	}
	// method used to print the card name, health, attach power. 
	public void printfield(){
		for(Titancard card: field){
			System.out.println(card.getName() + " #Health: " + card.getHealth() + " #Attack: " + card.getAttack());
		}
	}
	// Just a test method we used, has no effect on the game. 
	public void checkhand(){
		hand[0] = hand[1];
		hand[1] = lib.getTitancard("No card");
	}
	
	//Draw a card from the deck to the hand
	//This method will reduce deck length by 1 and increase hand length.
	public void draw(){ 
		hand[handlength] = deck[0] ;
		decklength -= 1;
		handlength += 1;
		deck[0] = lib.getTitancard("No card");
		adjustdeck();
	}
	//simple method to create turns between the players. 
	public void newTurn(){
		enemy.updatetimers();
		updatetimers();
		draw();
	}
	//end the attack turn method 
	public void endTurn(){
		
	}
	//Method used to set the deck to new card 
	// card will be called from lib class which has all cards 
	public void setdeck(){
		deck[0] = lib.getTitancard("Lion");
		deck[1] = lib.getTitancard("Spider");
		deck[2] = lib.getTitancard("Flame Wyvern");
		deck[3] = lib.getTitancard("Orc Soldier");
		deck[4] = lib.getTitancard("Dripfairy");
		deck[5] = lib.getTitancard("Tundra Troll");
		deck[6] = lib.getTitancard("Viking Chief");
		deck[7] = lib.getTitancard("Swamp Wolf");
		deck[8] = lib.getTitancard("Vampire Bat");
		deck[9] = lib.getTitancard("Snow Oak Fiary");
		decklength = 10;
		}
	//shuffle will shuffle cards so will will be in a random order. 
	private void shuffle(){
		Random rnd = new Random();
		for(int i = decklength - 1; i > 0; i -=1){
			
			int a = rnd.nextInt(i + 1);
			Titancard b = deck[a];
			deck[a] = deck[i];
			deck[i] = b;
		}
	}
	
	public void setfield() {
		field[0] = lib.getTitancard("No card");
		field[1] = lib.getTitancard("No card");
		field[2] = lib.getTitancard("No Card");
		field[3] = lib.getTitancard("No Card");
		field[4] = lib.getTitancard("No card");
	}
	//set hand to no cards for a single turn.
	public void sethand(){
		hand[0] = lib.getTitancard("No card");
		hand[1] = lib.getTitancard("No card");
		hand[2] = lib.getTitancard("No card");
		hand[3] = lib.getTitancard("No card");
		hand[4] = lib.getTitancard("No card");
	}
	//setting Cementary to nothing. Cementry used to save dead cards. 
	public void setcementary(){
		for(int i = 0; i < cementarylength; i+=1){
			cementary[i] = lib.getTitancard("No card");
	}
		}
	
	//setting the enemy by creating a hand with cards 
	//cards will be drawing from the deck.
	public void setEnemy(TitanGame person){this.enemy = person;}
	
	public void adjustdeck(){
		
		for(int i = 0; i < decklength; i+=1){
			deck[i] = deck[i+1];
		}
		deck[decklength] = lib.getTitancard("No card");
		
		}
	//Method used to adjust player hand in case he/she loses a card.
	//I will full out any open spot. 
	public void adjusthand(){
		
		for (int i = 0; i < handlength; i+=1){
			if (hand[i].getName().equalsIgnoreCase("No card") ){
				hand[i] = hand[i+1];
				hand[i + 1] = lib.getTitancard("No card");
			}
		}
	}
	// adjust the hand length for the player 
	// it will shift the cards to full out an empty spot. 
	public void adjustfield(){
		for (int i = 0; i < fieldlength; i+=1){
			if (field[i].getName().equalsIgnoreCase("No card")){
				field[i] = field[i+1];
				field[i+1] = lib.getTitancard("No card");
			}
			
		}
	}
	//method used to put dead cards in the cemetry. 
	public void deadcard(String key){
		for (int i = 0; i < fieldlength; i+=1){
			if (field[i].getkey().equals(key)){
				cementary[cementarylength]= field[i];
				field[i] = lib.getTitancard("No card");
				fieldlength-=1;
				cementarylength+=1;
			}
		}
		adjustfield();
	}	
	//attack method against a card in the field. 
	public void attack(){
		for(int i = 0; i < fieldlength; i +=1){
			field[i].attack(i);
		}
	}
	//Method used to attack enemy cards. 
	public void attackEnemy(int position, int attackDamage){
		enemy.attacked(position, attackDamage);
	}
	// method used for the attack 
	// if the health of the card goes to 0 it will place no card in the open spot. 
	public void attacked(int position, int attackDamage){
		if(field[position].getName().equals("No card"))
			damaged(attackDamage);
		else 
			field[position].damaged(attackDamage);
	}
	//method used to pull card from the hand. 
	public void playcard(String key){
		for (int i=0; i < handlength; i++){
			if (hand[i].getkey().equals(key)){
				field[fieldlength] = hand[i];
				hand[i] = lib.getTitancard("No card");
				fieldlength+=1;
			}
			
		}
		handlength -=1;
		adjusthand();}
	//Method used to update the timer of the game and reduce it. 
	public void updatetimers(){
		for (int i = 0; i < handlength; i+=1){
			hand[i].reduceTimer();
		}
	}
	//getter method for field position. 
	public Titancard getFieldcard(int position){
		return field[position];
	}
	//getter method for the position of a card in the hand
	public Titancard getHandcard(int position){
		return hand[position];
	}
	
	// Damage method, it will return health - damage. 
	public void damaged(int n) {
		health -= n;
		
	}}
