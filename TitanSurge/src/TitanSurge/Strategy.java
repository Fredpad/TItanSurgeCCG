package TitanSurge;

public class Strategy {
	Player one;
	String setStrategy;
	
	Strategy(Player obj){this.one = obj;}
	
	public void setStrategy(String word){setStrategy = word;}
	
	//performs the selected strategy
	public void playStrategy(){
		if(setStrategy.equalsIgnoreCase("Brute Force"))
			Bruteforce();
		if(setStrategy.equalsIgnoreCase("Wall"))
			Wall();
	}
	
	//this method will look for all playable cards in hand
	//and play the ones with the largest attack first
	//until all playable cards from hand are played 
	//or the field array is full
	public void Bruteforce(){
		for(int i = 0; i <one.getHandlength(); i +=1){
			if(one.getHandcard(i).getTimer() <= 0){
				one.placeCard(one.getHandcard(i));
				i = -1;
			}
		}
	}
	
	//this method will want to play the cards with the biggest health first
	//willing to take some hits to protect playing cards with less health
	//in the hand. If Enemy has a 3 card advantage, then start playing cards. 
	public void Wall(){
		
		//while enemy only has 1 more card than u on field
		if(enemyTotalAttack() < one.getHealth() && fieldDifference() < 2){
			if(cardsReady() >= 2){
				playingWallStrat();
			}
		}
		//if enemy can win it next turn
		else if(enemyTotalAttack() > one.getHealth())
			playingWallStrat();
		//if enemy has 2 or more cards than u on field
		else if(fieldDifference() >= 2)
			playingWallStrat();
	}
	
	//plays cards with biggest health first
	private void playingWallStrat(){
		int biggest = 0;
		int loops = cardsReady();
		
		for(int l = 0; l < loops; l+=1){
		for(int i = 0; i < one.getHandlength(); i +=1){
			if(one.getHandcard(biggest).getTimer() <= 0){
				if(one.getHandcard(biggest).getHealth() < one.getHandcard(i+1).getHealth())
					biggest = i + 1;}
		}
		one.placeCard(one.getHandcard(biggest));
	}}
	
	//if the enemy has enough attack power on the field to win the game, plays
	//all possible cards in hand
	public int enemyTotalAttack(){
		int total = 0;
		for(int i =0, j = one.enemy.getFieldlength(); i < j; i +=1){
			total += one.enemy.getFieldcard(i).getAttack();
		}
		
		return total;
	}
	
	//returns number of cards playable in the players hand
	public int cardsReady(){
		int total = 0;
		for(int i = 0; i <one.getHandlength(); i +=1){
			if(one.getHandcard(i).getTimer() <= 0)
				total +=1;
		}
		return total;
	}
	
	//calculated the difference of cards between the two players
	private int fieldDifference(){
		return one.enemy.getFieldlength() - one.getFieldlength();
	}
}
