package Common;

import Titan.*;
import Omens.*;

public class FactoryProducer {
	public static Cardlib getLib(String choice, CardObserver observer){
		if(choice.equals("Titan"))
			return new Titanlib(observer);
		else if(choice.equals("Omens"))
			return new Omenslib(observer);
		else 
			return null;
	}
	
	public static OmenPlayer getOmen(String choice){
		if(choice.equalsIgnoreCase("Campaign 1"))
			return new OmenPlayer(new OmenEnemy1("Campaign 1")); 
		else if(choice.equalsIgnoreCase("Campaign 2"))
			return new OmenPlayer(new OmenEnemy2("Campaign 2"));
		else if(choice.equalsIgnoreCase("Campaign 3"))
			return new OmenPlayer(new OmenEnemy3("Campaign 3"));
		else if(choice.equals("Player"))
			return new OmenPlayer(null);
		else
			return null;
	}
	
	public static TitanPlayer getTitan(String choice){
		if(choice.equalsIgnoreCase("Campaign 1"))
			return new TitanPlayer(new TitanEnemy1("Campaign 1"));
		if(choice.equalsIgnoreCase("Campaign 3"))
			return new TitanPlayer(new TitanEnemy1("Campaign 2"));
		if(choice.equalsIgnoreCase("Campaign 3"))
			return new TitanPlayer(new TitanEnemy1("Campaign 3"));
		if(choice.equalsIgnoreCase("Player"))
			return new TitanPlayer(null);
		else
			return null;
	}
}
