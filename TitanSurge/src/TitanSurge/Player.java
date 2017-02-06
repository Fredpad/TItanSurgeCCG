package TitanSurge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player extends Game {

	
	Player enemy;
	Move move=new Move(this);
	String name;
	boolean stratchoosed = false;
	BattleWatch watcher = new BattleWatch(this); 
	List<Card> poisened = new ArrayList<Card>(); 
	
	//Strat is needed to pass information about the player and the game to use the 
	//strategies. It is not used at all in this class 
	Strategy strat = new Strategy(this);

	//tags it's cardlibrary so the card's know which player is it's owner for
	//reference
	Player(){
		cardlib.readyLib(this);
	}
	
	//sets players name
	public void setName(String word){name = word;}
	
	//returns players name
	public String getName(){return name;}

	//sets the enemy player 
	public void setEnemy(Player obj){
		enemy = obj;
	}

	//plays the strategy chosen for the player
	public void playTurn(){strat.playStrategy();}
	
	//when a new turn happens, the card timers decrease by 1 regardless of whom's 
	//turn it is, followed by a draw from the deck. If any gaps are on the field due to
	//cards being removed, then the field is adjusted 
	public void newTurn(){
		updateCardtimers();
		draw();

		adjustField();
		enemy.watcher.recordConditions();
		watcher.hasChanged();
		//for testing purposes, it is set by default
		//move.choices("Brute Force");
		
	
		if(stratchoosed ==false){
			stratchoosed = true;
			chooseStrategy();
		}
		
	}
	
	//asks the player what strategy they wish to use
	public void chooseStrategy(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Brute Force strategy is about playing the strongest cards first as soon as"
				+ " possible");
		System.out.println("Wall strategy is about playing cards with strong defense first to wittle away"
				+" at the enemy"); 
		System.out.println("\n" + name+ ",  Which strategy do you want to set: Brute Force or Wall");
		String choice = sc.nextLine();
		while(choice.equalsIgnoreCase("Brute Force")==false && choice.equalsIgnoreCase("Wall")==false){
			System.out.println("That is not a valid input. Please choose: Brute Force or Wall");
			choice = sc.nextLine();
		}
		move.choices(choice); 
	}
	
	//reduces card timers by 1 every turn. when the card 
	//timers are 0, then they can be played onto teh field
	public void updateCardtimers(){
		
		for (int i = 0; i < getHandlength(); i+=1){
			getHandcard(i).updateTimer(); 
		}
		for(int i = 0; i < enemy.getHandlength(); i +=1){
			enemy.getHandcard(i).updateTimer();
		}
	}
	
	public void rotation(){
		newTurn();
		playTurn();
		attack();
		endTurn();
	}

	//plays the selected card onto the field
	public void playCard(Card obj){
		placeCard(obj);
	}
	
	public void attack(){
	/*	if there are real cards in the field array, then they will attack
		checks to see if there is an opposing enemy card in front of it
		if so, then the card attacks the enemy card, if not it attacks the enemy directly
		if the card attacks an enemy card, reduce the enemy card health by the attack value
		of the attacking card, then call the deadCard() method to check if the enemycard is destroyed
*/
		for (int i = 0; i < getFieldlength(); i++){
			if(getFieldcard(i).getName().equals(("Spider"))){
				getFieldcard(i).ability();
			}
			getFieldcard(i).ability();
			if (enemy.getFieldcard(i).getName().equals("No card") ){
				enemy.directDamage(getFieldcard(i).getAttack()); 
			}
			if(enemy.getFieldcard(i).getName().equals("No card") == false){
				enemy.getFieldcard(i).damaged(getFieldcard(i).getAttack()); 
				enemy.deadCard(enemy.getFieldcard(i));
			}
		}
		
		
}
	//resolving the poisen status thats works at the end of the turn
	public void endTurn(){
		for(Card card: poisened){
			if(card.getHealth() > 0){
			card.Poisen();
		}}
		
		for(int i = 0; i < enemy.getFieldlength(); i+=1){
			if(enemy.getFieldcard(i).getName().equals("No card")==false)
				enemy.deadCard(enemy.getFieldcard(i));
		}
		enemy.adjustField();
		System.out.println();} 
	
	//prints the field 
	public void printboard(){
		System.out.println(name + " Life Points: " + getHealth());
		for(int i = 0; i < getFieldlength(); i+=1){
			System.out.format("%-14s%10s%4d%10s%4d\n",
					getFieldcard(i).getName(), "Health:", getFieldcard(i).getHealth(),
					"Attack:" ,getFieldcard(i).getAttack());
			//getFieldcard(i).getName() + " " + getFieldcard(i).getHealth()
		}
		System.out.println();
	}
	
	//if a card is poisened by Spider, they are put in a list to 
	//get damaged at the end of each turn, min. of 2 turns
	public void addPoisened(Card obj){
		obj.setPoisened();
		poisened.add(obj);
	}
}
