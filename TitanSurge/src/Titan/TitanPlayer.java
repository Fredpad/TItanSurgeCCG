package Titan;

public class TitanPlayer extends TitanGame{
	
	TitanPlayer(Campaign obj){
		
		if(obj.change().equalsIgnoreCase("hand")){
			handlength = obj.handlength;
			for(int i = 0; i < handlength; i++){
				this.hand[i] = lib.getTitancard(obj.hand[i]);
			}
		}
		
		else if(obj.change().equalsIgnoreCase("health")){
			health = obj.health;
		}
		
	}

}
