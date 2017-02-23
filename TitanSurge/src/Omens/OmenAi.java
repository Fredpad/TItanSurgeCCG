package Omens;

public class OmenAi extends OmensGame{
	public OmenAi(){
		name = "Ai";
	}
	public void playTurn(){
		strat.Attackstrategy();
	}
		
}
