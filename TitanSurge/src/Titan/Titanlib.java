package Titan;
import Common.*;

import Omens.*;
import Titancards.*;

public class Titanlib extends Cardlib {
	TitanObserver observer; 
	
	
	
	@Override
	public Titancard getTitancard(String name) {
		if(name.equalsIgnoreCase("Lion"))
			return new Lion(observer);
		else if(name.equalsIgnoreCase("Spider"))
			return new Spider(observer);
		else if(name.equalsIgnoreCase("Spider"))
			return null;
		else if(name.equalsIgnoreCase("Spider"))
			return null;
		else if(name.equalsIgnoreCase("Spider"))
			return null;
		else if(name.equalsIgnoreCase("Spider"))
			return null;
		else if(name.equalsIgnoreCase("Spider"))
			return null;
		else if(name.equalsIgnoreCase("Spider"))
			return null;
		else if(name.equalsIgnoreCase("Spider"))
			return null;
		else if(name.equalsIgnoreCase("Spider"))
			return null;
		else
			return null;
	}	

	@Override
	public Omenscard getOmenscard(String name) {
		return null;
	}

}
