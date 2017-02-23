package Titan;

import Common.CardObserver;

public class TitanObserver implements CardObserver {
	private TitanGame player;
	
	public TitanObserver(TitanGame person){
		this.player = person;
	}
	
	public void update(String command, int value){
		if(command.equalsIgnoreCase("heal player"))
			player.healed(value);
	}
	public void update(String command, String key){
		if(command.equalsIgnoreCase("dead"))
			player.deadcard(key);
		else if(command.equalsIgnoreCase("play"))
			player.playcard(key);
	}
	
	public void update(String command,int position, int value){
		if(command.equalsIgnoreCase("attack")){
			player.attackEnemy(position, value);
		}
	}
	
	public void update(String command, int value, String status, int position){
		if(command.equalsIgnoreCase("damage")){
			if(status == null){
				player.enemy.getFieldcard(position).abilityDamage(value);
			}
			else
			{
				player.enemy.getFieldcard(position).abilityDamage(value);
				player.enemy.getFieldcard(position).inflictedStatus(status);
			}
		}
	}

	public int get(String value){
		if(value.equalsIgnoreCase("Fieldlength"))
		{return player.enemy.getfieldlength(); 
			}
		else
			return 0;
	}

	@Override
	public void update(String command) {
		// TODO Auto-generated method stub
		
	}
}
/**	
 * double d = Math.random() * 100 
 * if(d <=35)  
 * */
 