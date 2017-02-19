package Titan;
import Common.*;

public class TitanGame extends Game{

	
	int cementarysize = 10, cementarylength = 0; 
	Titancard[] cementary = new Titancard[cementarysize]; 
	Titancard[] deck, hand, field;
	//TitanObserver observer = new TitanObserver();
	Cardlib lib = FactoryProducer.getLib("Titans", null); 
	TitanGame enemy;
	

	
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
		
		setdeck();
		sethand();
		setfield();
		setcementary();
	}
	
	public void draw(){ 
		hand[handlength]=deck[0] ;
		decklength -= 1;
		handlength+=1;
		adjustdeck();
	}
	
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
	
	public void setcementary(){
		for(int i = 0; i < cementarylength; i+=1){
			cementary[i] = lib.getTitancard("No card");
	}	}
	
	public void setEnemy(TitanGame person){this.enemy = person;}
	
	public void adjustdeck(){
		//decklength is suppose to be the next free space to 
		//store a Titancard object. It was decremented in the draw()
		//so now a card that was at decklength-1 is at decklength
		//thus i < decklength condition for i+1 is the last real card
		
		for(int i = 0; i < decklength; i+=1){
			if(deck[i].getName().equalsIgnoreCase("No card"))
				{deck[i] = lib.getTitancard("No card");
					deck[i] = deck[i+1];
					deck[i+1] = lib.getTitancard("No card");}
		}
	}
	
	public void adjusthand(){
		for (int i = 0; i < handlength; i+=1){
			if (hand[i].getName().equalsIgnoreCase("no card")){
				hand[i] = hand[handlength-1];
				hand[handlength - 1] = lib.getTitancard("No card");
				handlength-=1;
			}
		}
	}
	
	public void adjustfield(){
		for (int i = 0; i < fieldlength; i+=1){
			if (field[i].getName().equals("no card")){
				for (int j = i; j < fieldlength; j+=1){
					if (j == fieldsize-1)
						break; 
					else
						field[j]= field[j+1];
					
				}
			}
		}
	}
	
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
	
	public void attack(){
		for(int i = 0; i < fieldlength; i +=1){
			//field[i].attack(i);
		}
	}
	
	public void attackEnemy(int position, int attackDamage){
		enemy.attacked(position, attackDamage);
	}
	
	public void attacked(int position, int attackDamage){
		if(field[position].getName().equals("No card"))
			damaged(attackDamage);
		else 
			field[position].damaged(attackDamage);
	}
	
	public void playcard(String key){
		for (int i=0; i < handlength; i++){
			if (hand[i].getkey().equals(key)){
				field[fieldlength] = hand[i];
				hand[i] = lib.getTitancard("No card");
				fieldlength+=1;
			}
	}}
	
	public void updatetimers(){
		for (int i = 0; i < handlength; i+=1){
			hand[i].reduceTimer();
		}
	}
	
	public Titancard getFieldcard(int position){
		return field[position];
	}
	
	public Titancard getHandcard(int position){
		return hand[position];
	}
	
	@Override
	public void damaged(int n) {
		health -= n;
		
	}}
