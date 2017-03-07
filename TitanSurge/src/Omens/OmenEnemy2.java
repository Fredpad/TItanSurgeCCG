package Omens;

public class OmenEnemy2 extends Campaign {
	
	public OmenEnemy2(String title){
		field[0] = "Wealthy Patron"; 
		fieldlength = 1;
		name = title;
	}
	
	@Override
	public String change(){
		return "field";
	}

}
