package Titan;

public class TitanEnemy4 extends Campaign{

	public TitanEnemy4(String title){
		hand[0] = "Flame Wyvern";
		hand[1] = "Tundra Troll";
		handlength  = 2;
		decklength = 1;
		name = title;
	}
	public String change(){return "hand decklength";}

}
