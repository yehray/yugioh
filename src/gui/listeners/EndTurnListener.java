package gui.listeners;

import gui.GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EndTurnListener extends MouseAdapter {
    private GUI gui;

    public EndTurnListener(GUI addedGUI){
        gui = addedGUI;

    }


    public void mouseClicked(MouseEvent e) {
        gui.endTurn();
    }
}
