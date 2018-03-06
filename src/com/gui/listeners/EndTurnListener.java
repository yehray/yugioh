package com.gui.listeners;

import com.game.Game;
import com.gui.GUI;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EndTurnListener extends MouseAdapter {
    private GUI gui;
    private Game game;
    JPanel cardControlPanel;

    public EndTurnListener(GUI addedGUI){
        gui = addedGUI;
        game = gui.getGame();
        cardControlPanel = addedGUI.getCardControlPanel();

    }


    public void mouseClicked(MouseEvent e) {
        game.getPlayer().endTurn();
        game.switchPlayer();
        String currentPlayer = game.getOpponent().getPlayerName();
        gui.getInfoPanel().getCurrentPhasePanel().setText("<html>" + currentPlayer + "<br> MAIN PHASE 1 </html>");
        cardControlPanel.revalidate();
        cardControlPanel.repaint();
    }
}
