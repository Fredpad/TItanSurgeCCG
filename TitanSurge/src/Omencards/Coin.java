package Omencards;

import Omens.CardObserver;
import Omens.Omenscard;

public class Coin implements Omenscard{
	String name = "Coin";
	CardObserver obs;
	static int count = 1; 
	String key = String.valueOf(count)+ "C";
	
	public Coin(CardObserver observer){
		this.obs = observer;
		count +=1;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getHealth() {
		return 0;
	}

	public void damaged() {	
	}

	@Override
	public void getOnturn() {	
	}

	@Override
	public int getCost() {
		return 0;
	}

	@Override
	public boolean canIntercept() {
		return false;
	}

	@Override
	public void onplay() {
		obs.update("gold", 1);
		obs.update("deck", key);
		
	}

	@Override
	public String getkey() {
		return key	;
	}
	@Override
	public void consumeApples() {}
	
	@Override
	public void consumeMagic() {}

	@Override
	public boolean canconsume() {
		return false;
	}

}
