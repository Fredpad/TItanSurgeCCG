package Omens;

public class OmenEnemy7 extends Campaign{
	
	public OmenEnemy7(String title){
		field[0] = "Militia";
		field[1] = "Militia";
		fieldlength = 2;
		name = title;
	}
	
	public String change(){
		return "field";
	}

}
