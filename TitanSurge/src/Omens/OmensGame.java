package Omens;
import Common.*;
import java.util.ArrayList;
import java.util.List;

public class OmensGame extends Game {
			int banksize = 5, banklength = 0;
			int skulls = 0, gold =0, apples = 0, magic = 0;
			Omenscard[] bank = new Omenscard[banksize];
			Omenscard[] field, deck, hand;
			CardObserver obs = new OmenObserver(this);
			Cardlib lib = FactoryProducer.getLib("Omens", obs); 
			OmenStrategy strat = new OmenStrategy(obs, this);
			static int count = 1;
			protected String name = "Player " + String.valueOf(count);
			boolean notHuman = false;
			OmensGame enemy;
			
			public OmensGame(){
				count +=1;
				health = 20;
				handsize = 6; 
				fieldsize = 20; 
				decksize = 50;
				
				field = new Omenscard[fieldsize];
				hand = new Omenscard[handsize];
				deck = new Omenscard[decksize];
				
				setfield();
				setdeck();
				sethand();
				setbank();
			}
			//########################################################################
			
			//PRINT METHODS / LAST MINUTE METHODS
			public void printresources(){
				System.out.println(name + "'s Resources");
				System.out.println("\tHealth: " + health);
				System.out.println("\tGold: " +  gold);
				System.out.println("\tApples: " + apples);
				System.out.println("\tSkulls: " + skulls);
				System.out.println("\tMagic: " + magic );
				System.out.println();
			}
			
			public void printbank(){
				System.out.println(name + "'s Bank");
				for(int i = 0; i < banklength; i +=1){
					System.out.println("\t" +(i+1) + ": " + bank[i].getName() + " Cost: " + bank[i].getCost());
				}
				System.out.println();
			}
			
			public void printhand(){
				System.out.println(name + "'s Hand");
				for(int i = 0; i < handlength; i +=1){
					System.out.println("\t" + (i+1) + ": " + hand[i].getName());
				}
				System.out.println();
			}
			
			//used by strategy to see if there is a card that is cheap enough to be bought
			//from the bank
			public int cheapestcard(){
				int cost = 0; 
				for(int i = 0; i < banklength; i+=1){
					if(bank[i].getCost() > 0)
						cost = bank[i].getCost();
				}
				return cost;
			}
			
			public void printfield(){
				System.out.println(name + "'s Field");
				for(int i= 0; i < fieldlength; i+=1){
					System.out.println("\t" +(i+1) + ": " + field[i].getName() + " Card Health: " + field[i].getHealth());
				}
				System.out.println();
			}
			public CardObserver observer(){return obs;}
			
			//END OF PRINT METHODS/ LAST MINUTE
			//#######################################################################
			
			/**$$$ START OF METHODS THAT SET UP THE GAME $$$*/
			protected void setCampaign(){notHuman = true;}
			
			public void reset() {
				decklength = 10;
				fieldlength = 0;
				handlength = 0;
				banklength = 5;
				health = 20;
				apples = 0; skulls = 0; gold = 0; magic = 0;
				
				setfield();
				setdeck();
				setbank();
				
				for(int i = 0; i < handsize; i++)
					hand[i] = lib.getOmenscard("Coin");
				
				sethand();
				
			}
			
			public void setfield() {
				for (int i = 0; i < fieldsize;i+=1){
					field[i] = lib.getOmenscard("No card");
				}
			}
			
			public void setdeck(){
				
				for(int i = 0; i < decksize; i++)
					deck[i] = lib.getOmenscard("No card");
				
				for (int i = 0; i < 10; i+=1){
					deck[i] = lib.getOmenscard("Coin");
				}
				decklength = 10;
			}
				
			public void setbank(){
				bank[0] = lib.getOmenscard("random");
				bank[1] = lib.getOmenscard("random");
				bank[2] = lib.getOmenscard("random");
				bank[3] = lib.getOmenscard("random");
				bank[4] = lib.getOmenscard("random");
				banklength = 5;
			}
			
			public void sethand(){
				
				for(int i = 0; i < handsize; i++)
					hand[i] = lib.getOmenscard("No card");
				
				for (int i = 0; i < 4; i+=1){
					draw();
				}
			}
			
			/**### END OF METHODS THAT SET UP THE GAME ###*/
			
			//###################################################################
			
			/**$$$ START OF METHODS THAT CONTINUE THE GAME $$$*/
			

			
			
			public int weakestCard(){
				int j = 0;
				
				for (int i = 0; i < fieldlength; i++){
					if (field[j].getHealth() > field[i].getHealth()){
						j = i;
					}
				}
				
				return j;
			}
			
			//everyturn, the player gets a free apple
			protected void newTurnpassive(){apples +=1;}
			
			
			//every turn, the bank is updated with a new card
			public void restockbank(){
				if (banklength < banksize){
					bank[banklength] = lib.getOmenscard("random");
					banklength+=1;
				}
				else{
					for (int i = 0; i < banksize; i+=1){
						if (i == banksize-1)
							break;
						else{
							bank[i] = bank[i+1];
						}
					}
				bank[banklength - 1] = lib.getOmenscard("random");
				}
			}
			
