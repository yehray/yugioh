package gui.listeners;

import game.Game;
import gui.GUI;
import gui.PhaseControlPanel;

import javax.swing.*;
import java.awt.*;
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
        String currentPlayer = game.getCurrentPlayer().getPlayerName();
        gui.getInfoPanel().getCurrentPhasePanel().setText("<html>" + currentPlayer + "<br> MAIN PHASE 1 </html>");
        JPanel phaseControlPanel = new PhaseControlPanel(gui);
        phaseControlPanel.setBounds(1180,620,140,105);
        gui.add(phaseControlPanel);
        Component[] componentList = cardControlPanel.getComponents();
        for(Component c : componentList){
            cardControlPanel.remove(c);
        }
        cardControlPanel.revalidate();
        cardControlPanel.repaint();
    }
}
