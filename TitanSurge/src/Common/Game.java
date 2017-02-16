package Common;

public abstract class Game {
	int decksize, handsize, fieldsize, health;
	int handlength = 0, fieldlength = 0, decklength = 0;
	Card[] deck;
	Card[] field; 
	Card[] hand;
	Cardlib lib;

	
	public abstract void deadcard(String name);
	public abstract void setfield();
	public abstract void setdeck();
	public abstract void sethand();
	
	///////////////////////////////
	public void draw(){ 
		deck[0] = hand[handlength];
		decklength --;
		handlength++;
	
	}
	public void playcard(String name){
		for (int i=0; i < handlength; i++){
			if (hand[i].getName().equal(Name)){
				field[fieldlength] = hand[i];
				hand[i] = lib.getnocard();
				field++;
			}
		}
	
	adjusthand();
	}
	public void adjusthand(){
		for (int i = 0; i < handlength; i++){
			if (hand[i].getName().equal("no card")){
				hand[i] = hand[handlength-1];
				handlength--;
			}
		}
	} 
		
	public int gethandlength(){
		return handlength;
	}
	
	public int getfieldlength(){
		return fieldlength;
	}
	
	public int getdecklength() {
		return decklength;
			}
	
	
	public int adjustfield(){
		for (int i = 0; i < fieldlength; i++){
			if (field[i].getName().equal("no card")){
				for (int j = i; j < fieldlength; j++){
					if (j == fieldsize-1)
						break; 
					field[j]= field[j+1];
					
				}
			}
		}
	}
	
		
	public void damaged(int n){
		health -= n;
	} 
	
	public void healed(int n){
		health += n;
	}
 
}
