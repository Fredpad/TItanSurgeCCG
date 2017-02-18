package Titan;
import Common.*;

public class TitanGame extends Game{

	
	int cementarysize = 10, cementarylength = 0; 
	Titancard[] cementary = new Titancard[cementarysize]; 
	Titancard[] deck, hand, field;
	Cardlib lib = FactoryProducer.getLib("Titans", null); 
	

	
	//***The constructor will initiliaze the values from the 
	//***parent class Game that had no values 
	TitanGame(){
		health = 1000;
		handsize = 5 ;
		decksize = 10;
		fieldsize = 5;
		
		deck = new Titancard[decksize];
		field = new Titancard[fieldsize];
		hand = new Titancard[handsize];
		
	}
	
	public void draw(){ 
		deck[0] = hand[handlength];
		decklength --;
		handlength++;
	}
	
	public void deadcard(String name){
		for (int i = 0; i < fieldlength; i++){
			if (field[i].getName().equals(name)){
				cementary[cementarylength]= field[i];
				field[i] = lib.getTitancard("No card");
				fieldlength--;
				cementarylength++;
			}
		}
		adjustfield();
	}	
	
	public void playcard(String name){
		for (int i=0; i < handlength; i++){
			if (hand[i].getName().equals(name)){
				field[fieldlength] = hand[i];
				hand[i] = lib.getTitancard("No card");
				fieldlength++;
			}
	}}
	
	public void setdeck(){
		deck[0] = lib.getTitancard("Lion");
		deck[1] = lib.getTitancard("Spider");
		deck[2] = lib.getTitancard("Spider");
		deck[3] = lib.getTitancard("Spider");
		deck[4] = lib.getTitancard("Spider");
		deck[5] = lib.getTitancard("Spider");
		deck[6] = lib.getTitancard("Spider");
		deck[7] = lib.getTitancard("Spider");
		deck[8] = lib.getTitancard("Spider");
		deck[9] = lib.getTitancard("Spider");
		
		
	}
	
	public void setfield() {
		field[0] = lib.getTitancard("No card");
		field[1] = lib.getTitancard("No card");
		field[2] = lib.getTitancard("No Card");
		field[3] = lib.getTitancard("No Card");
		field[4] = lib.getTitancard("No card");
	}
	public void sethand(){
		hand[0] = lib.getTitancard("No card");
		hand[1] = lib.getTitancard("No card");
		hand[2] = lib.getTitancard("No card");
		hand[3] = lib.getTitancard("No card");
		hand[4] = lib.getTitancard("No card");
	}
	public void updatetimers(){
		for (int i = 0; i < handlength; i++){
			hand[i].reduceTimer();
		}
	}
	
	public void adjusthand(){
		for (int i = 0; i < handlength; i++){
			if (hand[i].getName().equals("no card")){
				hand[i] = hand[handlength-1];
				handlength--;
			}
		}
	}
	
	public void adjustfield(){
		for (int i = 0; i < fieldlength; i++){
			if (field[i].getName().equals("no card")){
				for (int j = i; j < fieldlength; j++){
					if (j == fieldsize-1)
						break; 
					field[j]= field[j+1];
					
				}
			}
		}
	}
	
	public void setcementary(){
		cementary[0] = lib.getTitancard("No card");
		cementary[1] = lib.getTitancard("No card");
		cementary[2] = lib.getTitancard("No card");
		cementary[3] = lib.getTitancard("No card");
		cementary[4] = lib.getTitancard("No card");
		cementary[5] = lib.getTitancard("No card");
		cementary[6] = lib.getTitancard("No card");
		cementary[7] = lib.getTitancard("No card");
		cementary[8] = lib.getTitancard("No card");
		cementary[9] = lib.getTitancard("No card");


	}

	@Override
	public void damaged(int n) {
		health -= n;
		
	}}
