package TitanSurge;

public class Strategy {
	Player one;
	
	
	Strategy(Player obj){this.one = obj;}
	
	//this method will look for all playable cards in hand
	//and play the ones with the largest attack first
	//until all playable cards from hand are played 
	//or the field array is full
	public void Bruteforce(){
		for(int i = 0, j = one.getHandlength(); i <j; i +=1){
			if(one.getHandcard(i).getTimer() <= 0){
				one.placeCard(one.getHandcard(i));
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
		else if(one.enemy.getFieldlength() >= 2)
			playingWallStrat();
	}
	
	//plays cards with biggest health first
	private void playingWallStrat(){
		int biggest = 0;
		for(int i = 0; i < one.getHandlength() - 1; i +=1){
			if(one.getHandcard(biggest).getHealth() < one.getHandcard(i+1).getHealth())
				biggest = i + 1;
			if(i == one.getHandlength() - 1){
				one.placeCard(one.getHandcard(biggest));
				i = 0;
			}
		}
	}
	
	public int enemyTotalAttack(){
		int total = 0;
		for(int i =0, j = one.enemy.getFieldlength(); i < j; i +=1){
			total += one.enemy.getFieldcard(i).getAttack();
		}
		
		return total;
	}
	
	public int cardsReady(){
		int total = 0;
		for(int i = 0; i <one.getHandlength(); i +=1){
			if(one.getHandcard(i).getTimer() <= 0)
				total +=1;
		}
		return total;
	}
	
	private int fieldDifference(){
		return one.enemy.getFieldlength() - one.getFieldlength();
	}
	//creates the array of playable cards from hand, with it's length
	//determined by the getPlayableamount(), then returns that array
	private Card[] getPlayablecards(){

		Card[] card = new Card[cardsReady()];
		int length = 0;
		for(int i = 0, j = one.getHandlength();i < j; i +=1){
			if(one.getHandcard(i).getTimer() == 0) 
				{card[length] = one.getHandcard(i); length +=1;}
		}
		
		return card;
	}
}
