package Omens;

public class OmenEnemy1 extends Campaign{

	public OmenEnemy1(String title){
		hand[0] = "Courtesan";
		hand[1] = "coin";
		hand[2] = "coin";
		hand[3] = "coin"; 
		handlength = 4; 
		name = title;
	}
	
	@Override
	public String change(){
		return "hand"; 
	}
}
