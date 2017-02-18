package Omens;

public class CardObserver {
	private OmensGame player; 
	
	CardObserver(OmensGame person){
		this.player = person;
	}
	
	public void update(String call){
		if(call != null){
			if(call.equalsIgnoreCase("draw"))
				player.draw();
			else if(call.equalsIgnoreCase("minion attack"))
				player.minionAttack();
		}
	}
	
	public void update(String call, int num){
		if(call != null){
			if(call.equalsIgnoreCase("gold"))
				player.gainGold(num);
			else if(call.equalsIgnoreCase("apples"))
				player.gainApples(num);
			else if(call.equalsIgnoreCase("skulls"))
				player.gainSkulls(num);
			else if(call.equalsIgnoreCase("magic"))
				player.gainMagic(num);
			else if(call.equalsIgnoreCase("lose apples"))
				player.loseApples(num);
			else if(call.equalsIgnoreCase("lose magic"))
				player.loseMagic(num);
		}
		
	}
	
	public void update(String call, String key){
		if(call != null){
			if(call.equalsIgnoreCase("dead"))
				player.deadcard(key);
			else if(call.equalsIgnoreCase("deck"))
				player.todeck(key);
			else if(call.equalsIgnoreCase("play"))
				player.playcard(key);
		}		
	}
	
}
