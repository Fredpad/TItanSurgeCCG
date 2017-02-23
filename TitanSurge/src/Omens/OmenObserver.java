package Omens;
import Common.*;

//CARRIES OUT THE ACTIONS GIVEN BY THE CARDS TO PLAY THE GAME AND ITS MECHANICS
public class OmenObserver implements CardObserver{
	private OmensGame player; 
	
	OmenObserver(OmensGame person){
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
			else if(call.equalsIgnoreCase("buy"))
				player.buycard(key);
		}		
	}

	@Override
	public void update(String command, int position, int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String command, int value, String status, int position) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int get(String command) {
		return 0;
		
	}
	
}
