package TitanSurge;

import java.util.Random;

class CardLibrary {


	Player one;

		
	public Card dripfairy(){ return new Dripfairy();}
		
	public Card flamewyvern(){ return new Flamewyvern();}
		
	public Card lion(){ return new Lion(); }
		
	public Card spider(){ return new Spider(); }
		
	public Card orcsoldier(){ return new Orcsoldier(); }
		
	public Card swampwolf() { return new Swampwolf(); }
			
	public Card snowoakfairy() { return new Snowoakfairy(); } 
		
	public Card tundratroll() { return new Tundratroll(); } 		
		
	public Card vampirebat() { return new Vampirebat(); } 		
		
	public Card vikingchief() { return new Vikingchief(); }
		
	public Card nocard() { return  new Nocard(); }		
	
	public void readyLib(Player play){this.one = play;}
	
	//NEST CLASSES:
	//The cards with abilities are commented ontop of the class. 
	
	/**
	 * Dripfairy is used in part with an observer class. The observer class, defined in BattleWatcher class
	 * tracks the health, placement, and damage taken by an ally card. The one that has take the most damaged
	 * is then passed to dripfairy. Dripfairy, before it attacks, heals the card it was given by 50.
	 * Observer was chosen because it needs to be aware of changes being done in the game so it can use it's 
	 * feature.
	 * */
		public class Dripfairy implements Card{
			//FIELDS:
			private int attack = 80;
			private int health = 170;
			private int turn_timer = 2; 
			private String name = "Dripfairy";
			private String toHeal = "";
			private Player ref = one; 
			private int poisened = 0;
			
			@Override
			public void setTarget(String name){
				toHeal = name;
			}
			
			public String getTarget(){return toHeal;}
			
			
			@Override
			public int getAttack() {
			
				return attack;
			}
			@Override
			public int getTimer() {
				
				return turn_timer;
			}
			@Override
			public int getHealth() {
				return health;
			}
			@Override
			public String getName() {
			
				return name;
			}
			@Override
			public void damaged(int n) {
				
				health -= n;
			}
			
			@Override
			public void ability() {
				
				for(int i = 0; i < 5; i+=1){
					if(one.getFieldcard(i).getName().equals(toHeal)){
						System.out.println(one.getName() +"'s Dripfairy is Healing: "+toHeal);
						one.getFieldcard(i).getHealed(50);
					}
				}
				
			}
			@Override
			public void updateTimer() {
				turn_timer -= 1;
			}


			@Override
			public void getHealed(int i) {
				health += i;
				
			}
			
			//If poisened, then damaged is taken from the health
			@Override
			public void Poisen() {
				if(poisened > 0){
					health-=30;
					poisened -=1;
					}
			}

			//If newly poisened, sets count for 2 turns, increased by 2
			//if poisend again
			@Override
			public void setPoisened() {
				if(poisened <=0)
					poisened =2;
				else
					poisened +=2;
				
			}
		
		}
		//Randomly damages an enemy card on the field for 50 when played 
		public class Flamewyvern implements Card{
			//FIELDS:
			private int attack = 170;
			private int health = 250;
			private int turn_timer = 4;
			private String name ="Flame Wyvern";
			private int poisened = 0;
			
			@Override
			public int getAttack() {
				return attack;
			}
			@Override
			public int getTimer() {
				return turn_timer;
			}
			@Override
			public int getHealth() {
				return health;
			}
			@Override
			public String getName() {
				return name;
			}
			@Override
			public void damaged(int n) {
				health -= n;
			}
			
			@Override
			public void ability() {
				if(one.enemy.getFieldlength()> 0){
				Random rand = new Random();
				int n = rand.nextInt(one.enemy.getFieldlength()); 
				one.enemy.getFieldcard(n).damaged(50);}
				
			}
			@Override
			public void updateTimer() {
				turn_timer -= 1;
			}
			@Override
			public void setTarget(String cardname) {
				
			}
			@Override
			public void getHealed(int i) {
				health+=i;
				
			}
			@Override
			public String getTarget() {
				return null;
			}
			@Override
			public void Poisen() {
				if(poisened > 0){
					health-=30;
					poisened -=1;
					}
				
			}
			@Override
			public void setPoisened() {
				if(poisened <=0)
					poisened =2;
				else
					poisened +=2;
			}
		}
		
		//reduces damage from a regular attack by 60
		public class Lion implements Card{
			private int attack =160;
			private int health= 180;
			private int turn_timer = 2;
			private String name = "Lion";
			private int poisened = 0;
			