			//to buy a card. used by observer when a card's buy() method is used
			public void buycard(String key){
				for (int i = 0; i < banklength; i+=1){
					if (bank[i].getkey().equals(key)){
						gold -= bank[i].getCost();
						hand[handlength] = bank[i];
						bank[i] = lib.getOmenscard("no card");
						handlength+=1;
						banklength-=1;
						adjustbank();
						break;
					}
				}
			}
			
			//fills in a gap between cards in the bank
			public void adjustbank(){
				for(int i = 0; i < banklength; i+=1){
					if(bank[i].getName().equalsIgnoreCase("No card") && i+1 < banksize){
						bank[i] = bank[i+1];
						bank[i+1] = lib.getOmenscard("no card");
					}
				}
			}
			
			//every new turn, the passive activates. the bank is given a new card
			//cards with abilities activate
			@Override
			public void newTurn() {
				newTurnpassive();
				restockbank();
				onTurnCalls();
			}
			
			//calls the strategy class to show playable moves
			public void playTurn(){
				if(notHuman == false){
					strat.handcards();
					strat.buycards();
					strat.useresources(); }
				else
					strat.campaignTactic();
			}
			
			//War of omens has the new hand drawn at the end of the turn
			public void endTurn(){
				
				for(int i = 0; i < 3; i +=1){
					if(handlength < 4){
						draw();
					}
				}
			}
			
			//if the car is dead, so 0 health, it's moved from the field to 
			// the DECK. the game does not have  a graveyard
			public void deadcard(String key){
				for (int i = 0; i < fieldlength; i+=1){
					if (field[i].getkey().equals(key)){
						deck[decklength] = field[i];
						decklength+=1;
						field[i] = lib.getOmenscard("no card");
						fieldlength-=1;
						adjustfield();
					}
				} 
			}
			
			//a card that does not go on the field is instead sent to the deck
			//after use
			public void todeck(String key){
				for(int i = 0; i < handlength; i +=1){
					if(hand[i].getkey().equals(key))
						{deck[decklength] = hand[i];
						hand[i] = lib.getOmenscard("No card");
						decklength+=1; handlength -=1;
						adjusthand();
						break;}
				}
			}

			@Override
			public void draw() {
				 hand[handlength] = deck[0] ;
				 deck[0] = lib.getOmenscard("No card");
				decklength -=1;
				handlength+=1;
				shiftdeck();}
			
			//activates the abilities of cards when a new turn starts
			public void onTurnCalls(){
				if(fieldlength > 0){
					for(int i = 0; i < fieldlength; i+=1){
						field[i].getOnturn();
					}
				}
				
			}
			
			
			//adjust the deck to fill in empty slots between cards
			private void shiftdeck(){
			/**Used when the top card of the deck is drawn,
			 * need to move the "No Card" to the end of the deck
			 * */
				for(int i = 0; i < decklength; i +=1){
						Omenscard temp = deck[i];
						deck[i] = deck[i+1];
						deck[i+1]=temp;
				}
			}
			
			//called by observer to play a card
			@Override
			public void playcard(String key) {
				for (int i=0; i < handlength; i+=1){
					if (hand[i].getkey().equals(key)){
						field[fieldlength] = hand[i];
						hand[i] = lib.getOmenscard("No card");
						fieldlength+=1;
						handlength-=1;
						adjusthand();
					}
				}
			}
			
			//fills empty slots in the hand 
			@Override
			public void adjusthand() {
				for (int i = 0; i < handlength; i+=1){
					if (hand[i].getName().equalsIgnoreCase("no card")){
						Omenscard temp= hand[i];
						hand[i] = hand[i+1]; 
						hand[i+1] = temp;
					}
				}}

			//fills empty slots in the field
			@Override
			public void adjustfield() {
				for (int i = 0; i < fieldlength; i+=1){
					if (field[i].getName().equalsIgnoreCase("no card")){
						for (int j = i; j < fieldlength; j+=1){
							if (j == fieldsize-1)
								break; 
							else
								field[j]= field[j+1];
							
					}}
				}}
			
			//when the player is taking damage, it is either intercepted or taken
			public void damaged(int n){
				if(isIntercepts()==true)
					defend();
				else
					health -=1;
			}
			
			//when the player eats an apple, they get 1 health
			public void eatApples(){
				apples -=1;
				health +=1;
			}
			
			//when the player eats a magic, they get 1 health
			public void eatMagic(){
				magic -=1;
				health +=1;
			}
			/**### END OF METHODS THAT CONTINUE THE GAME ###*/ 
			
			
			//####################################################################
			
			
			/**$$$ START OF OFFENSIVE METHODS $$$*/
			
			//if a minion is launchign an attack, this method is called
			public void minionAttack() {
				enemy.defend();
				System.out.println("\nEnemy health: " + enemy.gethealth());
				
			}
			
