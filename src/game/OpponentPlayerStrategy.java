package game;

import gui.*;
import gui.listeners.SelectFieldMonsterListener;
import gui.listeners.ShowLargerImage;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class OpponentPlayerStrategy {
    private Game game;
    private GUI gui;
    private Player opponent;
    private PlayerPanel opponentPanel;
    public OpponentPlayerStrategy(Game currentGame, GUI currentGUI){
        game = currentGame;
        opponent = game.getOpponent();
        gui = currentGUI;
        opponentPanel = gui.getOpponentPlayer();
    }

    public void drawCard(){
        MonsterCard monsterCard = opponent.getDeck().drawOneCard();
        ImageIcon cardBackground = new ImageIcon((getClass().getResource("/gui/resources/yugiohCardBackground.jpg")));
        HandButton addedCard = new HandButton(cardBackground, monsterCard);
        opponentPanel.getHandPanel().getHandButtons().add(addedCard);
        opponentPanel.getHandPanel().getHand().add(addedCard);
    }

    public void summonMonster(){
        HandButton strongest = selectStrongest();
        MonsterButton monsterButton = new MonsterButton(strongest.getCard().getImageSmall(), strongest.getCard());
        
        for(int i = 0; i < opponentPanel.getHandPanel().getHandButtons().size(); i++) {
            HandButton currentButton = opponentPanel.getHandPanel().getHandButtons().get(i);
            if(currentButton == strongest){
                opponentPanel.getHandPanel().getHand().remove(currentButton);
            }
        }

        if(opponentPanel.getFieldPanel().getEmptySpotsOnField().size() != 0){
            int index = opponentPanel.getFieldPanel().getEmptySpotsOnField().get(0).getIndex();
            opponentPanel.getFieldPanel().getMonsterPanel().remove(index);
            opponentPanel.getFieldPanel().getMonsterPanel().add(monsterButton, index);
            opponentPanel.getFieldPanel().getMonsterCardsOnField().add(monsterButton.getMonsterCard());
            monsterButton.setIndex(index);
            opponentPanel.revalidate();
            opponentPanel.repaint();
        }

    }

    public HandButton selectStrongest(){
        ArrayList<HandButton> opponentHand = opponentPanel.getHandPanel().getHandButtons();
        HandButton strongest = opponentHand.get(0);
        int greatestAttack = 0;
        for(int i = 0; i < opponentHand.size(); i++){
            if(opponentHand.get(i).getCard().getAttack() > greatestAttack){
                greatestAttack = opponentHand.get(i).getCard().getAttack();
                strongest = opponentHand.get(i);
            }
        }
        return strongest;
    }

    public void endTurn(){
        game.setCurrentPlayer(game.getPlayer());
        MonsterCard drawnCard = game.getCurrentPlayer().drawCard();
        gui.setActivePlayer(gui.getPlayer1());
        gui.setOpponent(gui.getPlayer2());
        gui.addToHand(drawnCard, gui.getActivePlayer());
    }
}
