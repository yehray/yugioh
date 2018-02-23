package gui;

import gui.listeners.AttackListener;
import gui.listeners.EndTurnListener;
import gui.listeners.OpponentStrategyListener;
import gui.listeners.PhaseListener;

import javax.swing.*;
import java.awt.*;

public class PhaseControlPanel extends JPanel {

    private GUI gui;

    public PhaseControlPanel(GUI addedGUI){
        gui = addedGUI;
        ImageIcon buttonBackground = new ImageIcon(this.getClass().getResource("resources/buttonBackGround.jpg"));

        this.setOpaque(false);
        GridLayout layout = new GridLayout(2,1);
        layout.setVgap(10);
        this.setLayout(layout);

        JButton endPhaseButton = new JButton("END PHASE");
        endPhaseButton.addMouseListener(new PhaseListener(gui));
        JButton endTurnButton = new JButton("END TURN");
        endTurnButton.addMouseListener(new EndTurnListener(gui));
        endTurnButton.addMouseListener(new OpponentStrategyListener(gui));




        this.add(endPhaseButton);
        this.add(endTurnButton);




    }
}
