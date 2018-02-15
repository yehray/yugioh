package gui.listeners;

import gui.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EndTurnListener extends MouseAdapter {
    private GUI gui;
    JPanel cardControlPanel;

    public EndTurnListener(GUI addedGUI){
        gui = addedGUI;
        cardControlPanel = addedGUI.getCardControlPanel();

    }


    public void mouseClicked(MouseEvent e) {
        gui.endTurn();
        Component[] componentList = cardControlPanel.getComponents();
        for(Component c : componentList){
            cardControlPanel.remove(c);
        }
        cardControlPanel.revalidate();
        cardControlPanel.repaint();
    }
}