			@Override
			public int getAttack() {
				
				return attack;
			}
			@Override
			public int getTimer() {
				
				return turn_timer;
			}
			@Override
			public int getHealth() {
				
				return health;
			}
			@Override
			public String getName() {
				
				return name;
			}
			@Override
			public void damaged(int n) {
				health+= 60;
				health -= n;
			}
			@Override
			public void ability() {
			
				
			}
			@Override
			public void updateTimer() {
			
				turn_timer -= 1;
			}
			@Override
			public void setTarget(String cardname) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void getHealed(int i) {
				health+=i;
			}
			@Override
			public String getTarget() {
				// TODO Auto-generated method stub
				return null;
			}
			@Override
			public void Poisen() {
				if(poisened > 0){
					health-=30;
					poisened -=1;
					}
				
			}
			@Override
			public void setPoisened() {
				if(poisened <=0)
					poisened =2;
				else
					poisened +=2;
			}
		}

		//Before it attacks, randomly damages an enemy card on the field for 20, 
		//and it takes 20 more damage at the end of the next turn 
		public class Spider implements Card{
			//FIELDS:
			private int attack = 110;
			private int health = 180;
			private int turn_timer = 2;
			private String name = "Spider";
			private int poisened = 0;
			
			@Override
			public int getAttack() {
				return attack;
			}
			@Override
			public int getTimer() {
				return turn_timer;
			}
			@Override
			public int getHealth() {
				return health;
			}
			@Override
			public String getName() {
				return name;
			}
			@Override
			public void damaged(int n) {
				health -= n;
			}
			@Override
			public void ability() {
				if(one.enemy.getFieldlength() > 0){
				Random ran = new Random();
				int n = ran.nextInt(one.enemy.getFieldlength());
				one.addPoisened(one.enemy.getFieldcard(n));}
				
			}
			@Override
			public void updateTimer() {
				turn_timer -= 1;
			}
			@Override
			public void setTarget(String cardname) {
				
			}
			@Override
			public void getHealed(int i) {
				health+=i;
				
			}
			@Override
			public String getTarget() {
				return null;
			}
			@Override
			public void Poisen() {
				if(poisened > 0){
					health-=30;
					poisened -=1;
					}
				
			}
			@Override
			public void setPoisened() {
				if(poisened <=0)
					poisened =2;
				else
					poisened +=2;
			}
		}
		
		public class Orcsoldier implements Card{
			//FIELDS:
			private int attack = 120;
			private int health = 150;
			private int turn_timer = 2;
			private String name = "Orc Soldier";
			private int poisened = 0;
			
			@Override
			public int getAttack() {
				return attack;
			}
			@Override
			public int getTimer() {
				return turn_timer;
			}
			@Override
			public int getHealth() {
				return health;
			}
			@Override
			public String getName() {
				return name;
			}
			@Override
			public void damaged(int n) {
				
				health -= n;
			}
			@Override
			public void ability() {
				
			}
			@Override
			public void updateTimer() {
				turn_timer -= 1;
			}
			@Override
			public void setTarget(String cardname) {
				
			}
			@Override
			public void getHealed(int i) {
				health+=i;
				
			}
			@Override
			public String getTarget() {
				return null;
			}
			@Override
			public void Poisen() {
				if(poisened > 0){
					health-=30;
					poisened -=1;
					}
				
			}
			@Override
			public void setPoisened() {
				if(poisened <=0)
					poisened =2;
				else
					poisened +=2;
			}
		}
		
		public class Swampwolf implements Card{
			//FIELDS:
			private int attack = 130;
			private int health = 150;
			private int turn_timer = 2;
			private String name = "Swamp Wolf";
			private int poisened = 0;
			
			@Override
			public int getAttack() {
				return attack;
			}
			@Override
			public int getTimer() {
				return turn_timer;
			}
			@Override
			public int getHealth() {
				return health;
			}
			@Override
			public String getName() {
				return name;
			}
			@Override
			public void damaged(int n) {
				health -= n;
			}
			@Override
			public void ability() {
				
			}
			@Override
			public void updateTimer() {
				turn_timer -= 1;
			}
			@Override
			public void setTarget(String cardname) {
				
			}
			@Override
			public void getHealed(int i) {
				health+=i;
				
			}
			@Override
			public String getTarget() {
				return null;
			}
			@Override
			public void Poisen() {
				if(poisened > 0){
					health-=30;
					poisened -=1;
					}
				
			}
			@Override
			public void setPoisened() {
				if(poisened <=0)
					poisened =2;
				else
					poisened +=2;
			}
		}
		
		public class Snowoakfairy implements Card{
			//FIELDS:
			private int attack = 90;
			private int health = 180;
			private int turn_timer = 4;
			private String name = "Snow Oak Fiary";
			private int poisened = 0;
			
