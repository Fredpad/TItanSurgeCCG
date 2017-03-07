package Omens;

public class Enemy3 extends Campaign{
	
	public Enemy3(String title){
		gold = 5;
		skulls = 2;
		health = 30;
		name = title;
	}
	
	@Override
	public String change(){
		return "resources";
	}
	

}
