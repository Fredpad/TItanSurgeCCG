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
	
	//a factory method to generate and return campaign classes for Omen
	public static OmenPlayer getOmen(String choice){
		if(choice.equalsIgnoreCase("Campaign 1"))
			return new OmenPlayer(new OmenEnemy1("Campaign 1")); 
		
		else if(choice.equalsIgnoreCase("Campaign 2"))
			return new OmenPlayer(new OmenEnemy2("Campaign 2"));
		
		else if(choice.equalsIgnoreCase("Campaign 3"))
			return new OmenPlayer(new OmenEnemy3("Campaign 3"));
		
		else if(choice.equalsIgnoreCase("Campaign 4"))
			return new OmenPlayer(new OmenEnemy4("Campaign 4"));
		
		else if(choice.equalsIgnoreCase("Campaign 5"))
			return new OmenPlayer(new OmenEnemy5("Campaign 5"));
		
		else if(choice.equalsIgnoreCase("Campaign 5"))
			return new OmenPlayer(new OmenEnemy5("Campaign 5"));
		
		else if(choice.equalsIgnoreCase("Campaign 6"))
			return new OmenPlayer(new OmenEnemy6("Campaign 6"));
		
		else if(choice.equalsIgnoreCase("Campaign 7"))
			return new OmenPlayer(new OmenEnemy7("Campaign 7"));
		
		else if(choice.equalsIgnoreCase("Campaign 8"))
			return new OmenPlayer(new OmenEnemy8("Campaign 8"));
		
		else if(choice.equals("Player"))
			return new OmenPlayer(null);
		else
			return null;
	}
	
	//A factory class used to generate campaign classes
	public static TitanPlayer getTitan(String choice){
		if(choice.equalsIgnoreCase("Campaign 1"))
			return new TitanPlayer(new TitanEnemy1("Campaign 1"));
		
		if(choice.equalsIgnoreCase("Campaign 2"))
			return new TitanPlayer(new TitanEnemy1("Campaign 2"));
		
		if(choice.equalsIgnoreCase("Campaign 3"))
			return new TitanPlayer(new TitanEnemy1("Campaign 3"));

		else if(choice.equalsIgnoreCase("Campaign 4"))
			return new TitanPlayer(new TitanEnemy4("Campaign 4"));
		
		else if(choice.equalsIgnoreCase("Campaign 5"))
			return new TitanPlayer(new TitanEnemy5("Campaign 5"));
		
		else if(choice.equalsIgnoreCase("Campaign 5"))
			return new TitanPlayer(new TitanEnemy5("Campaign 5"));
		
		else if(choice.equalsIgnoreCase("Campaign 6"))
			return new TitanPlayer(new TitanEnemy6("Campaign 6"));
		
		else if(choice.equalsIgnoreCase("Campaign 7"))
			return new TitanPlayer(new TitanEnemy7("Campaign 7"));
		
		else if(choice.equalsIgnoreCase("Campaign 8"))
			return new TitanPlayer(new TitanEnemy8("Campaign 8"));
		
		if(choice.equalsIgnoreCase("Player"))
			return new TitanPlayer(null);
		else
			return null;
	}
}
