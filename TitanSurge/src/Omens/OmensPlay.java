package Omens;
import Common.*;
import java.util.Scanner;

public class OmensPlay {
	static OmenPlayer one = new OmenPlayer(null);
	static OmenAi two = new OmenAi();
	static Scanner read = new Scanner(System.in);
	static String input;
	
	private static void playAI(){
		one.setEnemy(two); two.setEnemy(one);
		
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
	
	private static void playCampaign(){
		OmenPlayer campaign1 = new OmenPlayer(new Enemy1("Campaign 1"));
		OmenPlayer campaign2 = new OmenPlayer(new Enemy2("Campaign 2"));
		OmenPlayer campaign3 = new OmenPlayer(new Enemy3("Campaign 3"));
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
			campaign1.setEnemy(one);
			
			if(proceed = Duel.battle(one, campaign2))
				System.out.println("THE WINNER IS: " + one.getName());
			else
				System.out.println("You lost against Campaign Enemy 2");
			one.reset();
		}
		if(proceed){
			
			one.setEnemy(campaign3);
			campaign1.setEnemy(one);
			if(proceed = Duel.battle(one, campaign3))
				System.out.println("THE WINNER IS: " + one.getName());
			else
				System.out.println("You lost against Campaign Enemy 3");
			one.reset();
		}
		
	}
	
	public static void play(){
		
		
		System.out.println("Do you want to do 'campaign', an 'AI' or vs a 'player' ?");
		input = read.nextLine();
		
		while(true){
			if(input.equalsIgnoreCase("campaign")){
				playCampaign();
				break;
			}
			else if(input.equalsIgnoreCase("AI")){
				playAI();
				break;
			}
			else if(input.equalsIgnoreCase("player")){
				
				break;
			}
			else{
				System.out.println("Please enter 'campaign', 'AI', or 'player'");
				input = read.nextLine();
			}
		}
		
		
		}
}
