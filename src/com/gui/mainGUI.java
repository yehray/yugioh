package com.gui;

import com.game.*;

public class mainGUI {
    public static void main(String args[]){
        GUI gui = new GUI();
        gui.setPlayers();
        gui.setPanels();
        gui.setGame(gui.getActivePlayer());
        gui.setGame(gui.getOpponentPlayer());
        gui.drawStartingHand();

        OpponentPlayerStrategy opponentPlayerStrategy = new OpponentPlayerStrategy(gui.getGame(), gui);
        gui.setOpponentPlayerStrategy();
    }
}
