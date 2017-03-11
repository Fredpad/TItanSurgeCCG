package Omens;

//A silly final battle where the entire deck is a single, weak card
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
