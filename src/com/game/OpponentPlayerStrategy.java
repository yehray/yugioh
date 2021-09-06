package com.game;

import com.gui.*;
import com.gui.listeners.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class OpponentPlayerStrategy {
    private Game game;
    private GUI gui;
    private Player player;
    private Player opponent;
    private PlayerPanel opponentPanel;

    public OpponentPlayerStrategy(Game currentGame, GUI currentGUI){
        game = currentGame;
        opponent = game.getOpponent();
        player = game.getPlayer();
        gui = currentGUI;
        opponentPanel = gui.getOpponentPlayer();
    }

    /**
     * The opponent starts the turn by drawing one card. The card is displayed on the game board as the artwork on the back of the card.
     */
    public void drawCard(){
        if(opponentPanel.getHandPanel().getHand().getComponents().length < 7) {
            MonsterCard monsterCard = opponent.getDeck().drawOneCard();
            ImageIcon cardBackground = new ImageIcon((getClass().getResource("/com/gui/resources/yugiohCardBackground.jpg")));
            HandButton addedCard = new HandButton(cardBackground, monsterCard);
            opponentPanel.getHandPanel().getHandButtons().add(addedCard);
            opponentPanel.getHandPanel().getHand().add(addedCard);
        }
    }

    /**
     * The opponent picks the monster card with the highest attack in their hand and summons it on the field in attack position
     */
    public void summonMonster(){
        HandButton strongest = selectStrongestInHand();
        MonsterButton monsterButton = new MonsterButton(strongest.getCard().getImageSmall(), strongest.getCard());
        monsterButton.addMouseListener(new SelectAttackTargetListener(monsterButton, gui));
        monsterButton.addMouseListener(new ShowOpponentLargerImage(gui.getCardControlPanel(), strongest.getCard(), gui));

        for(int i = 0; i < opponentPanel.getHandPanel().getHandButtons().size(); i++) {
            HandButton currentButton = opponentPanel.getHandPanel().getHandButtons().get(i);
            if(currentButton == strongest){
                opponentPanel.getHandPanel().getHandButtons().remove(currentButton);
            }
        }

        if(opponentPanel.getFieldPanel().getEmptySpotsOnField().size() != 0){
            int index = opponentPanel.getFieldPanel().getEmptySpotsOnField().get(0).getIndex();
            opponentPanel.getFieldPanel().getEmptySpotsOnField().remove(0);
            opponentPanel.getFieldPanel().getMonsterPanel().remove(index);
            opponentPanel.getFieldPanel().getMonsterPanel().add(monsterButton, index);
            opponentPanel.getFieldPanel().getMonsterCardsOnField().add(monsterButton);
            monsterButton.setIndex(index);
            opponentPanel.revalidate();
            opponentPanel.repaint();
        }
    }

    /**
     * If there are no monsters on the field, the opponent selects the monster card on their side of the field with highest attack and
     * attacks the other player's lifepoints directly.
     */
    public void attackDirectly(MonsterCard monsterCard){
        if(game.getPlayer().getField().getMonsters().size() == 0){
            player.lifepoints = player.lifepoints - (monsterCard.getAttack());
            gui.getInfoPanel().getLifepointsPanel().setText("LIFEPOINTS: " + Integer.toString(gui.getGame().getPlayer().getLifepoints()));
        }
        gui.getInfoPanel().repaint();
        gui.getInfoPanel().revalidate();
    }

    /**
     * The opponent selects the monster card on their side of the field with highest attack and selects the monster on the opposing player's
     * side of the field with the lowest attack. The opponent attacks this monster with their selected monster.
     */
    public void attack(){
        if(selectStrongestOnField() == null){
            return;
        }
        MonsterButton strongest = selectStrongestOnField();
        MonsterCard strongestMonster = strongest.getMonsterCard();
        if(player.getField().getMonsters().size() == 0){
            attackDirectly(strongestMonster);
        }
        else {
            MonsterButton weakest = selectWeakestOnField();
            MonsterCard weakestMonster = weakest.getMonsterCard();
            if (weakestMonster.getMode() == "ATTACK") {
                if (weakestMonster.getAttack() <= strongestMonster.getAttack()) {
                    player.lifepoints = player.lifepoints - (strongestMonster.getAttack() - weakestMonster.getAttack());
                    gui.getInfoPanel().getLifepointsPanel().setText("LIFEPOINTS: " + Integer.toString(gui.getGame().getPlayer().getLifepoints()));
                    removeMonster(weakestMonster, weakest);
                }
            }
            if (weakestMonster.getMode() == "DEFENSE") {
                if (weakestMonster.getDefence() <= strongestMonster.getAttack()) {
                    removeMonster(weakestMonster, weakest);
                }
            }
        }
    }

    /**
     * Removes monster from the opposing player's side of the field if the monster is destroyed in an attack.
     */
    public void removeMonster(MonsterCard weakestMonster, MonsterButton weakest){
        player.getField().removeMonster(weakestMonster);
        player.getField().addToGraveyard(weakestMonster);
        int index = weakest.getIndex();
        ImageIcon monsterCardZone = new ImageIcon(gui.getClass().getResource("resources/monsterCardZone.jpg"));
        FieldCardButton monsterCardZoneButton = new FieldCardButton(monsterCardZone);
        monsterCardZoneButton.addMouseListener(new SelectFieldCardListener(monsterCardZoneButton, gui));
        monsterCardZoneButton.setIndex(index);
        gui.getActivePlayer().getFieldPanel().getMonsterPanel().remove(index);
        gui.getActivePlayer().getFieldPanel().getMonsterCardsOnField().remove(weakest);
        gui.getActivePlayer().getFieldPanel().getMonsterPanel().add(monsterCardZoneButton, index);
        gui.getActivePlayer().getFieldPanel().getEmptySpotsOnField().add(monsterCardZoneButton);
        gui.getActivePlayer().getFieldPanel().repaint();
        gui.getActivePlayer().getFieldPanel().revalidate();
    }

    /**
     * Selects monster with highest attack in the opponent's hand.
     */
    public HandButton selectStrongestInHand(){
        if(opponentPanel.getHandPanel().getHandButtons().size() <= 0){
            return null;
        }
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

    /**
     * Selects monster with lowerst attack on opposing player's side of the field.
     */
    public MonsterButton selectWeakestOnField(){
        int weakest = Integer.MAX_VALUE;
        ArrayList<MonsterButton> monstersOnField = gui.getActivePlayer().getFieldPanel().getMonsterCardsOnField();
        if(monstersOnField.size() <= 0){
            return null;
        }
        MonsterButton weakestCard = monstersOnField.get(0);
        for (int j = 0; j < monstersOnField.size(); j++) {
            if (weakest > monstersOnField.get(j).getMonsterCard().getAttack()) {
                weakest = monstersOnField.get(j).getMonsterCard().getAttack();
                weakestCard = monstersOnField.get(j);
            }
        }
        return weakestCard;
    }

    /**
     * Selects monster with highest attack on opponents side of the field.
     */
    public MonsterButton selectStrongestOnField(){
        int strongest = 0;
        int i = 0;
        ArrayList<MonsterButton> monstersOnField = gui.getOpponentPlayer().getFieldPanel().getMonsterCardsOnField();
        if(monstersOnField.size() <= 0){
            return null;
        }
        MonsterButton strongestCard = monstersOnField.get(0);
        for (int j = 0; j < monstersOnField.size(); j++) {
            if (strongest < monstersOnField.get(j).getMonsterCard().getAttack()) {
                strongest = monstersOnField.get(j).getMonsterCard().getAttack();
                strongestCard = monstersOnField.get(j);
                i = j;
            }
        }
        return strongestCard;
    }

    /**
     * When the opponent ends the turn, it switches to the opposing player. The opposing player is set to MAIN PHASE 1 and draws one card.
     */
    public void endTurn(){
        player.endTurn();
        game.switchPlayer();
        String currentPlayer = game.getCurrentPlayer().getPlayerName();
        gui.getInfoPanel().getCurrentPhasePanel().setText("<html>" + currentPlayer + "<br> MAIN PHASE 1 </html>");
        
        Component[] componentList = gui.getCardControlPanel().getComponents();
        for(Component c : componentList){
            gui.getCardControlPanel().remove(c);
        }
        gui.getCardControlPanel().revalidate();
        gui.getCardControlPanel().repaint();

        game.setCurrentPlayer(player);
        MonsterCard drawnCard = game.getCurrentPlayer().drawCard();
        gui.setActivePlayer(gui.getPlayer1());
        gui.setOpponent(gui.getPlayer2());
        gui.addToHand(drawnCard, gui.getActivePlayer());
        game.getCurrentWinner();
    }
}
