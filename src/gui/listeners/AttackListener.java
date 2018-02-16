package gui.listeners;

import game.Game;
import game.MonsterCard;
import game.Player;
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
        game.getCurrentPlayer().getField().setPhase("BATTLE PHASE");
        game.getCurrentPlayer().attack(monster, opponentMonster, opponentPlayer);
        System.out.println(gui.getGame().getOpponent().getLifepoints());
        gui.getInfoPanel().getOpponentLifepointsPanel().setText("LIFEPOINTS: " + Integer.toString(opponentPlayer.getLifepoints()));
        gui.getInfoPanel().repaint();
        gui.getInfoPanel().revalidate();


    }
}
