package Titan;

public class TitanEnemy5 extends Campaign{

	public TitanEnemy5(String title){
		hand[0] = "Flame Wyvern";
		field[0] = "Vampire Bat";
		handlength  = 1;
		fieldlength = 1;
		decklength = 1;
		name = title;
	}
	public String change(){return "hand field decklength";}

}
