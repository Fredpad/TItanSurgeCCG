package Common;

public abstract class Game {
	protected int decksize, handsize, fieldsize;
	protected int health;
	protected int handlength = 0;
	protected int fieldlength = 0;
	protected int decklength = 0;
	protected Cardlib lib;

	
	public abstract void deadcard(String name);
	public abstract void setfield();
	public abstract void setdeck();
	public abstract void sethand();
	public abstract void adjustfield();
	public abstract void draw();
	public abstract void playcard(String name);
	public abstract void adjusthand();
	public abstract void damaged(int n); 
	
	///////////////////////////////
	
		
	public int gethandlength(){
		return handlength;
	}
	
	public int getfieldlength(){
		return fieldlength;
	}
	
	public int getdecklength() {
		return decklength;}	
	
	public void healed(int n){
		health += n;
	}
 
}
