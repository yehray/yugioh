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

    public Player getCurrentPlayer() {
        return currentPlayer;
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

    public void getCurrentWinner(){
        if(player.getLifepoints() <= 0){
            setWinner(player);
            JOptionPane.showMessageDialog(null, opponent.getPlayerName() + " wins the com.game!");
        }

        if(opponent.getLifepoints() <= 0){
            System.out.println("Current winner");
            setWinner(opponent);
            JOptionPane.showMessageDialog(null, player.getPlayerName() + " wins the com.game!");

        }
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
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

    public void startNewGame(){


        player  = new Player("PLAYER 1", 8000);
        opponent = new Player("PLAYER 2", 8000);

        createDeck(player, "/Users/yehray/IdeaProjects/yugioh/src/com/game/cards/YugiDeck.csv");
        createDeck(opponent, "/Users/yehray/IdeaProjects/yugioh/src/com/game/cards/KaibaDeck.csv");

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
