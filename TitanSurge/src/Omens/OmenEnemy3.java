package Omens;

public class OmenEnemy3 extends Campaign{
	
	public OmenEnemy3(String title){
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
