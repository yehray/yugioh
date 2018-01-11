package game;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

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

    public void createDeck(Player player, String fileName){
        try {

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            ArrayList<String[]> lines = new ArrayList<>();
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] lineSplit = line.split(",");
                lines.add(lineSplit);
            }
            for(int i = 0; i < lines.size(); i++){
                for(int j = 0; j < lines.get(i).length; j++){
                    MonsterCard monsterCard = new MonsterCard(lines.get(i)[0], Integer.parseInt(lines.get(i)[1]), Integer.parseInt(lines.get(i)[2]), Integer.parseInt(lines.get(i)[3]));
                    player.getDeck().addCardToDeck(monsterCard);
                }
            }

        }

        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void startNewGame(){


        Player player = new Player("player", 8000);
        Player opponent = new Player("opponent", 8000);

        createDeck(player, "/Users/yehray/IdeaProjects/yugioh/src/game/cards/YugiDeck.csv");
        Deck opponentDeck = new Deck();

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
