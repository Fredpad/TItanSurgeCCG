package TitanSurge;

import java.util.List;
import java.util.Scanner;

public class Player extends Game {

	
	Player enemy;
	Move move=new Move(this);
	List<String> choices; 
	String name;
	boolean stratchoosed = false;
	BattleWatch watcher = new BattleWatch(this); 
	
	//Strat is needed to pass information about the player and the game to use the 
	//strategies. It is not used at all in this class 
	Strategy strat = new Strategy(this);

	
	Player(){
		cardlib.readyLib(this);
	}
	
	//new
	public void setName(String word){name = word;}
	//new
	public String getName(){return name;}

	public void setEnemy(Player obj){
		enemy = obj;
	}

	public void playTurn(){strat.playStrategy();}
	
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
	
	//new
	public void chooseStrategy(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Brute Force strategy is about playing the strongest cards first as soon as"
				+ " possible");
		System.out.println("Wall strategy is about playing cards with strong defense first to wittle away"
				+" at the enemy"); 
		System.out.println("\n Which strategy do you want to set: Brute Force or Wall");
		String choice = sc.nextLine();
		while(choice.equalsIgnoreCase("Brute Force")==false && choice.equalsIgnoreCase("Wall")==false){
			System.out.println("That is not a valid input. Please choose: Brute Force or Wall");
			choice = sc.nextLine();
		}
		move.choices(choice); 
	}
	public void updateCardtimers(){
		
		for (int i = 0; i < getHandlength(); i+=1){
			getHandcard(i).updateTimer(); 
		}
		for(int i = 0; i < enemy.getHandlength(); i +=1){
			enemy.getHandcard(i).updateTimer();
		}
	}
	
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
	
	public void rotation(){
		 newTurn();
         playTurn();
         //printboard();
         //Thread.sleep(3000);
         attack();
	}

	public void printboard(){
		System.out.println(name);
		for(int i = 0; i < getFieldlength(); i+=1){
			System.out.println(getFieldcard(i).getName() + " " + getFieldcard(i).getHealth());
		}
		System.out.println();
	}
}
