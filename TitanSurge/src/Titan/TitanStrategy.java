package Titan;
import Common.*;

import java.io.IOException;
import java.util.Scanner;

public class TitanStrategy {

	CardObserver observer;
	public TitanGame player;
	int choice = -1;
	String use;
	Scanner read = new Scanner(System.in);
	
	public TitanStrategy(CardObserver obs, TitanGame person){
		this.observer = obs;
		this.player = person;
	}
	
	private void printupdate() throws IOException{
		System.out.println("Type 'print' to see your board, 'enemy' to print the enemy board"
				+ "\n'save' to save the game or 'load' to load a game \n'skip' to move on");

		use = read.nextLine();
		
		while(true){
			
			if(use.equalsIgnoreCase("print")){
				print();
				break;}
			
			else if(use.equalsIgnoreCase("skip")){
				System.out.println();
				break;}
			
			else if(use.equalsIgnoreCase("enemy")){
				printEnemy();
				break;
			}
			
			else if(use.equalsIgnoreCase("save")){
				SaveLoad.save(player, player.enemy);
				break;
			}
			
			else if(use.equalsIgnoreCase("load")){
				SaveLoad.load(player, player.enemy);
				break;
			}
			
			else{

				use=read.nextLine();
				}
		}
	}
	
	private void print(){
		player.printhand();
		player.printfield();
	}
	
	private void printEnemy(){
		player.enemy.printhand();
		player.enemy.printfield();
	}
	
	
	public void handcards() throws IOException{
		printupdate();
		
		System.out.println("\n" + player.getName() + " Health: " + player.gethealth());
			
			while(player.gethandlength() > 0){
				System.out.println("\nEnter -1 to stop playing cards from hand");
				player.printhand();
				
				choice = read.nextInt();
				if(choice >= 0 && choice <= player.gethandlength()){
					if(player.gethandcard(choice -1 ).getTimer() <= 0){
						player.gethandcard(choice -1).onplay();
						System.out.println("\n" + player.getName() + " hand: ");
						player.printhand();
						System.out.println("\n" + player.getName() + " field: ");
						player.printfield();
					}
					else if(player.gethandcard(choice-1).getTimer() > 0)
						System.out.println("Can not play that card, not enough turns have passed to lower its timer");
					
					
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

	}
	
	public void attackStrategy(){
		for(int i = 0; i < player.gethandlength(); i+=1){
			if(player.getHandcard(i).getTimer() <= 0)
				player.getHandcard(i).onplay();
		}

		System.out.println("\n" + player.getName() + " Health: " + player.gethealth());
		System.out.println("\n" + player.getName() + " Field:");
		player.printfield();
	}
}
	
