package Omens;

public class Enemy2 extends Campaign {
	
	public Enemy2(){
		field[0] = "Wealthy Patron"; 
		fieldlength = 1;
	}
	
	@Override
	public String change(){
		return "field";
	}

}
