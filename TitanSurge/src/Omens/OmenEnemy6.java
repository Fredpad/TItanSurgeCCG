package Omens;

public class OmenEnemy6 extends Campaign{
	
	public OmenEnemy6(String title){
		hand[0] = "Random";
		hand[1]	= "Random";
		handlength = 2;
		name = title;
	}
	
	public String change(){
		return "hand";
	}

}
