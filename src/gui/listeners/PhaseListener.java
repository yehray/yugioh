package gui.listeners;

import game.Game;
import gui.GUI;
import gui.exceptions.EndTurnException;
import gui.exceptions.WrongPhaseException;

import javax.swing.*;
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
        String currentPhase = game.getPlayer().getField().getPhase();
        game.getCurrentPlayer().endPhase(currentPhase);
        String newPhase = game.getPlayer().getField().getPhase();
        String currentPlayer = game.getPlayer().getPlayerName();

        gui.getInfoPanel().getCurrentPhasePanel().setText("<html>" + currentPlayer + "<br>" + newPhase + "</html>");

        if(currentPhase == "MAIN PHASE 2"){
            JOptionPane.showMessageDialog(null, "Must end turn after main phase 2");
            throw new EndTurnException("Must end turn after main phase 2");
        }
    }
}
