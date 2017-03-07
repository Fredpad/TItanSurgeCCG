package Omens;

public class Enemy2 extends Campaign {
	
	public Enemy2(String title){
		field[0] = "Wealthy Patron"; 
		fieldlength = 1;
		name = title;
	}
	
	@Override
	public String change(){
		return "field";
	}

}
