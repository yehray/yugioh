
package gui.listeners;


import gui.GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StartAttackListener extends MouseAdapter {
    private JLabel attackLabel;
    private GUI gui;
    private JPanel cardControlPanel;
    private JButton attackButton;
    private JButton defenseModeButton;
    private JButton executeAttackButton;

    public StartAttackListener(GUI addedGUI, JButton atkButton, JButton dfsButton){

        gui = addedGUI;
        cardControlPanel = gui.getCardControlPanel();
        attackButton = atkButton;
        defenseModeButton = dfsButton;

        attackLabel = new JLabel("<html>SELECT<br> MONSTER TO<br> ATTACK</html>");
        attackLabel.setFont(new Font("Papyrus", Font.BOLD, 20));
        attackLabel.setForeground(Color.WHITE);
        attackLabel.setBounds(275,0, 200,400);

        executeAttackButton = new JButton("ATTACK");
        executeAttackButton.setBounds(275,40, 125,50);
        executeAttackButton.addMouseListener(new AttackListener());
    }

    public void mouseClicked(MouseEvent e) {
        cardControlPanel.remove(attackButton);
        cardControlPanel.remove(defenseModeButton);

        cardControlPanel.add(attackLabel);
        cardControlPanel.add(executeAttackButton);
        cardControlPanel.revalidate();
        cardControlPanel.repaint();
    }
}

