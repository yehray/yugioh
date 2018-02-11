package gui;

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

            int total = 8000;

            JLabel lifePoints = new JLabel("LIFEPOINTS");
            lifePoints.setFont(new Font("Arial", Font.BOLD, 20));
            lifePoints.setForeground(Color.WHITE);
            lifepointsLabel = lifePoints;

            JLabel currentPhase = new JLabel("MAIN PHASE 1");
            currentPhase.setBounds(0,0,100,100);
            currentPhase.setFont(new Font("Arial", Font.BOLD, 22));
            currentPhase.setForeground(Color.WHITE);
            currentPhase.setVerticalAlignment(JLabel.BOTTOM);
            currentPhaseLabel = currentPhase;

            JLabel opponentLifePoints = new JLabel("LIFEPOINTS");
            opponentLifePoints.setFont(new Font("Arial", Font.BOLD, 20));
            opponentLifePoints.setForeground(Color.WHITE);
            opponentLifepointsLabel = opponentLifePoints;

            this.add(lifePoints, layout.SOUTH);
            this.add(currentPhase, layout.CENTER);
            this.add(opponentLifePoints, layout.NORTH);
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