			//if a player wants to attack the enemy directly with skulls for 1 damage
			public void attackWithSkulls(){
				if(skulls > 0)
				{
					skulls -=1; 
					enemy.damaged(1);
				}
			}
			
			//if the player wants to attack the enemy directly with magic for 1 damage
			public void attackWithMagic(){
				if(magic > 0){
					magic -=1;
					enemy.damaged(1);
				}
			}
			
			/**### END OF OFFENSIVE METHODS ###*/
			
			//------------------------------------------------------------
			
			
			/**$$$ START OF DEFENSIVE METHODS $$$*/
			
			//whenever the player is going to take damage, this method is called
			//so that if a card can intercept it, it will
			public void defend(){
				
				List<Omenscard> intercept = new ArrayList<Omenscard>();
				for(int i =0; i < fieldlength; i +=1){
					if(field[i].canIntercept() == true)
						intercept.add(field[i]);
				}
				
				if(intercept.size() > 0){
					int takesHit = 0;
					for(int i = 1; i < intercept.size(); i+=1){
						if(intercept.get(i).getHealth() > intercept.get(i-1).getHealth())
							takesHit = i;
						}
					
					intercept.get(takesHit).damaged();}	
				
				else
					health -=1;}
			
			//checks to see if there are any cards that can intercept an incoming attack
			public boolean isIntercepts(){
				for(int i = 0; i < fieldlength; i +=1){
					if(field[i].canIntercept() == true){
						return true;
					}
				}
				return false;	}
			
			//a general attack is always, by default, going to hit the minion with 
			//the least health and this method carries out that rule
			public void lowestMinion(){
				int weakest = 0; 
				for(int i = 1; i < fieldlength; i+=1){
					if(field[i].getHealth() < field[i-1].getHealth())
						weakest = i;
				}
				
				if(isIntercepts() == true)
					defend();
				else
					field[weakest].damaged();	}
			
			
			/**### END OF DEFENSIVE METHODS ###*/
			
			//#####################################################################
			
			/**$$$ START OF SETTERS AND GETTERS $$$*/
			
			public void sethandcard(String card, int i){hand[i] = lib.getOmenscard(card);}
			
			public void setdeckcard(String card, int i){deck[i] = lib.getOmenscard(card);}
			
			public void setbankcard(String card, int i){bank[i] = lib.getOmenscard(card);}
			
			public void setfieldcard(String card, int i){field[i] = lib.getOmenscard(card);}
			
			public void setmagic(int i){magic = i;}
			
			public void setapples(int i){apples = i;}
			
			public void setskulls(int i ){skulls = i;}
			
			public void setgold(int i){gold = i;}
			
			public void sethealth(int i){health = i;}
			
			public void setdecklength(int i){decklength = i;}
			
			public void sethandlength(int i){handlength = i;}
			
			public void setfieldlength(int i){fieldlength = i;}
			
			public void setbanklength(int i){banklength = i;}
			
			public Omenscard getdeckcard(int i) {
				return deck[i];
			}
			
			public void setName(String title){this.name = title;}
			
			public int getdecksize(){return decksize;}
			
			public int gethandsize(){return handsize;}
			
			public int getfieldsize(){return fieldsize;}
			
			public int getbanksize(){return banksize;}
			
			//tells the player who they're enemy is
			public void setEnemy(OmensGame them){this.enemy = them;}
			
			//get the players name
			public String getName(){return name;}
			
			//get a card in element n of array hand
			public Omenscard gethandcard(int n){
					return hand[n];}
			
			//get card in element n of array field
			public Omenscard getfieldcard(int n){
					return field[n];}
			
			//get card in element n of array bank
			public Omenscard getbankcard(int n){
				return bank[n];}
			
			//returns the number of cards in the bank
			public int getBanklength(){return banklength;}
			
			//used when gold is earned
			public void gainGold(int n){
				gold +=n;}
			
			//used when skulls are generated
			public void gainSkulls(int n){
				skulls +=n;}
			
			//used when apples are generated
			public void gainApples(int n){
				apples +=n;}
			
			//used when magic are generated
			public void gainMagic(int n){
				magic +=n;}
			
			//when an apple is used
			public void loseApples(int n){
				apples -=n;}
			
			//when magic is used
			public void loseMagic(int n){
				magic -= n;}
			
			//when skulls are used
			public void loseSkulls(int n){
				skulls -= n;}
			
			//when gold is used
			public void loseGold(int n){
				gold -= n;}
			//returns the amount of gold the player has
			public int getGoldAmount(){
				return gold;}
			
			//returns the amount of skulls the player has
			public int getSkullAmount(){
				return skulls;}
			
			//returns the amount of apples the player has
			public int getApplesAmount(){
				return apples;}
			
			//returns the amount of magic the player has
			public int getMagicAmount(){
				return magic;}
			
			

			/**### END OF SETTERS AND GETTERS ### */
}
