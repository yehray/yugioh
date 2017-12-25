package game;

public class Game {

    private Player player;
    private Player opponent;

    public Game(){

    }

    public Player getPlayer(){
        return player;
    }

    public void setPlayer(Player newPlayer){
        this.player = newPlayer;
    }

    public Player getOpponent(){
        return opponent;
    }

    public void setOpponent(Player opponentPlayer){
        this.opponent = opponentPlayer;
    }






}
