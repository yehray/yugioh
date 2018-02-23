package gui.listeners;

import game.OpponentPlayerStrategy;
import gui.GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OpponentStrategyListener extends MouseAdapter{
    private GUI gui;
    public OpponentStrategyListener(GUI addedGUI){
        gui = addedGUI;

    }

    public void mouseClicked(MouseEvent e) {
        System.out.println("This");
        OpponentPlayerStrategy opponentPlayerStrategy = new OpponentPlayerStrategy(gui.getGame(), gui);
    }
}
