package Titan;

public class TitanEnemy7 extends Campaign{


	public TitanEnemy7(String title){
		hand[0] = "Vampire Bat";
		hand[1] = "Spider";
		handlength  = 2;
		decklength = 1;
		name = title;
	}
	public String change(){return "hand decklength";}
}
