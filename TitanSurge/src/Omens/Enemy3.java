package Omens;

public class Enemy3 extends Campaign{
	
	public Enemy3(){
		gold = 5;
		skulls = 2;
		health = 30;
	}
	
	@Override
	public String change(){
		return "resources";
	}
	

}
