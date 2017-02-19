package Titan;
import Common.*;
import Omens.Omenscard;
import Titancards.*;

public class Titanlib extends Cardlib {
	CardObserver observer; 
	
	
	public Titanlib(CardObserver obs)
		{this.observer = obs;}
	
	
	public Titancard getTitancard(String name) {
		
		if(name.equalsIgnoreCase("Lion"))
			return new Lion(observer);
		
		else if(name.equalsIgnoreCase("Spider"))
			return new Spider(observer);
		
		else if(name.equalsIgnoreCase("Dripfairy"))
			return new Dripfairy(observer);
		
		else if(name.equalsIgnoreCase("Orc Soldier"))
			return new Orcsoldier(observer);
		
		else if(name.equalsIgnoreCase("Snow Oak Fiary"))
			return new Snowoakfairy(observer);
		
		else if(name.equalsIgnoreCase("Swamp Wolf"))
			return new Swampwolf(observer);
		
		else if(name.equalsIgnoreCase("Tundra Troll"))
			return new Tundratroll(observer);
		
		else if(name.equalsIgnoreCase("Vampire Bat"))
			return new Vampirebat(observer);
		
		else if(name.equalsIgnoreCase("Viking Chief"))
			return new Vikingchief(observer);
		
		else if(name.equalsIgnoreCase("Flame Wyvern"))
			return new Flamewyvern(observer);
		
		else
			return new Nocard();
	}	

	@Override
	public Omenscard getOmenscard(String name) {
		return null;
	}

}
