package Omens;

public class OmenEnemy5 extends Campaign{

	public OmenEnemy5(String title){
		hand[0] = "collect taxes";
		hand[1] = "collect taxes";
		handlength = 2;
		name = title;
	}
	
	public String change(){
		return "hand";
	}
}
