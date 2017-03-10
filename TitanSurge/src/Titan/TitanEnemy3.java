package Titan;

public class TitanEnemy3 extends Campaign {
	TitanEnemy3(String title){
		hand[0] = "Tundra Troll";
		handlength  =1;
		decklength = 9;
		name = title;
	}
	public String change(){return "hand decklength";}
}
