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
                Thread.sleep(1250);
                player.attack();
                player.printboard();
                player.endTurn();
            }
        }
        return winner;
    }

    /**
     * Check for a winner
     * @return winning Player if game is over, null if not
     */
    protected abstract Player findWinner();
   
    
}