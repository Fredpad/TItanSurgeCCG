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
			OmensGame enemy;
			
			public OmensGame(){
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
			public void printresources(){
				System.out.println("\tHealth: " + health);
				System.out.println("\tGold: " +  gold);
				System.out.println("\tApples: " + apples);
				System.out.println("\tSkulls: " + skulls);
				System.out.println("\tMagic: " + magic );
			}
			
			public void printbank(){
				for(int i = 0; i < banklength; i +=1){
					System.out.println((i+1) + ": " + bank[i].getName() + "Cost: " + bank[i].getCost());
				}
			}
			
			public void printhand(){
				for(int i = 0; i < handlength; i +=1){
					System.out.println((i+1) + ": " + hand[i].getName());
				}
			}
			
			public int cheapestcard(){
				int cost = 0; 
				for(int i = 0; i < banklength; i+=1){
					if(bank[i].getCost() > 0)
						cost = bank[i].getCost();
				}
				return cost;
			}
			
			public void printfield(){
				for(int i= 0; i < fieldlength; i+=1){
					System.out.println((i+1) + ": " + field[i].getName());
				}
			}
			public CardObserver observer(){return obs;}
			//#######################################################################
			
			/**$$$ START OF METHODS THAT SET UP THE GAME $$$*/
			
			public void setfield() {
				for (int i = 0; i < fieldlength;i+=1){
					field[i] = lib.getOmenscard("No card");
				}
			}
			
			public void setdeck(){
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
				for (int i = 0; i < 4; i+=1){
					draw();
				}
			}
			
			/**### END OF METHODS THAT SET UP THE GAME ###*/
			
			//###################################################################
			
			/**$$$ START OF METHODS THAT CONTINUE THE GAME $$$*/
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
				bank[banklength] = lib.getOmenscard("random");
				}
			}
				
			public void buycard(String key){
				for (int i = 0; i < banklength; i+=1){
					if (bank[i].getkey().equals(key)){
						gold -= bank[i].getCost();
						hand[handlength] = bank[i];
						bank[i] = lib.getOmenscard("no card");
						handlength+=1;
						banklength-=1;
						adjustbank();
					}
				}
			}
			
			public void adjustbank(){
				for(int i = 0; i < banklength; i+=1){
					if(bank[i].getName().equalsIgnoreCase("No card") && i+1 < banksize){
						bank[i] = bank[i+1];
						bank[i+1] = lib.getOmenscard("no card");
					}
				}
			}
			
			public void playTurn(){
				strat.handcards();
				strat.buycards();
				strat.useresources();
			}
			
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
			
			public void todeck(String key){
				for(int i = 0; i < handlength; i +=1){
					if(hand[i].getkey().equals(key))
						{deck[decklength] = hand[i]; 
						decklength+=1; handlength -=1;
						hand[i] = lib.getOmenscard("No card");
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
			
			public void onTurnCalls(){
				for(Omenscard card: field){
					card.getOnturn();
				}
			}
			
			public void endTurn(){
				
				for(int i = 0; i < 3; i +=1){
					if(handlength < 4){
						draw();
					}
				}
			}
			
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
			
			@Override
			public void playcard(String key) {
				for (int i=0; i < handlength; i+=1){
					if (hand[i].getkey().equals(key)){
						field[fieldlength] = hand[i];
						hand[i] = lib.getOmenscard("No card");
						fieldlength+=1;
					}
			}
				adjusthand();}

			@Override
			public void adjusthand() {
				for (int i = 0; i < handlength; i+=1){
					if (hand[i].getName().equalsIgnoreCase("no card")){
						Omenscard temp= hand[i];
						hand[i] = hand[i+1]; 
						hand[i+1] = temp;
					}
				}}

			@Override
			public void adjustfield() {
				for (int i = 0; i < fieldlength; i+=1){
					if (field[i].getName().equals("no card")){
						for (int j = i; j < fieldlength; j+=1){
							if (j == fieldsize-1)
								break; 
							else
								field[j]= field[j+1];
							
					}}
				}}
			
			public void damaged(int n){
				if(isIntercepts()==true)
					defend();
				else
					health -=1;
			}
			
			public void eatApples(){
				apples -=1;
				health +=1;
			}
			
			public void eatMagic(){
				magic -=1;
				health +=1;
			}
			/**### END OF METHODS THAT CONTINUE THE GAME ###*/ 
			
			
			//####################################################################
			
			
			/**$$$ START OF OFFENSIVE METHODS $$$*/
			
			public void minionAttack() {
				enemy.lowestMinion();
				
			}
			public void attackWithSkulls(){
				if(skulls > 0)
				{
					skulls -=1; 
					enemy.damaged(1);
				}
			}
			
			public void attackWithMagic(){
				if(magic > 0){
					magic -=1;
					enemy.damaged(1);
				}
			}
			
			/**### END OF OFFENSIVE METHODS ###*/
			
			//------------------------------------------------------------
			
			
			/**$$$ START OF DEFENSIVE METHODS $$$*/
			
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
					
					intercept.get(takesHit).damaged();}	}
			
			public boolean isIntercepts(){
				for(int i = 0; i < fieldlength; i +=1){
					if(field[i].canIntercept() == true){
						return true;
					}
				}
				return false;	}
			
			
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
			
			public Omenscard gethandcard(int n){
					return hand[n];}
			
		
			public Omenscard getfieldcard(int n){
				if(n>= 0 && n < handlength){
					return field[n];}
				else
					return null;}
			
			public Omenscard getbankcard(int n){
				return bank[n];}
			
			public int getBanklength(){return banklength;}
			
			public void gainGold(int n){
				gold +=n;}
			
			public void gainSkulls(int n){
				skulls +=n;}
			
			public void gainApples(int n){
				apples +=n;}
			
			public void gainMagic(int n){
				magic +=n;}
			
			public void loseApples(int n){
				apples -=n;}
			
			public void loseMagic(int n){
				magic -= n;}
			
			public void loseSkulls(int n){
				skulls -= n;}
			
			public void loseGold(int n){
				gold -= n;}
			
			public int getGoldAmount(){
				return gold;}
			
			public int getSkullAmount(){
				return skulls;}
			
			public int getApplesAmount(){
				return apples;}
			
			public int getMagicAmount(){
				return magic;}
			
			@Override
			public void newTurn() {
				restockbank();
				onTurnCalls();
				
				
			}

			/**### END OF SETTERS AND GETTERS ### */
}
