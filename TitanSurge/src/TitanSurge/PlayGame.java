package TitanSurge;

import java.util.List;

public class PlayGame extends Duel {
	
	public PlayGame(List<Player> _players) {
		super(_players);
	}

	@Override
	protected Player findWinner() {
		if(players.get(0).enemy.getHealth() <= 0)
			return players.get(0); 
		if(players.get(1).enemy.getHealth() <= 0)
			return players.get(1);
		return null;
	}
	
	
}
