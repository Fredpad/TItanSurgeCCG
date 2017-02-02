
public interface Card {
	
	//METHODS:

	//they are not defined in this interface, that is for the Cardlib class to do in 
	//the nested classes
	public int getAttack();
	
	public int getTimer();
		//when defined, returns the turn_timer value 
	
	public int getHealth();
	//	when defined, returns the health value 
	
	public String getName();
		//when defined, returns the name value 
	
	public void damaged(int n);
		//when defined, reduces health by amount given 
	
	public void ability();
		//can be blank for now 
	
	public void updateTimer();
		//when define, reduces the turn_timer by 1

}
