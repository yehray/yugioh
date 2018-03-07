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

    /**
     * Starts opponent's turn when END TURN button is clicked. Opponent plays based on the opponent strategy that is set.
     */
    public void mouseClicked(MouseEvent e) {
        opponentPlayerStrategy.drawCard();
        opponentPlayerStrategy.summonMonster();
        opponentPlayerStrategy.attack();
        opponentPlayerStrategy.endTurn();
    }
}
