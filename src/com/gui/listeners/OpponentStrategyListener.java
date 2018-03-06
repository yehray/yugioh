package com.gui.listeners;

import com.game.OpponentPlayerStrategy;
import com.gui.GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OpponentStrategyListener extends MouseAdapter{
    private GUI gui;
    private OpponentPlayerStrategy opponentPlayerStrategy;
    public OpponentStrategyListener(GUI addedGUI){
        gui = addedGUI;
        opponentPlayerStrategy = gui.getOpponentPlayerStrategy();
    }

    public void mouseClicked(MouseEvent e) {
        opponentPlayerStrategy.drawCard();
        opponentPlayerStrategy.summonMonster();
        opponentPlayerStrategy.attack();
        opponentPlayerStrategy.endTurn();
    }
}
