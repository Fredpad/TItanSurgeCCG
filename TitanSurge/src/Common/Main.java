package Common;

import java.io.IOException;
import java.util.Random;
import Titan.*;
import Omens.*;

public class Main {

	public static void main(String[] args) {
		
		TitanGame one = new TitanGame();
		TitanGame two = new TitanGame();
		one.setEnemy(two); two.setEnemy(one);
		
		
		one.setup();
		two.setup();
		
		one.getHandcard(0).onplay();
		one.getHandcard(0).onplay();
		one.getHandcard(0).onplay();
		
		two.getHandcard(0).onplay();
		two.getHandcard(0).onplay();
		two.getHandcard(0).onplay();
		System.out.println("\nPlayer 1 Field:" );
		one.printfield();
		System.out.println("\nPlayer 2 Field:" );
		two.printfield();
		
		one.attack();
		two.attack();
		
		System.out.println("\nPlayer 1 Field:" );
		one.printfield();
		System.out.println("\nPlayer 2 Field:" );
		two.printfield();
		/*
		
		
		System.out.println("\nPlayer 1 Field:");
		one.printfield();
		System.out.println("\nPlayer 2 Field:");
		two.printfield();
		
		one.attack();
		
		System.out.println("\nPlayer 1 Field:");
		one.printfield();
		System.out.println("\nPlayer 2 Field:");
		two.printfield();
		*/
		
	
			
		
	}

}
