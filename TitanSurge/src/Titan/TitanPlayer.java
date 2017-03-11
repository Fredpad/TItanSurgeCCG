package Titan;

public class TitanPlayer extends TitanGame{
	
	
	//The constructor takes in a child of the Campaign class with different
	//data sets that has it's start different from normal to give a bit of a challenge
	//for the campaign. If it is passed to the constructor, it will read the change() method
	//so it knows what changes to make. If null, then it just becomes a player class representing
	//a real player with input 
	public TitanPlayer(Campaign obj){
		 if(obj == null){
				
			}
		 else if(obj.change().equalsIgnoreCase("hand")){
			 
			setCampaign();
			handlength = obj.handlength;
			this.name = obj.name;
			for(int i = 0; i < handlength; i++){
				this.hand[i] = lib.getTitancard(obj.hand[i]);
			}
		}
		
		else if(obj.change().equalsIgnoreCase("health")){
			
			setCampaign();
			health = obj.health;
			this.name = obj.name;
		}
		 
		else if(obj.change().equalsIgnoreCase("hand decklength")){
			
			setCampaign();
			this.handlength = obj.handlength;
			this.name = obj.name;
			this.decklength = obj.decklength;
			for(int i = 0; i < handlength; i++){
				this.hand[i] = lib.getTitancard(obj.hand[i]);
			}
		}
		else if(obj.change().equalsIgnoreCase("hand field decklength")){
			
			setCampaign();
			this.decklength = obj.decklength;
			this.handlength = obj.handlength;
			this.fieldlength = obj.fieldlength;
			
			for(int i = 0; i < handlength; i++){
				this.hand[i] = lib.getTitancard(obj.hand[i]);
			}
			
			for(int i = 0; i < fieldlength; i++){
				this.field[i] = lib.getTitancard(obj.field[i]);
			}
		}
		 
		else if(obj.change().equalsIgnoreCase("health hand field decklength")){
			
			setCampaign();
			this.health = obj.health;
			this.handlength = obj.handlength;
			this.fieldlength = obj.fieldlength;
			this.decklength = obj.decklength;
			
			for(int i = 0; i < handlength; i++){
				this.hand[i] = lib.getTitancard(obj.hand[i]);
			}
			
			for(int i = 0; i < fieldlength; i++){
				this.field[i] = lib.getTitancard(obj.field[i]);
			}
			
		}
		
	}


}
