package Omens;

import Common.Cardlib;
import Omencards.Coin;
import Omencards.CollectTaxes;
import Omencards.Courtesan;
import Omencards.CourtlyIntrigue;
import Omencards.Mercernary;
import Omencards.Militia;
import Omencards.Nocard;
import Omencards.Prayer;
import Omencards.Randomcard;
import Omencards.Serf;
import Omencards.SpiceRoute;
import Omencards.Supplicant;
import Omencards.WealthyPatron;
import Titan.Titancard;

public class Omenslib extends Cardlib {
	CardObserver observer;
	
	public Omenslib(CardObserver obs){
		this.observer = obs; 
	}

	@Override
	public Titancard getTitancard(String name) {
		return null;
	}

	public Omenscard getOmenscard(String name){
		if(name.equalsIgnoreCase("Militia"))
			return new Militia(observer);
		
		else if(name.equalsIgnoreCase("Serf"))
			return new Serf(observer);
		
		else if(name.equalsIgnoreCase("Wealthy Patron"))
			return new WealthyPatron(observer);
		
		else if(name.equalsIgnoreCase("Courtesan"))
			return new Courtesan(observer);
		
		else if(name.equalsIgnoreCase("Mercernary"))
			return new Mercernary(observer);
		
		else if(name.equalsIgnoreCase("Supplicant"))
			return new Supplicant(observer);
		
		else if(name.equalsIgnoreCase("Collect Taxes"))
			return new CollectTaxes(observer);
		
		else if(name.equalsIgnoreCase("Courtly Intrigue"))
			return new CourtlyIntrigue(observer);
		
		else if(name.equalsIgnoreCase("Prayer"))
			return new Prayer(observer);
		
		else if(name.equalsIgnoreCase("Spice Route"))
			return new SpiceRoute(observer);
		
		else if(name.equalsIgnoreCase("random"))
			 return Randomcard.randomcard(observer);
		
		else if(name.equalsIgnoreCase("Coin"))	
			return new Coin(observer);
		
		else if(name.equalsIgnoreCase("No card"))
			return new Nocard();
				
		else return null;
	}

}
