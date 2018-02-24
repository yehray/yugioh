package game;

import gui.GUI;
import gui.HandButton;
import gui.PlayerPanel;

import javax.swing.*;

public class OpponentPlayerStrategy {
    private Game game;
    private GUI gui;
    private PlayerPanel opponentPlayer;
    public OpponentPlayerStrategy(Game currentGame, GUI currentGUI){
        game = currentGame;
        gui = currentGUI;
        endTurn();

    }

    public void drawCard(){
//        MonsterCard monsterCard = game.getOpponent().getHand().getCardsInHand();
//        ImageIcon cardBackground = new ImageIcon(this.getClass().getResource("resources/yugiohCardBackground.jpg"));
//        HandButton addedCard = new HandButton(cardBackground, monsterCard);
//        gui.getOpponentPlayer().getHandPanel().getHand().add(addedCard);
    }

    public void summonMonster(){

    }

    public void endTurn(){
        game.setCurrentPlayer(game.getPlayer());
        MonsterCard drawnCard = game.getCurrentPlayer().drawCard();
        gui.setActivePlayer(gui.getPlayer1());
        gui.setOpponent(gui.getPlayer2());
        gui.addToHand(drawnCard, gui.getActivePlayer());
    }
}
