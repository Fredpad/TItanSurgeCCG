package Omens;
import Common.Game;

public class OmensGame extends Game {
			int banksize = 5, banklength = 0;
			int skulls = 0, gold =0, apples = 0;
			Card[] bank = new Card[banksize];
			
			OmensGame(){
				health = 20;
				handsize = 5; 
				fieldsize = 20; 
				decksize = 50;
				lib = FactoryProducer.getLib("Omens");
			}
			public void setfield() {
				for (int i = 0; i < fieldlength;i++){
					field[i] = lib.getOmenscard("No card");
				}
			}
			
			public void setdeck(){
				for (int i = 0; i < 10; i++){
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
				for (int i = 0; i < 4; i++){
					draw();
				}
			}
				
			public void restockbank(){
				if (banklength < banksize){
					bank[banklenth] = lib.getOmenscard("random");
					banklenth++;
				}
				else{
					for (int i = 0; i < banksize; i++){
						if (i = banksize-1)
							break;
						else{
							bank[i] = bank[i+1];
						}
					}
				bank[banklength] = lib.getOmenscard("random");
				}
			}
				
			public void buycard(String name){
				for (int i = 0; i < banklength; i++){
					if (bank[i].getName().equal(name)){
						hand[handlength] = bank[i];
						bank[i] = lib.getOmenscard("no card");
						handlength++;
						banklength--;
					}
				}
			}
			
			public void deadcard(String name){
				for (int i = 0; i < fieldlength; i++){
					if (field[i].getName.equal(name)&& field[i].gethealth()==0){
						deck[decklength] = field[i];
						decklength++;
						field[i] = lib.getOmenscard("no card");
						fieldlength--;
						adjustfield();
					}
				} 
			}

}
