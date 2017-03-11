package Titan;
import java.io.IOException;
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
	TitanStrategy strat = new TitanStrategy(observer, this);
	static int count = 1;
	String name = "Player " + String.valueOf(count);
	boolean isHuman = true;
	TitanGame enemy;
	

	public TitanGame(){
		
		count+=1;
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
	//#######################################################
	public void printDeck(){
		for(Titancard card: deck){
			System.out.println(card.getName());
		}
	}
	
	public void setup(){
		draw();
		draw();
		draw();
	}
	
	public void printhand(){

		for(int i = 0; i < handlength; i +=1){
			System.out.println((i+1) + ": " + hand[i].getName() + " Card health: " + hand[i].getHealth()
					+"\n\tCard Timer: " + hand[i].getTimer() + " Card Attack: " + hand[i].getAttack());
		}
	}
	
	public void printfield(){
		for(int i = 0; i < fieldlength; i++){
			System.out.println((i+1) + ": " + field[i].getName() + " Card health: " + field[i].getHealth()
					+"\n\tCard Timer: " + field[i].getTimer() + " Card Attack: " + field[i].getAttack());
		
		}
	}
	
	public void checkhand(){
		hand[0] = hand[1];
		hand[1] = lib.getTitancard("No card");
	}
	//#######################################################
	
	public void reset(){
		health = 1000;
		handlength = 0;
		fieldlength = 0;
		setdeck();
		shuffle();
		sethand();
		setfield();
		setcementary();
	}
	
	public void draw(){ 
		if(decklength > 0){
			hand[handlength] = deck[0] ;
			decklength -= 1;
			handlength += 1;
			deck[0] = lib.getTitancard("No card");
			adjustdeck();}
	}
	
	public void newTurn(){
		enemy.updatetimers();
		updatetimers();
		draw();
	}
	
	public void playTurn() throws IOException{
		if(isHuman == true)
			strat.handcards();
		else
			strat.attackStrategy();
	}
	
	public void endTurn(){
		attack();
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
		decklength = 10;
		}
	
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
	public void sethand(){
		hand[0] = lib.getTitancard("No card");
		hand[1] = lib.getTitancard("No card");
		hand[2] = lib.getTitancard("No card");
		hand[3] = lib.getTitancard("No card");
		hand[4] = lib.getTitancard("No card");
	}
	
	public void setcementary(){
		for(int i = 0; i < cementarysize; i+=1){
			cementary[i] = lib.getTitancard("No card");
	}	}
	
	public void setEnemy(TitanGame person){this.enemy = person;}
	public String getName(){return name;}
	
	public void adjustdeck(){
		if(decklength > 0){
		for(int i = 0; i < decklength; i+=1){
			deck[i] = deck[i+1];
		}
		deck[decklength] = lib.getTitancard("No card");
		}
		
		//decklength is suppose to be the next free space to 
		//store a Titancard object. It was decremented in the draw()
		//so now a card that was at decklength-1 is at decklength
		//thus i < decklength condition for i+1 is the last real card
		
		}
	
	public void adjusthand(){
		
		for (int i = 0; i < handlength; i+=1){
			if (hand[i].getName().equalsIgnoreCase("No card") ){
				hand[i] = hand[i+1];
				hand[i + 1] = lib.getTitancard("No card");
			}
		}
	}
	
	public void adjustfield(){
		for (int i = 0; i < fieldlength; i+=1){
			if (field[i].getName().equalsIgnoreCase("No card")){
				field[i] = field[i+1];
				field[i+1] = lib.getTitancard("No card");
			}
			
		}
	}
	
	public Titancard gethandcard(int i){
		return hand[i];
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
			field[i].attack(i);
		}
	}
	
	public void attackEnemy(int position, int attackDamage){
		enemy.attacked(position, attackDamage);
	}
	
	public void attacked(int position, int attackDamage){
		if(field[position].getName().equalsIgnoreCase("No card"))
			health -= attackDamage;
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
			
		}
		handlength -=1;
		adjusthand();}
	
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
		
	}
	
	//used to signal the flag to say
	//'Hey it's a campaign class so it uses the campaign strategy'
	//instead of waiting for user import to make the moves
	protected void setCampaign(){isHuman = false;}
	
	public void setname(String title){name = title;}
	
	public void sethealth(int i ){health = i;}
	
	public void setdecklength(int i ){decklength = i;}
	
	public void sethandlength(int i){handlength = i;}
	
	public void setfieldlength(int i){fieldlength = i;}
	
	public void setcementarylength(int i){cementarylength = i;}
	
	public void setdeckcard(String card, int i ){deck[i] = lib.getTitancard(card);}
	
	public void sethandcard(String card, int i){hand[i] = lib.getTitancard(card);}
	
	public void setfieldcard(String card, int i){field[i] = lib.getTitancard(card);}
	
	public void setcementarycard(String card, int i){cementary[i] = lib.getTitancard(card);}
	
	public Titancard getdeckcard(int i){return deck[i];}
	
	public Titancard getcementarycard(int i){return cementary[i];}
	
	public int getdecksize(){return decksize;}
	
	public int getfieldsize(){return fieldsize;}
	
	public int gethandsize(){return handsize;}
	
	public int getcementarysize(){return cementarysize;}
	
	public int getcementarylength(){return cementarylength;}
}
