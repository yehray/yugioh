package gui.listeners;

import game.Game;
import gui.GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PhaseListener extends MouseAdapter{
    private GUI gui;
    private Game game;

    public PhaseListener(GUI addedGUI){
        gui = addedGUI;
        game = gui.getGame();

    }


    public void mouseClicked(MouseEvent e) {
        String currentPhase = game.getCurrentPlayer().getField().getPhase();
        game.getCurrentPlayer().endPhase(currentPhase);
        String newPhase = game.getCurrentPlayer().getField().getPhase();
        String currentPlayer = game.getCurrentPlayer().getPlayerName();

        gui.getInfoPanel().getCurrentPhasePanel().setText("<html>" + currentPlayer + "<br>" + newPhase + "</html>");

        if(newPhase == "MAIN PHASE 2"){
            gui.getPhaseControlPanel().remove(0);
        }
    }
}
