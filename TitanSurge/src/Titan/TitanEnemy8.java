package Titan;

public class TitanEnemy8 extends Campaign{

	public TitanEnemy8(String title){
		health = 1;
		field[0] = "Viking Chief";
		field[1] = "Viking Chief";
		hand[0] = "Viking Chief";
		fieldlength = 2;
		handlength = 1;
		decklength = 2;
		name = title;
	}
	public String change(){return "health hand field decklength";}
}
