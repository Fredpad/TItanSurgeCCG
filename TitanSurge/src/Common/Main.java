package Common;
import Omens.*;

import java.io.IOException;
import java.util.Random;
import Titan.*;
//import Titan.Player;1

//import Omens.Player;
import Omens.*;

public class Main {

	public static void main(String[] args) {
		OmenPlayer one = new OmenPlayer(null); 
		OmenPlayer two = new OmenPlayer(null);
		one.setEnemy(two);
		
		one.gainApples(3);
		one.gainMagic(3);
		one.playTurn();
		one.endTurn();
		
		for(int i = 0; i < 3; i++){
			one.newTurn();
			one.playTurn();
			one.endTurn();
		}
		
		/*
		Random rand = new Random(); 
		int randnum = rand.nextInt((9 -0 ) +1)+0; 
		int loop = 0; 
		
		while(loop < 10){
			System.out.println(randnum);
			randnum = rand.nextInt((9 -0 ) +1)+0; 
			loop++;}
		*/
	}

}
