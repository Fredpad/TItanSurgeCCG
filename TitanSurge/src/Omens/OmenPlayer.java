package Omens;

//made to alter a player to be a campaign opponent.
public class OmenPlayer extends OmensGame{
	
	//The constructor will make the object mirror itself to the given
	//campaign class in it's fields and methods
	public OmenPlayer(Campaign obj){
		if(obj == null){}
			
		else if(obj.change().equalsIgnoreCase("hand"))
		{
			this.handlength = obj.handlength;
			
			for(int i = 0; i < handlength; i++){
				this.hand[i] = lib.getOmenscard(obj.hand[i]); 
			}
		}
		
		else if(obj.change().equalsIgnoreCase("field")){
			this.fieldlength = obj.fieldlength;
			
			for(int i = 0; i < fieldlength; i++){
				this.field[i] = lib.getOmenscard(obj.field[i]);
			}
		}
		
		else if(obj.change().equalsIgnoreCase("resources")){
			this.gold = obj.gold;
			this.skulls = obj.skulls;
			this.health = obj.health;
			this.apples = obj.apples;
			this.magic = obj.magic;
		}
	}
	
	public void setEnemy(OmensGame them){
		this.enemy = them;
	}
}
