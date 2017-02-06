package TitanSurge;

//Used to watch and record the cards on the board to find 
//which one took the most damage to get healed by Dripfairy
public class BattleWatch implements Subject{
	Player one;
	private Observer watch;
	private int namelen = 0;
	private int[] damaged = new int[5];
	private int[] previousHealth = new int[5]; 
	private String[] cardNames = new String[5];
	
	BattleWatch(Player player){
		one = player;
		for(int i = 0; i < 5; i +=1){
			damaged[i] = 0;
		}
	}
	
	//references the player it belongs to
	public void setPlayer(Player player){one = player;}
	
	public void setObservers(Observer obs){watch = obs;}
	
	//used for testing and debugging
	public void print(){
		for(int i = 0; i < one.getFieldlength(); i+=1){
			System.out.println(cardNames[i] + " Damaged= " + damaged[i]);
			System.out.println("Health= " + previousHealth[i]);
		}
		
		System.out.println();
	}
	
	//records the conditions of the cards before they get damaged
	public void recordConditions(){
		
		
		for(int i = 0; i < 5; i+=1){
			if(one.getFieldcard(i).getName().equals("No card")==false){
				previousHealth[i] = one.getFieldcard(i).getHealth();}
		}
		
		for(int i = 0; i < 5; i+=1){
			if(one.getFieldcard(i).getName().equals("No card")==false){
			cardNames[i] = one.getFieldcard(i).getName();}
		}
		
	}
	
	//calculates all damage and changes to teh cards and gives the one that recieved
	//the most damaged to dripfairy
	public void hasChanged(){
		for(int i = 0; i< one.getFieldlength(); i+=1){
			if(one.getFieldcard(i).getName().equals(cardNames[i])==false){
				for(int j = i; j < namelen; j+=1){
					if(cardNames[j].equals(one.getFieldcard(i).getName())==true){
						damaged[i] = damaged[j];
						cardNames[i] = cardNames[j];
						previousHealth[i] = previousHealth[j];
					
					}
				}
			}
			
			} 
		
		
		for(int i = 0; i < one.getFieldlength(); i+=1){
			damaged[i] = previousHealth[i] - one.getFieldcard(i).getHealth();
			previousHealth[i] = one.getFieldcard(i).getHealth();
		}
		
		notifyObservers();}
	
	
	//passes on the card that needs healing to dripfairy
	public void notifyObservers(){
		int toheal = 0;
		
		for(int i = 0; i < one.getFieldlength(); i+=1){
			if(damaged[i] > toheal)
				toheal = i; 
		}
		String name = cardNames[toheal];
		
		for(int i = 0; i < 5; i+=1){
			if(one.getFieldcard(i).getName().equals("Dripfairy")){
				one.getFieldcard(i).setTarget(name);}
			
	}}

	@Override
	public void removeObservers(Observer obs) {}
	
	//resets the lists 
	@Override
	public void clearChanged() {
		for(int i = 0; i < 5; i +=1){
			damaged[i] = 0;
		}
		
		for(int i = 0; i < 5; i+=1){
			previousHealth[i] = 0;
		}
		
	}
}
