package Titan;

import java.util.Scanner;

import Common.Duel;
import Titan.*;

public class TitanPlay {
	
	static TitanPlayer one = new TitanPlayer(null);
	static TitanAi two = new TitanAi();
	
	public static void playAI(){
		one.setEnemy(two); 
		two.setEnemy(one);
		//while loop
		while(true){
			one.newTurn();
			one.playTurn();
			one.endTurn();
			if(two.gethealth() <= 0){
				System.out.println("\n THE WINNER IS " + one.getName());
				break;
			}
			two.newTurn();
			two.playTurn();
			two.endTurn();
			
			if(one.gethealth() <=0){
				System.out.println("\n THE WINNER IS " + two.getName());
				break;
				
			}
		}
	}
	
	public static void playCampaign(){
		TitanPlayer campaign1 = new TitanPlayer(new Enemy1("Campaign 1"));
		TitanPlayer campaign2 = new TitanPlayer(new Enemy2("Campaign 2"));
		TitanPlayer campaign3 = new TitanPlayer(new Enemy3("Campaign 3"));
		boolean proceed;
        System.out.println("Campaign line up\n Campaign Foe One -> Campaign Foe two -> Campaign Foe three");
		
        one.setEnemy(campaign1);
        campaign1.setEnemy(one);
        
		if( proceed = Duel.battle(one, campaign1)){
			System.out.println("THE WINNER IS: " + one.getName());
			one.reset();
		}
		else{
			System.out.println("You lost to Campaign Enemy 1");
		}
		if(proceed){
			one.setEnemy(campaign2);
	        campaign2.setEnemy(one);
			
			if(proceed = Duel.battle(one, campaign2))
				System.out.println("THE WINNER IS: " + one.getName());
			else
				System.out.println("You lost against Campaign Enemy 2");
			one.reset();
		}
		if(proceed){
			
			one.setEnemy(campaign3);
	        campaign3.setEnemy(one);
	        
			if(proceed = Duel.battle(one, campaign3))
				System.out.println("THE WINNER IS: " + one.getName());
			else
				System.out.println("You lost against Campaign Enemy 3");
			one.reset();
		}
		
	}
	
	public static void play(){
	
		System.out.println("Which of the following you want to play against? ");
		System.out.println("1- Another player press 1");
		System.out.println("2- computer press or AI 2");
		System.out.println("3- Campaign 3");
		
		Scanner in = new Scanner(System.in);

		int i = in.nextInt();
		if (i == 1){
			TitanPlayer second = new TitanPlayer(null);
			one.setEnemy(second);
			second.setEnemy(one);
			
			Duel.battle(one, second);
		}
		if (i == 2){
			playAI();
		}
		if (i == 3){
			playCampaign();
		}
}
}

