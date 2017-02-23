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
}
