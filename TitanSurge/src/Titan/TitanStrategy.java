package Titan;
import Common.*;
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
	
	public void handcards(){
			
			System.out.println("Enter -1 to stop playing cards from hand");
			player.printhand();
			
			while(player.gethandlength() > 0){
				
				choice = read.nextInt();
				if(choice >= 0 && choice <= player.gethandlength()){
					if(player.gethandcard(choice -1 ).getTimer() <= 0){
						player.gethandcard(choice -1).onplay();
						System.out.println();
						player.printhand();
					}
					
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
}
	
