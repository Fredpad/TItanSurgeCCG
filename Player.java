
public class Player extends Game {

	//FIELDS:
	Player enemy;

	//Strat is needed to pass information about the player and the game to use the 
	//strategies. It is not used at all in this class 
	Strategy strat = new Strategy(this);

	//CONSTRUCTOR	
	Player(){
		readyLib(this);
	}
		
	//METHODS:
	public void setEnemy(Player obj){
		enemy = obj;
	}

	public void newTurn(){
		//calls the methods in this order
		updateCardtimers();
		draw();
	}
		
	private void updateCardtimers(){
		//if there are cards in the hand, it reduces each cards turn_timer by 1 
		//if there are cards in the enemyhand, reduce the turn_timer in the enemy cards by 1
		for (int i = 0; i < getHandlength(); i++){
			hand[i].updateTimer(); 
		}
	}
	
	public void playCard(Card obj){
		placeCard(obj);
	}
	
	public void attack(){
	/*	if there are real cards in the field array, then they will attack
		checks to see if there is an opposing enemy card in front of it
		if so, then the card attacks the enemy card, if not it attacks the enemy directly
		if the card attacks an enemy card, reduce the enemy card health by the attack value
		of the attacking card, then call the deadCard() method to check if the enemycard is destroyed
*/
		for (int i = 0; i < getFieldlength(); i++){
			if (enemy.getFieldcard(i).getName().equals("No card") ){
				enemy.directDamage(field[i].getAttack()); 
			}
			if(!enemy.getFieldcard(i).getName().equals("No card")){
				enemy.getFieldcard(i).damaged(field[i].getAttack()); 
				enemy.deadCard(enemy.getFieldcard(i));
			}
		}
}
