package com.gui.listeners;

import com.game.Game;
import com.game.MonsterCard;
import com.game.Player;
import com.gui.FieldCardButton;
import com.gui.GUI;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AttackListener extends MouseAdapter{
    boolean isFirstClick;
    private GUI gui;
    private Game game;
    public AttackListener(GUI addedGUI){
        gui = addedGUI;
        game = gui.getGame();
        isFirstClick = true;
    }

    /**
     * Performs attack based on the monster selected by the player. Removes the monster card from the field if it is destroyed and updates the resulting lifepoints.
     * Checks if the player wins the game after performing the attack.
     */
    public void mouseClicked(MouseEvent e){
        MonsterCard monster = gui.getMonsterSelected().getMonsterCard();
        MonsterCard opponentMonster = gui.getMonsterTarget().getMonsterCard();
        Player opponentPlayer = game.getOpponent();
        game.getPlayer().attack(monster, opponentMonster, opponentPlayer);
        gui.getInfoPanel().getOpponentLifepointsPanel().setText("LIFEPOINTS: " + Integer.toString(opponentPlayer.getLifepoints()));
        gui.getInfoPanel().getLifepointsPanel().setText("LIFEPOINTS: " + Integer.toString(game.getPlayer().getLifepoints()));
        if(opponentMonster.getAttack() < monster.getAttack()){
            int index = gui.getMonsterTarget().getIndex();
            ImageIcon monsterCardZone = new ImageIcon(gui.getClass().getResource("resources/monsterCardZone.jpg"));
            FieldCardButton monsterCardZoneButton = new FieldCardButton(monsterCardZone);
            monsterCardZoneButton.addMouseListener(new SelectFieldCardListener(monsterCardZoneButton, gui));
            monsterCardZoneButton.setIndex(index);
            gui.getOpponentPlayer().getFieldPanel().getMonsterPanel().remove(index);
            gui.getOpponentPlayer().getFieldPanel().getMonsterPanel().add(monsterCardZoneButton, index);
            gui.getOpponentPlayer().getFieldPanel().getEmptySpotsOnField().add(monsterCardZoneButton);
        }
        if(opponentMonster.getAttack() > monster.getAttack()){
            int index = gui.getMonsterSelected().getIndex();
            ImageIcon monsterCardZone = new ImageIcon(gui.getClass().getResource("resources/monsterCardZone.jpg"));
            FieldCardButton monsterCardZoneButton = new FieldCardButton(monsterCardZone);
            monsterCardZoneButton.addMouseListener(new SelectFieldCardListener(monsterCardZoneButton, gui));
            monsterCardZoneButton.setIndex(index);
            gui.getActivePlayer().getFieldPanel().getMonsterPanel().remove(index);
            gui.getActivePlayer().getFieldPanel().getMonsterPanel().add(monsterCardZoneButton, index);
            gui.getActivePlayer().getFieldPanel().getEmptySpotsOnField().add(monsterCardZoneButton);
        }
        game.getCurrentWinner();
        if(game.getWinner().getPlayerName() == game.getPlayer().getPlayerName()){
            JOptionPane.showMessageDialog(null, game.getPlayer().getPlayerName() + " wins the game!");
        }
        if(game.getWinner().getPlayerName() == game.getOpponent().getPlayerName()){
            JOptionPane.showMessageDialog(null, game.getOpponent().getPlayerName() + " wins the game!");
        }
        monster = null;
        opponentMonster = null;
        gui.getInfoPanel().repaint();
        gui.getInfoPanel().revalidate();
    }
}

