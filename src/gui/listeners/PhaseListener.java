package gui.listeners;

import gui.GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PhaseListener extends MouseAdapter{
    private GUI gui;

    public PhaseListener(GUI addedGUI){
        gui = addedGUI;

    }


    public void mouseClicked(MouseEvent e) {
        gui.changePhase();

    }
}
