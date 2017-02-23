package Titan;
//Player class extending Game class
public class Player extends TitanGame{
	//Constractor
	Player(Campaign obj){
		//Loop to full out the player hand. 
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
