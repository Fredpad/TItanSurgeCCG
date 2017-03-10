package Omens;

public class OmenEnemy4 extends Campaign{
	
	public OmenEnemy4(String title){
		name = title;
		
		field[0] = "Courtesan";
		fieldlength = 1;
	}

	public String change(){
		return "field";
	}
}
