//Assignment 2 - Game class is the main class for the game. 
// 2-1-2017

import java.lang.reflect.Field;

public class Game {
	private int health = 1200;
	private int decksize = 10, handsize = 5, fieldsize = 5, cementarysize = decksize;
	private int decklength = 0, handlength = 0, fieldlength = 0, cementarylength = 0;
	private Card[] deck = new Card[decksize]; 
	private Card[] field = new Card[fieldsize];
	private Card[] hand = new Card[handsize]; 
	private Card[] cementary = new Card[cementarysize];
	//need to be initializ 
	private Cardlib lib = new Cardlib(); 
	
	public Game(){
		setDeck();
		shuffle();
		setHand();
		setField();
		setCementary();
	}


	public final void setDeck() {
		deck[0] = Cardlib.lion(); 
		deck[1] = Cardlib.spider();
		deck[2] = Cardlib.swampwolf();
		deck[3] = Cardlib.dripfairy();
		deck[4] = Cardlib.snowoakfairy();
		deck[5] = Cardlib.vikingchief();
		deck[6] = Cardlib.vampirebat();
		deck[7] = Cardlib.tundratroll();
		deck[8] = Cardlib.flamewyvern();
		deck[9] = Cardlib.orcsoldier();
		
		//Check with team lead regarding the noCard card.
		//deck[10] = Cardlib.nocard();
		
		decklength = 10; 
	}
	//Set Field function 
	public void setField() {
		field[0] = lib.nocard();
		field[1] = lib.nocard();
		field[2] = lib.nocard();
		field[3] = lib.nocard();
		field[4] = lib.nocard();
	}
	//SetHand Function
	public void setHand() {
		hand[0] = lib.nocard();
		hand[1] = lib.nocard();
		hand[2] = lib.nocard();
		hand[3] = lib.nocard();
		hand[4] = lib.nocard();
	}
	//Set Cementary function 
	public final void setCementary(Card[] cementary) {
		hand[0] = lib.nocard();
		hand[1] = lib.nocard();
		hand[2] = lib.nocard();
		hand[3] = lib.nocard();
		hand[4] = lib.nocard();
		hand[5] = lib.nocard();
		hand[6] = lib.nocard();
		hand[7] = lib.nocard();
		hand[8] = lib.nocard();
		hand[9] = lib.nocard();
	}
	//Shuffle will be added by team lead. 
	public void shuffle() {
		// TODO Auto-generated method stub
		
	}

	//Damage Method used to reduce health
	public void directDamage(int damage){
		health = health - damage;
	}
	//getfieldcard method	
	pbulic Card getFieldcard(int i){
		 return field[i];
		
	}
	//GetHand method
	public Card getHandcard(int i){
		return hand[i];
		
	}
	// draw method
	public void draw(){
		drawTopdeck();
		drawTohand();
	}
	// Draw top deck function
	public Card drawTopdeck(){
		Card a = deck[0];
		for (int i = 0; i < decklength- 1; i++){
			deck[i] = deck[i+1];
		}
		deck[decklength - 1] = lib.nocard();
		decklength--;
		return a;
	}
	//Pull a card to hand 
	public void drawTohand(Card obj){
		hand[handlength]= obj;
		handlength++;
    }
	// Placing card
	public void placeCard(Card obj){
	//calls these methods in the following order
	addFieldcard(obj);
	removeHandcard(obj);
	}
	// Add field card function 
	public void addFieldcard(Card obj){
		field.Card[fieldsize] = obj;
		fieldsize++;
	}
	// Function to remove card from Hand.
	public void removeHandcard(Card obj){
		for (int i = 0; i < handlength-1; i++){
			deck[i] = deck[i+1];
		}
		hand[heanlength] = lib.nocard();
		handlength--;
	}
	// adjusting the filed function. 
	public void adjustField(){
		for (int i = 0; i < fieldlength-1; i++){
			if(deck[i].getName().equals ("No Card") && !deck[i+1].getName().equals("No card")){
				deck[i] = deck[i+1];
				i = 0;
			}
		}
	}
	// Dead card function to add card to cementary. 
	public void deadCard(Card obj){
		if (obj.getHealth() <=0){
			cementary[cemetarylength]= obj;
			cemetarylength++;
		}
		
		for(int i = 0; i < fieldlength; i++){
			if(field[i].getName().equals(obj.getName())){
				field[i] = lib.nocard; 
			}
		}
		// function call for adjust field. 
		adjustField();
	}
	
}

	// Getter for health.
	public final int getHealth() {
		return health;
	}

	// Getter for deck length.
	public final int getDecklength() {
		return decklength;
	}
	
	// Getter for hand length.
	public final int getHandlength() {
		return handlength;
	}

	// Getter for field length. 
	public final int getFieldlength() {
		return fieldlength;
	}

	// getter for cementary length.
	public final int getCementarylength() {
		return cementarylength;
	}

}
