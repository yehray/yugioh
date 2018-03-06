package com.gui;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel{
        private GUI gui;
        private JLabel lifepointsLabel;
        private JLabel currentPhaseLabel;
        private JLabel opponentLifepointsLabel;


        public InfoPanel(GUI addedGUI){
            gui = addedGUI;
            BorderLayout layout = new BorderLayout();
            layout.setVgap(30);
            this.setLayout(layout);
            this.setOpaque(false);
            String currentPlayer = gui.getGame().getPlayer().getPlayerName();
            String currentPhase = gui.getGame().getPlayer().getField().getPhase();
            int playerLP = gui.getGame().getPlayer().getLifepoints();
            int opponentLP = gui.getGame().getOpponent().getLifepoints();

            int total = 8000;

            lifepointsLabel = new JLabel("LIFEPOINTS: " + playerLP);
            lifepointsLabel.setFont(new Font("Papyrus", Font.BOLD, 20));
            lifepointsLabel.setForeground(Color.WHITE);


            JPanel phaseInfo = new JPanel();

            currentPhaseLabel = new JLabel("<html>" + currentPlayer + "<br>" + currentPhase + "</html>");
            currentPhaseLabel.setBounds(0,0,100,100);
            currentPhaseLabel.setFont(new Font("Papyrus", Font.BOLD, 22));
            currentPhaseLabel.setForeground(Color.WHITE);
            currentPhaseLabel.setVerticalAlignment(JLabel.BOTTOM);

            opponentLifepointsLabel = new JLabel("LIFEPOINTS: " + opponentLP);
            opponentLifepointsLabel.setFont(new Font("Papyrus", Font.BOLD, 20));
            opponentLifepointsLabel.setForeground(Color.WHITE);

            this.add(lifepointsLabel, layout.SOUTH);
            this.add(currentPhaseLabel, layout.CENTER);
            this.add(opponentLifepointsLabel, layout.NORTH);
        }

    public JLabel getCurrentPhasePanel() {
        return currentPhaseLabel;
    }

    public JLabel getLifepointsPanel() {
        return lifepointsLabel;
    }

    public JLabel getOpponentLifepointsPanel() {
        return opponentLifepointsLabel;
    }
}
