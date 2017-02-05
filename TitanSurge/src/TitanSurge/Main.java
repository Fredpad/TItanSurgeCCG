package TitanSurge;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Player one = new Player();
		Player two = new Player(); 
		one.setEnemy(two);two.setEnemy(one);
		one.setName("Player One"); two.setName("Player Two");
		
		List<Player> players = new ArrayList<Player>(); 
		players.add(one); players.add(two);
		PlayGame match = new PlayGame(players);
		
		Player winner = match.play();
		System.out.println(winner.getName());
		

	}

}
