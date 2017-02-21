package Omencards;

import Omens.Omenscard;

public class Nocard implements Omenscard {
	String name = "No card";
	int count = 1;
	String key = String.valueOf(count) + "NC";

	public Nocard(){count +=1;}
	
	public void buy(){}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getHealth() {
		return 0;
	}

	@Override
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
	public void consumeApples() {}
	
	@Override
	public void consumeMagic() {}
	
	@Override
	public boolean canconsume() {
		return false;
	}

	@Override
	public void onplay() {
		
	}

	@Override
	public String getkey() {
		return key;
	}

}