			@Override
			public int getAttack() {
				
				return attack;
			}
			@Override
			public int getTimer() {
				return turn_timer;
			}
			@Override
			public int getHealth() {
				return health;
			}
			@Override
			public String getName() {
				return name;
			}
			@Override
			public void damaged(int n) {
				health -= n;
			}
			@Override
			public void ability() {
				
				
			}
			@Override
			public void updateTimer() {
				turn_timer -= 1;
			}
			@Override
			public void setTarget(String cardname) {
				
			}
			@Override
			public void getHealed(int i) {
				health+=i;
				
			}
			@Override
			public String getTarget() {
				return null;
			}
			@Override
			public void Poisen() {
				if(poisened > 0){
					health-=30;
					poisened -=1;
					}
				
			}
			@Override
			public void setPoisened() {
				if(poisened <=0)
					poisened =2;
				else
					poisened +=2;
			}
		}
		
		public class Tundratroll implements Card{
			//FIELDS:
			private int attack = 110;
			private int health = 160;
			private int turn_timer = 2;
			private String name = "Tundra Troll";
			private int poisened = 0;
			
			@Override
			public int getAttack() {
				return attack;
			}
			@Override
			public int getTimer() {
				return turn_timer;
			}
			@Override
			public int getHealth() {
				return health;
			}
			@Override
			public String getName() {
				return name;
			}
			@Override
			public void damaged(int n) {
				health -= n;
			}
			@Override
			public void ability() {
				
			}
			@Override
			public void updateTimer() {
				turn_timer -= 1;
			}
			@Override
			public void setTarget(String cardname) {
				
			}
			@Override
			public void getHealed(int i) {
				health+=i;
			}
			@Override
			public String getTarget() {
				return null;
			}
			@Override
			public void Poisen() {
				if(poisened > 0){
					health-=30;
					poisened -=1;
					}
				
			}
			@Override
			public void setPoisened() {
				if(poisened <=0)
					poisened =2;
				else
					poisened +=2;
			}
		}
		
		public class Vampirebat implements Card{
			//FIELDS:
			private int attack = 100;
			private int health = 130;
			private int turn_timer = 2;
			private String name = "Vampire Bat";
			private int poisened = 0;
			
			@Override
			public int getAttack() {
				return attack;
			}
			@Override
			public int getTimer() {
				return turn_timer;
			}
			@Override
			public int getHealth() {
				return health;
			}
			@Override
			public String getName() {
				return name;
			}
			@Override
			public void damaged(int n) {
				health -= n;
			}
			@Override
			public void ability() {
				
			}
			@Override
			public void updateTimer() {
				turn_timer -= 1;
			}
			@Override
			public void setTarget(String cardname) {
				
			}
			@Override
			public void getHealed(int i) {
				health+=i;
			}
			@Override
			public String getTarget() {
				return null;
			}
			@Override
			public void Poisen() {
				if(poisened > 0){
					health-=30;
					poisened -=1;
					}
				
			}
			@Override
			public void setPoisened() {
				if(poisened <=0)
					poisened =2;
				else
					poisened +=2;
			}
		}
		
		//Heals the player by 250 health before it attacks 
		public class Vikingchief implements Card{
			//FIELDS:
			private int attack = 130;
			private int health = 160;
			private int turn_timer = 2;
			private String name = "Vikingchief";
			private int poisened = 0;

			
			@Override
			public int getAttack() {
				return attack;
			}
			@Override
			public int getTimer() {
				return turn_timer;
			}
			@Override
			public int getHealth() {
				return health;
			}
			@Override
			public String getName() {
				return name;
			}
			@Override
			public void damaged(int n) {
				health -= n;
			}
			@Override
			public void ability() {
				one.getHealed(100);
				
			}
			@Override
			public void updateTimer() {
				turn_timer -= 1;
			}
			@Override
			public void setTarget(String cardname) {
				
			}
			@Override
			public void getHealed(int i) {
				health+=i;
			}
			@Override
			public String getTarget() {
				return null;
			}
			@Override
			public void Poisen() {
				if(poisened > 0){
					health-=30;
					poisened -=1;
					}
				
			}
			
			@Override
			public void setPoisened() {
				if(poisened <=0)
					poisened =2;
				else
					poisened +=2;
			}
			
			
		}
		
		//The dummy card class used to fill the arrays to prevent a 
		//null pointer exception
		public class Nocard implements Card{
			//FIELDS:
			private String name = "No card";

			@Override
			public int getAttack() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public int getTimer() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public int getHealth() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return name;
			}

			@Override
			public void damaged(int n) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void ability() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void updateTimer() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void setTarget(String cardname) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void getHealed(int i) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public String getTarget() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void Poisen() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void setPoisened() {
				// TODO Auto-generated method stub
				
			}

			
		}
		
	 
}
