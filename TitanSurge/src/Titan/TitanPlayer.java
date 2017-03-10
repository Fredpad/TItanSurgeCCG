package Titan;

public class TitanPlayer extends TitanGame{
	
	public TitanPlayer(Campaign obj){
		 if(obj == null){
				
			}
		 else if(obj.change().equalsIgnoreCase("hand")){
			handlength = obj.handlength;
			this.name = obj.name;
			for(int i = 0; i < handlength; i++){
				this.hand[i] = lib.getTitancard(obj.hand[i]);
			}
		}
		
		else if(obj.change().equalsIgnoreCase("health")){
			health = obj.health;
			this.name = obj.name;
		}
		 
		else if(obj.change().equalsIgnoreCase("hand decklength")){
			this.handlength = obj.handlength;
			this.name = obj.name;
			this.decklength = obj.decklength;
			for(int i = 0; i < handlength; i++){
				this.hand[i] = lib.getTitancard(obj.hand[i]);
			}
		}
		else if(obj.change().equalsIgnoreCase("hand field decklength")){
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
