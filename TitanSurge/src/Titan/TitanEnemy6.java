package Titan;

public class TitanEnemy6 extends Campaign{
	

	public TitanEnemy6(String title){
		
		hand[0] = "Swamp Wolf";
		hand[1] = "Orc Soldier";
		handlength = 2;
		decklength = 1;
		name = title;
	}
	public String change(){return "hand decklength";}

}
