package Omens;
import java.util.Scanner;

import Common.*;

public class OmenStrategy {
	CardObserver observer;
	public OmensGame player;
	int choice = -1;
	String use;
	Scanner read = new Scanner(System.in);
	
	public OmenStrategy(CardObserver obs, OmensGame person){
		this.observer = obs;
		this.player = person;}
	
	public void handcards(){
		
		System.out.println("Enter -1 to stop playing cards from hand");
		player.printhand();
		
		while(player.gethandlength() > 0){
			
			choice = read.nextInt();
			if(choice >= 0 && choice <= player.gethandlength()){
				player.gethandcard(choice -1).onplay();
				System.out.println();
				player.printhand();
			}
			else if(choice > player.gethandlength())
				{
				System.out.println("That isn't a card in hand");
				System.out.println();
				player.printhand();
				}
			else if(choice == -1)
				break;
		}
		
		System.out.println("\n Player Gold: " + player.getGoldAmount());
	}
	
	public void buycards(){
		
		System.out.println("Enter -1 to stop buying cards from bank");
		player.printbank();
		choice = -1;
		
		while(player.getGoldAmount() >= player.cheapestcard()){
			
			choice = read.nextInt();
			
			if(choice >=0 && choice <= player.getBanklength()){
				
				if(player.getGoldAmount() >= player.getbankcard(choice -1 ).getCost()){
					player.getbankcard(choice -1).buy();
					player.printbank();
					System.out.println("Player Gold: " + player.getGoldAmount() );
				}
				else{
					System.out.println("There isn't enough gold for that card.");
					player.printbank();
					System.out.println("Player Gold: " + player.getGoldAmount() );
				}
				
			}
			
			else if(choice > player.getBanklength())
			{
				System.out.println("That isn't a card in the bank");
				System.out.println();
				player.printbank();
				}
			
			else if(choice == -1)
				break;
			
		}
		
		System.out.println("\nPlayer Hand: ");
		player.printhand();
		System.out.println();
		handcards();
	}
	
	public void useresources(){
		
		
		
		
		while(player.getApplesAmount() > 0){
			System.out.println("type minion : uses apples on minion\ntype self : use apples on your health\n"
					+ "Type skip to move on");
			
			player.printresources();
			use = read.next();
			
			/**FIRST if-else */
			
			if(use.equalsIgnoreCase("self")){
				player.eatApples();
				player.printresources();
				System.out.println();
			}
			else if(use.equalsIgnoreCase("minion")){
				
				/**SECOND if-else */
				
				if(player.getfieldlength() > 0){
					
					System.out.println("Enter -1 to stop feeding minions");
					
					//LOOP that allows the feeding of minions until 0 apples
					while(player.getApplesAmount() > 0){
						
						System.out.println("Player Field:");
						player.printfield();
						System.out.println("which minion to feed?");
						choice = read.nextInt();
						
						/**THIRD if-else */
						
						if(choice > 0 && choice <= player.getfieldlength()){
							
							player.getfieldcard((choice -1)).consumeApples();
							player.printresources();
							System.out.println();}
						
						else if(choice == -1)
							break;
						
						else{
							
							while((choice > 0 && choice <= player.getfieldlength()) == false){
								
								System.out.println("That card is not on the field, enter a valid card number");
								player.printfield();}
							}	
					}}
				
				else
					System.out.println("There are no minions on the field");}
			
			else if(use.equalsIgnoreCase("skip"))
				break;
		}
		
		while(player.getSkullAmount() > 0){
			System.out.println("type minion : attacks enemy minion with skulls, if any\n" 
					+ "type enemy : attacks enemy player with a skull");
			choice = -1;
			
			if(player.enemy.getfieldlength() > 0){
				System.out.println("\nEnemy field");
				player.enemy.printfield();
			}
			else
				System.out.println("enemy does not have a field");
			
			player.printresources();
			use = read.next();
			
			/**FIRST if-else chain*/
			
			if(use.equalsIgnoreCase("minion")){
				
				/**SECOND if-else chain*/
					if(player.enemy.getfieldlength() > 0){
						player.loseSkulls(1);
						player.enemy.lowestMinion();
						System.out.println("\nEnemy field After attack");
						player.enemy.printfield();
					}
					else
						System.out.println("There are no cards on the enemy field");
				}
			
			else if(use.equalsIgnoreCase("enemy")){
				player.loseSkulls(1);
				player.enemy.defend();
				System.out.println("Enemy Health: " + player.enemy.gethealth());
			}
		}
		
		while(player.getMagicAmount() > 0){
			System.out.println("type minion : uses magic on minion\ntype self : use magic on your health\n"
					+ "type enemy to attack enemy player \nType skip to move on");
			
			player.printresources();
			use = read.next();
			
			/**FIRST if/else chain */
			
			if(use.equalsIgnoreCase("self")){
				
				player.eatMagic();
				player.printresources();
				System.out.println();}
			
			else if(use.equalsIgnoreCase("enemy")){
				player.loseMagic(1);
				player.enemy.defend();
			}
			else if(use.equalsIgnoreCase("minion")){
				
				/**SECOND if/else chain*/
				
				if(player.getfieldlength() > 0){
					
					System.out.println("Enter -1 to stop selecting minions");
					
					while(player.getMagicAmount() > 0){
					
						System.out.println("Player Field:");
						player.printfield();
						System.out.println("which minion to feed?");
						choice = read.nextInt();
						
						/**THIRD if/else chain*/
						
						if(choice > 0 && choice <= player.getfieldlength()){
							
							player.getfieldcard((choice -1)).consumeMagic();
							player.printresources();
							System.out.println();}
						
						else if(choice == -1)
							break;
						else{
							
							while((choice > 0 && choice <= player.getfieldlength()) == false){
								
								System.out.println("That card is not on the field, enter a valid card number");
								player.printfield();}
							}	
					}}
				
				else
					System.out.println("There are no minions on the field");
			}
			
			else if(use.equalsIgnoreCase("skip"))
				break;
		}
	}

