package Titan;

public class TitanEnemy1 extends Campaign {

	public TitanEnemy1(String title){
		hand[0] = "Spider"; 
		handlength = 1;
		decklength = 9;
		name = title;
	}
	
	public String change(){return "hand decklength";} 
}
