package TitanSurge;

import java.util.List;

public abstract class Duel {
    protected final List<Player> players;
    
    public Duel(List<Player> _players) {
        players = _players;
    }
    
    /**
     * General method to play the game until there is a winner
     * @return winning player
     * @throws InterruptedException 
     */
    public Player play() throws InterruptedException {
        Player winner;
        while (null == (winner = findWinner())) {
            for (Player player : players) {
                player.newTurn();
                player.playTurn();
                player.printboard();
                Thread.sleep(1000);
                player.attack();
           
            }
        }
        return winner;
    }

    /**
     * Check for a winner
     * @return winning Player if game is over, null if not
     */
    protected abstract Player findWinner();
    

    /**
     * Run this code at the end of a player's turn
     */
    protected void afterTurn(Player player, Player winner) {
    	
    }
    
}