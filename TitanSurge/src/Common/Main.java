package Common;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random rand = new Random();
		int d = rand.nextInt(8);
	
	
		for(int i = 0; i < 10; i++){
			d = rand.nextInt(8);
			System.out.println(d);
		}
		
		



	}

}
