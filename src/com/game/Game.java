package com.game;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

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

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void getCurrentWinner(){
        if(player.getLifepoints() <= 0){
            setWinner(opponent);
        }
        if(opponent.getLifepoints() <= 0){
            setWinner(player);
        }
    }

    public void switchPlayer(){
        if(winner == null) {
            if (currentPlayer == player) {
                currentPlayer = opponent;
            } else {
                currentPlayer = player;
            }
        }
    }

    /**
     * Creates deck of monster cards based on a csv file with the form: Monster Name, Level, Attack, Defense.
     */
    public void createDeck(Player player, String fileName){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            ArrayList<String[]> lines = new ArrayList<>();
            String line = "";
            String headerLine = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] lineSplit = line.split(",");
                lines.add(lineSplit);
            }
            for(int i = 0; i < lines.size(); i++){
                MonsterCard monsterCard = new MonsterCard(lines.get(i)[0], Integer.parseInt(lines.get(i)[1]), Integer.parseInt(lines.get(i)[2]), Integer.parseInt(lines.get(i)[3]));
                player.getDeck().addCardToDeck(monsterCard);
            }
        }

        catch(IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Starts new game with decks based on Starter Deck Yugi and Starter Deck Kaiba. Each player starts with 8000 lifepoints nad 5 cards in their hand.
     * Player 1 starts the game first.
     */
    public void startNewGame(){
        player  = new Player("PLAYER 1", 8000);
        opponent = new Player("PLAYER 2", 8000);

        createDeck(player, "./src/com/game/cards/YugiDeck.csv");
        createDeck(opponent, "./src/com/game/cards/KaibaDeck.csv");

        player.getDeck().shuffleDeck();
        opponent.getDeck().shuffleDeck();

        for(int i = 0; i < 5; i ++){
            player.drawCard();
            opponent.drawCard();
        }

        currentPlayer = player;

//        int r = (int)(2*Math.random());
//        if(r == 0){
//            currentPlayer = player;
//            player.drawCard();
//        }
//        else{
//            currentPlayer = opponent;
//            opponent.drawCard();
//        }
    }

}
