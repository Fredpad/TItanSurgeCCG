package Titan;
import Common.Game;

public class TitanGame extends Game{

	
	int cementarysize = 10, cementarylength = 0; 
	
	Card[] cementary = new Card[cementarysize]; 
	
	
	public abstract void deadcard(String name);
	public abstract void setfield();
	public abstract void setdeck();
	public abstract void sethand();
	
	//***The constructor will initiliaze the values from the 
	//***parent class Game that had no values 
	TitanGame(){
		health = 1000;
		handsize = 5 ;
		decksize = 10 ;
		fieldsize = 5;
		deck = new Card[decksize];
		field = new Card[fieldsize];
		hand = new Card[handsize];
		lib = FactoryProducer.getLib("Titans");
	}
	public void deadcard(String name){
		for (int i = 0; i < fieldlength; i++){
			if (field[i].getName().equal(name)){
				cementary[cementarylength]= field[i];
				field[i] = lib.nocard();
				fieldlength--;
				cementarylength++;
			}
		}
		adjustfield();
	}	
			
	public void setdeck(){
		deck[0] = lib.getTitancard("Lion")
		deck[1] = lib.getTitancard("Spider")
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
			hand[i].reducetimer();
		}
	}
			
	public void setcementary(){
		cemetary[0] = lib.getTitancard("No card");
		cemetary[1] = lib.getTitancard("No card");
		cemetary[2] = lib.getTitancard("No card");
		cemetary[3] = lib.getTitancard("No card");
		cemetary[4] = lib.getTitancard("No card");
		cemetary[5] = lib.getTitancard("No card");
		cemetary[6] = lib.getTitancard("No card");
		cemetary[7] = lib.getTitancard("No card");
		cemetary[8] = lib.getTitancard("No card");
		cemetary[9] = lib.getTitancard("No card");


	}
