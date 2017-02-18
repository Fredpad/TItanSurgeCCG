package Titan;
public class Lion implements Titancard{
		int health = 190, timer = 2, attack = 130;
		String name = "Lion"; 
		
		@Override
		public String getName() {
			return name;
		}

		@Override
		public int getHealth() {
			return health;
		}

		@Override
		public void damaged(int n) {
			health -= n;
		}

		@Override
		public void reduceTimer() {
			if(timer > 0)
				timer -=1;
		}

		@Override
		public int getTimer() {
			return timer;
		}

		@Override
		public int getAttack() {
			return attack;
		}

		@Override
		public String getkey() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}