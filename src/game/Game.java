package game;

public class Game {

    private Player player;
    private Player opponent;
    private Player currentPlayer;
    private Player winner;

    public Game(){

    }

    public Player getPlayer(){
        return player;
    }

    public void setPlayer(Player newPlayer, int lifepoints){
        this.player = newPlayer;
        player.lifepoints = lifepoints;
    }

    public Player getOpponent(){
        return opponent;
    }

    public void setOpponent(Player opponentPlayer, int lifepoints){
        this.opponent = opponentPlayer;
        opponent.lifepoints = lifepoints;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void switchPlayer(){
        if(winner == null) {
            if (currentPlayer == player) {
                currentPlayer = opponent;
                opponent.drawCard();
            } else {
                currentPlayer = player;
                player.drawCard();
            }
        }
    }

    public void createDeck(Deck deck){

    }

    public void startNewGame(){
        Deck playerDeck = new Deck();
        createDeck(playerDeck);
        Deck opponentDeck = new Deck();
        createDeck(opponentDeck);

        Player player = new Player("player", 8000, playerDeck);
        Player opponent = new Player("opponent", 8000, opponentDeck);
        for(int i = 0; i < 6; i ++){
            opponent.drawCard();
            opponent.drawCard();
        }

        int r = (int)(2*Math.random());
        if(r == 0){
            player.drawCard();
        }
        else{
            opponent.drawCard();
        }
    }

    public void endGame(){

    }


}
