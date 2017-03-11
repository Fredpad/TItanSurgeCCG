package Omens;
import Common.*;

import java.io.IOException;
import java.util.Scanner;

public class OmensPlay {
	static OmenPlayer one = new OmenPlayer(null);
	static Scanner read = new Scanner(System.in);
	static String input;
	
	//IF PLAYER WANTS TO FIGHT AN AI, THIS METHOD IS CALLED
	private static void playAI() throws IOException{
		OmenAi two = new OmenAi();
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
	
	/*THE CAMPIAGN OF THE OMEN GAME. IT IS IN A BINARY TREE. STORES 8 ENEMIES IN AN ARRAY
	 * AND LATER CALLS THEM DEPENDING ON THE CHOICES THE PLAYER MAKES
	 * */
	public static void playCampaign() throws IOException{
		
		OmenPlayer campaignchain [] = new OmenPlayer[8];
		Scanner read = new Scanner(System.in);
		int fight;
		
		System.out.println("Welcome to the Campaign! After the first battle, you will be given 2 choices\n"
				+ "In all, you will face 4 Campaign Enemies. The First and Last are always the same\n"
				+ "The Path's are as follows"
				+ "\nEnemy 1 -> Enemy 2 or Enemy 3\n"
				+ "Enemy 2 -> Enemy 4 or Enemy 5\n"
				+ "Enemy3 -> Enemy 6 or Enemy 7\n"
				+ "Then the finally Enemy 8 regardless of which path you picked");
		
		OmenPlayer campaign1 = FactoryProducer.getOmen("Campaign 1");
		OmenPlayer campaign2 = FactoryProducer.getOmen("Campaign 2");
		OmenPlayer campaign3 = FactoryProducer.getOmen("Campaign 3");
		OmenPlayer campaign4 = FactoryProducer.getOmen("Campaign 4");
		OmenPlayer campaign5 = FactoryProducer.getOmen("Campaign 5");
		OmenPlayer campaign6 = FactoryProducer.getOmen("Campaign 6");
		OmenPlayer campaign7 = FactoryProducer.getOmen("Campaign 7");
		OmenPlayer campaign8 = FactoryProducer.getOmen("Campaign 8");
		
		campaignchain[0] = campaign1; 
		campaignchain[1] = campaign2;
		campaignchain[2] = campaign3;
		campaignchain[3] = campaign4;
		campaignchain[4] = campaign5;
		campaignchain[5] = campaign6;
		campaignchain[6] = campaign7;
		campaignchain[7] = campaign8;
		
		boolean proceed;
        
        if(Duel.battle(one, campaignchain[0])==true){
        	
        	one.reset();
        	System.out.println("Face " + campaignchain[1].getName() + " Or " + campaignchain[2].getName() + "\nEnter 2 or 3");
        	fight = read.nextInt();
        	
        	while(true){
        		if(fight != 2){
        			if(fight !=3)
        				fight = read.nextInt();
        			else 
        				break;
        		}
        	}
        	
        	if (fight == 2){
        		proceed = Duel.battle(one, campaignchain[1]);
        		one.reset();
        		
        		if(proceed == true){
        			System.out.println("Fight " + campaignchain[3].getName() + " Or " + campaignchain[4].getName() + "\nEnter 4 or 5");
        			fight = read.nextInt();
        			
        			while(true){
                		if(fight != 4){
                			if(fight !=5)
                				fight = read.nextInt();
                			else 
                				break;
                		}
                	}
        			
        			if(fight == 4){
                		proceed = Duel.battle(one, campaignchain[3]);
                		one.reset();
                		if (proceed == true){
                    		proceed = Duel.battle(one, campaignchain[7]);

                		}
                		else
                			System.out.println("Good Try on the campaign");

        			}
        			else if(fight == 5){
                		proceed = Duel.battle(one, campaignchain[4]);
                		one.reset();
                		if (proceed == true){
                    		proceed = Duel.battle(one, campaignchain[7]);
                    		System.out.println("THANK YOU FOR WINNING THE CAMPAIGN");
                		}
                		else
                			System.out.println("Good Try on the campaign");

        			}
        		}
        		
        		else
        			System.out.println("Good try on the campaign");
        	
        		
        	}
        	else if (fight== 3){
        		
        		proceed = Duel.battle(one, campaignchain[2]);
        		one.reset();
        		
        		if(proceed == true){
        			System.out.println("Fight " + campaignchain[5].getName() + " Or " + campaignchain[6].getName() + "\nEnter 6 or 7");
        			fight = read.nextInt();
        			
        			while(true){
                		if(fight != 6){
                			if(fight !=7)
                				fight = read.nextInt();
                			else 
                				break;
                		}
                	}
        			
        			if(fight == 6){
                		proceed = Duel.battle(one, campaignchain[5]);
                		one.reset();
                		if (proceed == true){
                    		proceed = Duel.battle(one, campaignchain[7]);

                		}
                		else
                			System.out.println("Good Try on the campaign");

        			}
        			else if(fight == 7){
                		proceed = Duel.battle(one, campaignchain[6]);
                		one.reset();
                		if (proceed == true){
                    		proceed = Duel.battle(one, campaignchain[7]);
                    		System.out.println("THANK YOU FOR WINNING THE CAMPAIGN");
                		}
                		else
                			System.out.println("Good Try on the campaign");

        			}
        			
        		}
        		else
        			System.out.println("Good Try on the campaign");
        		
        	}}
        
        else
        	System.out.println("Good try on the campaign");
		
	}
	
	//pvp is a gaming acronym for Player vs Player :D
	public static void pvp() throws IOException{
		OmenPlayer two = FactoryProducer.getOmen("Player");
		one.setEnemy(two); two.setEnemy(one);
		
		boolean winner = Duel.battle(one, two);
		
		if(winner == false)
			System.out.println("\nPLAYER TWO IS THE WINNER");
		else
			System.out.println("\nPLAYER ONE IS THE WINNER");
	}
	
	//CALLED TO HAVE THE PLAYER SELECT WHAT TO PLAY. VS PLAYER, CAMPAIGN, OR AI
	public static void play() throws IOException{
		
		
		System.out.println("Do you want to do 'campaign', an 'AI' or vs a 'player' ?");
		input = read.nextLine();
		
		while(true){
			if(input.equalsIgnoreCase("campaign")){
				playCampaign();
				break;
			}
			else if(input.equalsIgnoreCase("AI")){
				try {
					playAI();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}
			else if(input.equalsIgnoreCase("player")){
				pvp();
				break;
			}
			else{
				System.out.println("Please enter 'campaign', 'AI', or 'player'");
				input = read.nextLine();
			}
		}
		
		
		}
}
