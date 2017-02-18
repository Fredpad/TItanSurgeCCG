package Omencards;

import java.util.Random;

import Omens.CardObserver;
import Omens.Omenscard;

public class Randomcard {
	
	public static Omenscard randomcard(CardObserver observer){
		
		Random rand = new Random(); 
		int randnum = rand.nextInt((9 -0 ) +1)+0; 
		Omenscard[] list = new Omenscard[10];
		list[0] = new Mercernary(observer);
		list[1] = new Serf(observer);
		list[2] = new Supplicant(observer);
		list[3] = new WealthyPatron(observer);
		list[4] = new Militia(observer);
		list[5] = new Courtesan(observer);
		list[6] = new SpiceRoute(observer);
		list[7] = new CourtlyIntrigue(observer);
		list[8] = new CollectTaxes(observer);
		list[9] = new Prayer(observer);
		
		return list[randnum];
	}
}