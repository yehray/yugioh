package com.gui;

import com.gui.listeners.EndTurnListener;
import com.gui.listeners.OpponentStrategyListener;
import com.gui.listeners.PhaseListener;

import javax.swing.*;
import java.awt.*;

public class PhaseControlPanel extends JPanel {

    private GUI gui;
    private JButton endTurnButton;
    private OpponentStrategyListener strategyListener;

    public PhaseControlPanel(GUI addedGUI){
        gui = addedGUI;
        ImageIcon buttonBackground = new ImageIcon(this.getClass().getResource("resources/buttonBackGround.jpg"));

        this.setOpaque(false);
        GridLayout layout = new GridLayout(2,1);
        layout.setVgap(10);
        this.setLayout(layout);
	
        JButton endPhaseButton = new JButton("END PHASE");
        endPhaseButton.addMouseListener(new PhaseListener(gui));
        endTurnButton = new JButton("END TURN");
        endTurnButton.addMouseListener(new EndTurnListener(gui));

        this.add(endPhaseButton);
        this.add(endTurnButton);

    }

    public void addStrategy(){
        strategyListener = new OpponentStrategyListener(gui);
        endTurnButton.addMouseListener(strategyListener);
    }

}
