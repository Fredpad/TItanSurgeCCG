package Titan;

public class TitanObserver {
	private TitanGame player;
	
	public TitanObserver(TitanGame person){
		this.player = person;
	}
	
	public void update(String command, String key){
		if(command.equals("dead"))
			player.deadcard(key);
	}
	
	public void update(String command,int position, int value){
		if(command.equalsIgnoreCase("attack")){
			//player.attackEnemy(position, value);
		}
	}
	
	public void update(String command, int value, String status, int position){
		if(command.equals("damage")){
			if(status == null){
				player.enemy.getFieldcard(position).damaged(30);
			}
			else
			{
				player.enemy.getFieldcard(position).abilityDamage(30);
				player.enemy.getFieldcard(position).inflictedStatus(status);
			}
		}
	}
	
	public int get(String value){
		if(value.equalsIgnoreCase("Fieldlength"))
			return player.enemy.getFieldlength(); 
		else
			return 0;
	}
}
/**
 * double d = Math.random() * 100 
 * if(d <=35)  
 * */
 