	public void Attackstrategy(){
		
		/*Focuses on getting cards that can just do damage and go offensive
		 * Plays entire hand, then buys from bank, then attacks */
		
		for(int i = 0; i < player.gethandlength(); i+=1){
			player.gethandcard(i).onplay();
		}
		
		for(int i = 0; i < player.getBanklength(); i+=1){
			if(player.getbankcard(i).getName().equalsIgnoreCase("Militia"))
				player.getbankcard(i).buy();
			else if(player.getbankcard(i).getName().equalsIgnoreCase("Mercernary"))
				player.getbankcard(i).buy();
			else if(player.getbankcard(i).getName().equalsIgnoreCase("Courtesan"))
				player.getbankcard(i).buy();
		}
		
		if(player.getApplesAmount() > 0){
			for(int i = 0; i < player.getfieldlength(); i+=1){
				
				if(player.getfieldcard(i).getName().equalsIgnoreCase("Courtesan")){
					while(player.getApplesAmount() > 0){
						player.getfieldcard(i).consumeApples();}
					}
				else if(player.getfieldcard(i).getName().equalsIgnoreCase("Mercernary")){
					while(player.getApplesAmount() > 0){
						player.getfieldcard(i).consumeApples();}
					}
				else if(player.getfieldcard(i).getName().equalsIgnoreCase("Militia")){
					while(player.getApplesAmount() > 0){
						player.getfieldcard(i).consumeApples();}
					}
				}
		}
		
		if(player.getMagicAmount() > 0){
			for(int i = 0; i < player.getfieldlength(); i+=1){
				
				if(player.getfieldcard(i).getName().equalsIgnoreCase("Courtesan")){
					while(player.getApplesAmount() > 0){
						player.getfieldcard(i).consumeMagic();}
					}
				else if(player.getfieldcard(i).getName().equalsIgnoreCase("Mercernary")){
					while(player.getApplesAmount() > 0){
						player.getfieldcard(i).consumeMagic();}
					}
				else if(player.getfieldcard(i).getName().equalsIgnoreCase("Militia")){
					while(player.getApplesAmount() > 0){
						player.getfieldcard(i).consumeMagic();}
					}
				}
		}
	}
}
