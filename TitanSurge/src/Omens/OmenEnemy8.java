package Omens;

public class OmenEnemy8 extends Campaign	{

	public OmenEnemy8(String title){
		decklength = 10;
		for(int i = 0; i < decklength; i++)
			deck[i] = "Serf";
		name = title;
	}
	
	public String change(){
		return "deck";
	}
}
