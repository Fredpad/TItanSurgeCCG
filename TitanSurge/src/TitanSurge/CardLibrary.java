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
	//The abilities of the cards are commented ontop of the class. No need to code the abilities right now since
	//everyone in the team has to code 3 of the abilities, as instructed by the homework 
	//Make sure to have every method from the Card interface within the following classes. 
	//As of right now, the ability method does not have to be defined
	//The other values of the fields in the nested classes are not finalized right now besides name
		
		//Has the ability to heal ally card that took the most damage in the last turn before it attacks 
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
		
		}
		//Randomly damages an enemy card on the field for 50 when played 
		public class Flamewyvern implements Card{
			//FIELDS:
			private int attack = 170;
			private int health = 250;
			private int turn_timer = 4;
			private String name ="Flame Wyvern";
			@Override
			public int getAttack() {
				// TODO Auto-generated method stub
				return attack;
			}
			@Override
			public int getTimer() {
				// TODO Auto-generated method stub
				return turn_timer;
			}
			@Override
			public int getHealth() {
				// TODO Auto-generated method stub
				return health;
			}
			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return name;
			}
			@Override
			public void damaged(int n) {
				// TODO Auto-generated method stub
				health -= n;
			}
			@Override
			public void ability() {
				Random rand = new Random();
				int n = rand.nextInt(one.enemy.getFieldlength()); 
				one.enemy.getFieldcard(n).damaged(50);
				
			}
			@Override
			public void updateTimer() {
				// TODO Auto-generated method stub
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
		}
		
		//90% of damage it does to an enemy card is dealt to the enemy players health 
		public class Lion implements Card{
			//FIELDS:
			private int attack =160;
			private int health= 180;
			private int turn_timer = 2;
			private String name = "Lion";
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
		}

		//Before it attacks, randomly damages an enemy card on the field for 20, and it takes 20 more damage at the end of the next turn 
		public class Spider implements Card{
			//FIELDS:
			private int attack = 110;
			private int health = 180;
			private int turn_timer = 2;
			private String name = "Spider";
			@Override
			public int getAttack() {
				// TODO Auto-generated method stub
				return attack;
			}
			@Override
			public int getTimer() {
				// TODO Auto-generated method stub
				return turn_timer;
			}
			@Override
			public int getHealth() {
				// TODO Auto-generated method stub
				return health;
			}
			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return name;
			}
			@Override
			public void damaged(int n) {
				// TODO Auto-generated method stub
				health -= n;
			}
			@Override
			public void ability() {
				Random ran = new Random();
				int n = ran.nextInt(one.enemy.getFieldlength());
				one.enemy.getFieldcard(n).damaged(20);
				//IMPLEMENT A SECOND POISEN EFFECT DURING NEXT TURN
				
			}
			@Override
			public void updateTimer() {
				// TODO Auto-generated method stub
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
		}
		
		//Reduces damage it takes from a normal attack by 60
		public class Orcsoldier implements Card{
			//FIELDS:
			private int attack = 120;
			private int health = 150;
			private int turn_timer = 2;
			private String name = "Orc Soldier";
			@Override
			public int getAttack() {
				// TODO Auto-generated method stub
				return attack;
			}
			@Override
			public int getTimer() {
				// TODO Auto-generated method stub
				return turn_timer;
			}
			@Override
			public int getHealth() {
				// TODO Auto-generated method stub
				return health;
			}
			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return name;
			}
			@Override
			public void damaged(int n) {
				// TODO Auto-generated method stub
				health -= (60 - n);
			}
			@Override
			public void ability() {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void updateTimer() {
				// TODO Auto-generated method stub
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
		}
		
		public class Swampwolf implements Card{
			//FIELDS:
			private int attack = 130;
			private int health = 150;
			private int turn_timer = 2;
			private String name = "Swamp Wolf";
			@Override
			public int getAttack() {
				// TODO Auto-generated method stub
				return attack;
			}
			@Override
			public int getTimer() {
				// TODO Auto-generated method stub
				return turn_timer;
			}
			@Override
			public int getHealth() {
				// TODO Auto-generated method stub
				return health;
			}
			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return name;
			}
			@Override
			public void damaged(int n) {
				// TODO Auto-generated method stub
				health -= n;
			}
			@Override
			public void ability() {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void updateTimer() {
				// TODO Auto-generated method stub
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
		}
		
		//Before it attacks, damages up to 3 random enemy cards on the field for 30, 35% chance to stun each card hit
		public class Snowoakfairy implements Card{
			//FIELDS:
			private int attack = 90;
			private int health = 180;
			private int turn_timer = 4;
			private String name = "Snow Oak Fiary";
			@Override
			public int getAttack() {
				
				return attack;
			}
			@Override
			public int getTimer() {
				// TODO Auto-generated method stub
				return turn_timer;
			}
			@Override
			public int getHealth() {
				// TODO Auto-generated method stub
				return health;
			}
			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return name;
			}
			@Override
			public void damaged(int n) {
				// TODO Auto-generated method stub
				health -= n;
			}
			@Override
			public void ability() {
				
				
			}
			@Override
			public void updateTimer() {
				// TODO Auto-generated method stub
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
		}
		
		//40% chance to return to hand when killed on the field. To the deck if hand is full
		public class Tundratroll implements Card{
			//FIELDS:
			private int attack = 110;
			private int health = 160;
			private int turn_timer = 2;
			private String name = "Tundra Troll";
			@Override
			public int getAttack() {
				// TODO Auto-generated method stub
				return attack;
			}
			@Override
			public int getTimer() {
				// TODO Auto-generated method stub
				return turn_timer;
			}
			@Override
			public int getHealth() {
				// TODO Auto-generated method stub
				return health;
			}
			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return name;
			}
			@Override
			public void damaged(int n) {
				// TODO Auto-generated method stub
				health -= n;
			}
			@Override
			public void ability() {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void updateTimer() {
				// TODO Auto-generated method stub
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
		}
		
		//heals it self by 20% of the damage it does to the enemy player or enemy card 
		public class Vampirebat implements Card{
			//FIELDS:
			private int attack = 100;
			private int health = 130;
			private int turn_timer = 2;
			private String name = "Vampire Bat";
			@Override
			public int getAttack() {
				// TODO Auto-generated method stub
				return attack;
			}
			@Override
			public int getTimer() {
				// TODO Auto-generated method stub
				return turn_timer;
			}
			@Override
			public int getHealth() {
				// TODO Auto-generated method stub
				return health;
			}
			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return name;
			}
			@Override
			public void damaged(int n) {
				// TODO Auto-generated method stub
				health -= n;
			}
			@Override
			public void ability() {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void updateTimer() {
				// TODO Auto-generated method stub
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
		}
		
		//Heals the player by 250 health before it attacks 
		public class Vikingchief implements Card{
			//FIELDS:
			private int attack = 130;
			private int health = 160;
			private int turn_timer = 2;
			private String name = "Vikingchief";
			
			@Override
			public int getAttack() {
				// TODO Auto-generated method stub
				return attack;
			}
			@Override
			public int getTimer() {
				// TODO Auto-generated method stub
				return turn_timer;
			}
			@Override
			public int getHealth() {
				// TODO Auto-generated method stub
				return health;
			}
			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return name;
			}
			@Override
			public void damaged(int n) {
				// TODO Auto-generated method stub
				health -= n;
			}
			@Override
			public void ability() {
				one.getHealed(100);
				
			}
			@Override
			public void updateTimer() {
				// TODO Auto-generated method stub
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
			
			
		}
		
		//Only 1 field. Every method but getName does nothing or returns 0
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

			
		}
		
	 
}
