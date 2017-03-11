package Omens;

//WAS used as a placement of the campaign for the previous assignment.
//decided to keep it since it's already in the code
public class OmenAi extends OmensGame{
	public OmenAi(){
		name = "Ai";
	}
	public void playTurn(){
		strat.Attackstrategy();
	}
		
}
