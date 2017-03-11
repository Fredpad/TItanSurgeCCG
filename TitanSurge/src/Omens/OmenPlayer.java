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
			this.name = obj.name;
			setCampaign(); 
			
			for(int i = 0; i < handlength; i++){
				this.hand[i] = lib.getOmenscard(obj.hand[i]); 
			}
		}
		
		else if(obj.change().equalsIgnoreCase("field")){
			
			this.fieldlength = obj.fieldlength;
			this.name = obj.name;
			setCampaign();
			
			for(int i = 0; i < fieldlength; i++){
				this.field[i] = lib.getOmenscard(obj.field[i]);
			}
		}
		
		else if(obj.change().equalsIgnoreCase("resources")){
			
			this.name = obj.name;
			setCampaign(); 
			
			this.name = obj.name;
			this.gold = obj.gold;
			this.skulls = obj.skulls;
			this.health = obj.health;
			this.apples = obj.apples;
			this.magic = obj.magic;
		}
		
		else if(obj.change().equalsIgnoreCase("deck")){
			this.name = obj.name;
			setCampaign();
			
			this.decklength = obj.decklength;
			for(int i = 0; i < decklength; i++)
				deck[i] = lib.getOmenscard(obj.deck[i]);
		}
	}

}
