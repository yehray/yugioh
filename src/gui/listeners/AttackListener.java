package gui.listeners;

import game.Game;
import game.MonsterCard;
import game.Player;
import gui.FieldCardButton;
import gui.GUI;
import gui.MonsterButton;

import javax.swing.*;
import java.awt.*;
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


    public void mouseClicked(MouseEvent e) {
        MonsterCard monster = gui.getMonsterSelected().getMonsterCard();
        MonsterCard opponentMonster = gui.getMonsterTarget().getMonsterCard();
        Player opponentPlayer = gui.getGame().getOpponent();
        game.getCurrentPlayer().attack(monster, opponentMonster, opponentPlayer);
        gui.getInfoPanel().getOpponentLifepointsPanel().setText("LIFEPOINTS: " + Integer.toString(opponentPlayer.getLifepoints()));
        if(opponentMonster.getAttack() < monster.getAttack()){
            int index = gui.getMonsterTarget().getIndex();
            ImageIcon monsterCardZone = new ImageIcon(gui.getClass().getResource("resources/monsterCardZone.jpg"));
            FieldCardButton monsterCardZoneButton = new FieldCardButton(monsterCardZone);
            monsterCardZoneButton.addMouseListener(new SelectFieldCardListener(monsterCardZoneButton, gui));
            monsterCardZoneButton.setIndex(index);
            gui.getOpponentPlayer().getFieldPanel().getMonsterPanel().remove(index);
            gui.getOpponentPlayer().getFieldPanel().getMonsterPanel().add(monsterCardZoneButton, index);

        }
        gui.getInfoPanel().repaint();
        gui.getInfoPanel().revalidate();


    }
}
