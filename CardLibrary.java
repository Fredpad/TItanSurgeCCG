class CardLibrary {

	//FIELDS:

	//METHODS: 
		
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
	
	//NEST CLASSES:
	//The abilities of the cards are commented ontop of the class. No need to code the abilities right now since
	//everyone in the team has to code 3 of the abilities, as instructed by the homework 
	//Make sure to have every method from the Card interface within the following classes. 
	//As of right now, the ability method does not have to be defined
	//The other values of the fields in the nested classes are not finalized right now besides name
		
		//Has the ability to heal ally card that took the most damage in the last turn before it attacks 
		public class Dripfairy implements Card{
			//FIELDS:
			private int attack;
			private int health;
			private int turn_timer; 
			private String name = "Dripfairy";
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
		
		}
		//Randomly damages an enemy card on the field for 50 before it attacks 
		public class Flamewyvern implements Card{
			//FIELDS:
			private int attack;
			private int health;
			private int turn_timer;
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
				// TODO Auto-generated method stub
				
			}
			@Override
			public void updateTimer() {
				// TODO Auto-generated method stub
				turn_timer -= 1;
			}
		}
		
		//90% of damage it does to an enemy card is dealt to the enemy players health 
		public class Lion implements Card{
			//FIELDS:
			private int attack;
			private int health;
			private int turn_timer;
			private String name = "Lion";
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
		}

		//Before it attacks, randomly damages an enemy card on the field for 20, and it takes 20 more damage at the end of the next turn 
		public class Spider implements Card{
			//FIELDS:
			private int attack;
			private int health;
			private int turn_timer;
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
				// TODO Auto-generated method stub
				
			}
			@Override
			public void updateTimer() {
				// TODO Auto-generated method stub
				turn_timer -= 1;
			}
		}
		
		//Reduces damage it takes from a normal attack by 60
		public class Orcsoldier implements Card{
			//FIELDS:
			private int attack;
			private int health;
			private int turn_timer;
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
		}
		
		public class Swampwolf implements Card{
			//FIELDS:
			private int attack;
			private int health;
			private int turn_timer;
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
		}
		
		//Before it attacks, damages up to 3 random enemy cards on the field for 30, 35% chance to stun each card hit
		public class Snowoakfairy implements Card{
			//FIELDS:
			private int attack;
			private int health;
			private int turn_timer;
			private String name = "Snow Oak Fiary";
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
		}
		
		//40% chance to return to hand when killed on the field. To the deck if hand is full
		public class Tundratroll implements Card{
			//FIELDS:
			private int attack;
			private int health;
			private int turn_timer;
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
		}
		
		//heals it self by 20% of the damage it does to the enemy player or enemy card 
		public class Vampirebat implements Card{
			//FIELDS:
			private int attack;
			private int health;
			private int turn_timer;
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
		}
		
		//Heals the player by 250 health before it attacks 
		public class Vikingchief implements Card{
			//FIELDS:
			private int attack;
			private int health;
			private int turn_timer;
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
				// TODO Auto-generated method stub
				
			}
			@Override
			public void updateTimer() {
				// TODO Auto-generated method stub
				turn_timer -= 1;
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

			
		}
		
	 
}
