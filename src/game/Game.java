package game;

public class Game {

    private Player player;
    private Player opponent;
    private Player currentPlayer;

    public Game(){

    }

    public Player getPlayer(){
        return player;
    }

    public void setPlayer(Player newPlayer, int lifepoints){
        this.player = newPlayer;
        player.lifepoints = 8000;
    }

    public Player getOpponent(){
        return opponent;
    }

    public void setOpponent(Player opponentPlayer, int lifepoints){
        this.opponent = opponentPlayer;
        opponent.lifepoints = 8000;
    }

    public void switchPlayer(){
        if(currentPlayer == player){
            currentPlayer = opponent;
        }
        else{
            currentPlayer = player;
        }
    }


}
