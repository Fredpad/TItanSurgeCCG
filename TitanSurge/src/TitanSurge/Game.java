package TitanSurge;
//Assignment 2 - Game class is the main class for the game. 
// 2-1-2017


import java.util.Random;

public class Game {
	private int health = 1200;
	private int decksize = 10, handsize = 5, fieldsize = 5, cementarysize = 10;
	private int decklength = 0, handlength = 0, fieldlength = 0, cementarylength = 0;
	private Card[] deck = new Card[decksize]; 
	private Card[] field = new Card[fieldsize];
	private Card[] hand = new Card[handsize]; 
	private Card[] cementary = new Card[cementarysize];
	//need to be initializ 
	public CardLibrary cardlib = new CardLibrary(); 
	
	public Card getCementaryCard(int i){return cementary[i];}
	
	public Game(){
		setDeck();
		shuffle();
		setHand();
		setField();
		setCementary();
	}


	public void setLibrary(Player play){
		
	}
	
	//TEST method
	public Card getDeck(int i){return deck[i];}
	
	public void setDeck() {
		deck[0] = cardlib.lion(); 
		deck[1] = cardlib.spider();
		deck[2] = cardlib.swampwolf();
		deck[3] = cardlib.dripfairy();
		deck[4] = cardlib.snowoakfairy();
		deck[5] = cardlib.vikingchief();
		deck[6] = cardlib.vampirebat();
		deck[7] = cardlib.tundratroll();
		deck[8] = cardlib.flamewyvern();
		deck[9] = cardlib.orcsoldier();

		
		decklength = 10; 
		//shuffle();
	}
	
	//Set Field function 
	public void setField() {
		field[0] = cardlib.nocard();
		field[1] = cardlib.nocard();
		field[2] = cardlib.nocard();
		field[3] = cardlib.nocard();
		field[4] = cardlib.nocard();
	}
	//SetHand Function
	public void setHand() {
		hand[0] = cardlib.nocard();
		hand[1] = cardlib.nocard();
		hand[2] = cardlib.nocard();
		hand[3] = cardlib.nocard();
		hand[4] = cardlib.nocard();
	}
	//Set Cementary function 
	public final void setCementary() {
		cementary[0] = cardlib.nocard();
		cementary[1] = cardlib.nocard();
		cementary[2] = cardlib.nocard();
		cementary[3] = cardlib.nocard();
		cementary[4] = cardlib.nocard();
		cementary[5] = cardlib.nocard();
		cementary[6] = cardlib.nocard();
		cementary[7] = cardlib.nocard();
		cementary[8] = cardlib.nocard();
		cementary[9] = cardlib.nocard();
	}

	private void shuffle(){
		Random rnd = new Random();
		for(int i = decklength - 1; i > 0; i -=1){
			
			int a = rnd.nextInt(i + 1);
			Card b = deck[a];
			deck[a] = deck[i];
			deck[i] = b;
		}
	}

	//Damage Method used to reduce health
	public void directDamage(int damage){
		health = health - damage;
	}
	//getfieldcard method	
	public Card getFieldcard(int i){
		 return field[i];
		
	}
	//GetHand method
	public Card getHandcard(int i){
		return hand[i];
		
	}
	// draw method
	public void draw(){
		
		drawTohand(drawTopdeck());
	}
	// Draw top deck function
	public Card drawTopdeck(){
		if(decklength > 0){
		Card a = deck[0];
		for (int i = 0; i < decklength- 1; i++){
			deck[i] = deck[i+1];
		}
		deck[decklength - 1] = cardlib.nocard();
		decklength--;
		return a;} 
		else return cardlib.nocard();
	}
	//Pull a card to hand 
	public void drawTohand(Card obj){
		if(obj.getName().equals("No card")==false){
		hand[handlength]= obj;
		handlength++;}
    }
	// Placing card
	public void placeCard(Card obj){
	//calls these methods in the following order
	addFieldcard(obj);
	removeHandcard(obj);
	}
	// Add field card function 
	public void addFieldcard(Card obj){
		field[fieldlength] = obj;
		fieldlength+=1;
	}
	// Function to remove card from Hand.
	public void removeHandcard(Card obj){
		
		for(int i = 0; i < handlength; i+=1){
			if(hand[i].getName().equals(obj.getName())){
				
				handlength-=1;
				for( ;i < handlength; i+=1){
					hand[i]=hand[i+1];
				}
				hand[i] = cardlib.nocard();
			}
		}
	}
	// adjusting the filed function. 
	public boolean checkName(Card obj){
		if(obj.getName().equals("Dripfairy"))
			return true;
		else if(obj.getName().equals("Flame Wyvern"))
			return true;
		else if(obj.getName().equals("Lion"))
			return true;
		else if(obj.getName().equals("Spider"))
			return true;
		else if(obj.getName().equals("Orc Soldier"))
			return true;
		else if(obj.getName().equals("Swamp Wolf"))
			return true;
		else if(obj.getName().equals("Snow Oak Fiary"))
			return true;
		else if(obj.getName().equals("Tundra Troll"))
			return true;
		else if(obj.getName().equals("Vampire Bat"))
			return true;
		else if(obj.getName().equals("Vikingchief"))
			return true;
		else return false;
	}
	
	public void adjustField(){
		
		for (int i = 0; i < fieldsize; i+=1){
			if(checkName(field[i])==true){
				if(i > 0 && (checkName(field[i-1]) == false)  ){
					field[i-1] = field[i];
					field[i] = cardlib.nocard();
				}}
				if(checkName(field[i])==false && i <= 3){
					if(checkName(field[i+1])==true){
						field[i] = field[i+1];
						field[i+1] = cardlib.nocard();
				}
			}}
		
			
				
			/**
			if(checkName(field[i]) == false && checkName(field[i+1])==true){
				field[i] = field[i+1]; field[i+1] = cardlib.nocard(); }
			
			if(checkName(field[i])==true && i>= getFieldlength()){
				for(int j = 0; j < getFieldlength(); j +=1){
					if(checkName(field[j]) == false){
						field[j] = field[i]; field[i] = cardlib.nocard();}
				}
			} 
		*/
	}
	// Dead card function to add card to cementary. 
	public void deadCard(Card obj){
		if (obj.getHealth() <= 0){
			cementary[cementarylength]= obj;
			cementarylength+=1;
			for(int i = 0; i < fieldsize; i+=1){
				if(field[i].getName().equals(obj.getName())){
					field[i] = cardlib.nocard(); 
				}
			}
			fieldlength -=1;
		}
		// function call for adjust field. 
		
	}
	


	// Getter for health.
	public int getHealth() {
		return health;
	}

	// Getter for deck length.
	public int getDecklength() {
		return decklength;
	}
	
	// Getter for hand length.
	public int getHandlength() {
		return handlength;
	}

	// Getter for field length. 
	public int getFieldlength() {
		return fieldlength;
	}

	// getter for cementary length.
	public int getCementarylength() {
		return cementarylength;
	}
	
	public void getHealed(int i){
		health+=i;
	}

}
