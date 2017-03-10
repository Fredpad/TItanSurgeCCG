package Titan;

import java.util.Scanner;

import Common.Duel;
import Common.FactoryProducer;
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
	
		TitanPlayer campaignchain [] = new TitanPlayer[8];
		Scanner read = new Scanner(System.in);
		int fight;
		
		System.out.println("Welcome to the Campaign! After the first battle, you will be given 2 choices\n"
				+ "In all, you will face 4 Campaign Enemies. The First and Last are always the same\n"
				+ "The Path's are as follows"
				+ "\nEnemy 1 -> Enemy 2 or Enemy 3\n"
				+ "Enemy 2 -> Enemy 4 or Enemy 5\n"
				+ "Enemy3 -> Enemy 6 or Enemy 7\n"
				+ "Then the finally Enemy 8 regardless of which path you picked");
		
		TitanPlayer campaign1 = FactoryProducer.getTitan("Campaign 1");
		TitanPlayer campaign2 = FactoryProducer.getTitan("Campaign 2");
		TitanPlayer campaign3 = FactoryProducer.getTitan("Campaign 3");
		TitanPlayer campaign4 = FactoryProducer.getTitan("Campaign 4");
		TitanPlayer campaign5 = FactoryProducer.getTitan("Campaign 5");
		TitanPlayer campaign6 = FactoryProducer.getTitan("Campaign 6");
		TitanPlayer campaign7 = FactoryProducer.getTitan("Campaign 7");
		TitanPlayer campaign8 = FactoryProducer.getTitan("Campaign 8");
		
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
        	
        	if (fight-1 == 1){
        		proceed = Duel.battle(one, campaignchain[1]);
        		one.reset();
        		
        		if(proceed == true){
        			System.out.println("Fight " + campaignchain[3].getName() + " Or " + campaignchain[4].getName() + "\nEnter 4 or 5");
        			fight = read.nextInt();
        			
        			while(true){
                		if(fight != 4 ){
                			if(fight != 5)
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
                    		System.out.println("AND THE CAMPAIGN IS OVER!!");

                		}

        			}
        			else if(fight == 5){
        				
                		proceed = Duel.battle(one, campaignchain[4]);
                		one.reset();
                		
                		if (proceed == true){
                    		proceed = Duel.battle(one, campaignchain[7]);

                    		System.out.println("AND THE CAMPAIGN IS OVER!!");
                		}

        			}
        		}
        		
        	}
        	else if (fight-1 == 2){
        		
        		proceed = Duel.battle(one, campaignchain[2]);
        		one.reset();
        		
        		if(proceed == true){
        			System.out.println("Fight " + campaignchain[5].getName() + " Or " + campaignchain[6].getName() + "\nEnter 6 or 7");
        			fight = read.nextInt();
        			
        			while(true){
        				
                		if(fight != 6){
                			if(fight != 7)
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
                    		System.out.println("AND THE CAMPAIGN IS OVER!!");

                		}

        			}
        			else if(fight == 7){
                		proceed = Duel.battle(one, campaignchain[6]);
                		one.reset();
                		if (proceed == true){
                    		proceed = Duel.battle(one, campaignchain[7]);
                    		System.out.println("AND THE CAMPAIGN IS OVER!!");
                		}

        			}
        		}
        	}
        //end of the first IF statement
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
			pvp();
		}
		if (i == 2){
			playAI();
		}
		if (i == 3){
			playCampaign();
		}
}
	public static void pvp(){
		TitanPlayer two = FactoryProducer.getTitan("player");
		one.setEnemy(two);
		two.setEnemy(one);
		boolean winner = Duel.battle(one, two);
		if(winner == false)
			System.out.println("\nPLAYER TWO IS THE WINNER");
		else
			System.out.println("\nPLAYER ONE IS THE WINNER");
	}
}

