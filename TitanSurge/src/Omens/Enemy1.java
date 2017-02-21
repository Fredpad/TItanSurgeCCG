package Omens;

public class Enemy1 extends Campaign{

	public Enemy1(){
		hand[0] = "Courtesan";
		hand[1] = "coin";
		hand[2] = "coin";
		hand[3] = "coin"; 
		handlength = 4; 
	}
	
	@Override
	public String change(){
		return "hand"; 
	}
}
