package gui.listeners;

import gui.GUI;
import gui.MonsterButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SelectFieldCardListener extends MouseAdapter{
    JButton fieldMonsterButton;
    JPanel cardControlPanel;
    JButton attackButton;
    JButton defenseModeButton;
    private boolean isFirstClick;


    public SelectFieldCardListener(MonsterButton monsterButton, GUI gui){
        isFirstClick = true;
        fieldMonsterButton = monsterButton;
        cardControlPanel = gui.getCardControlPanel();

        attackButton = new JButton("ATTACK");
        attackButton.setBounds(275,40, 125,50);
        attackButton.addMouseListener(new AttackListener());

        defenseModeButton = new JButton("DEFENSE MODE");
        defenseModeButton.setBounds(275,150, 125,50);
        defenseModeButton.addMouseListener(new AttackListener());

    }

    public void mouseClicked(MouseEvent e) {
        if(this.isFirstClick){
            fieldMonsterButton.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
            cardControlPanel.add(attackButton);
            cardControlPanel.add(defenseModeButton);
            cardControlPanel.revalidate();
            cardControlPanel.repaint();
            this.isFirstClick = false;
        }
        else {
            fieldMonsterButton.setBorder(BorderFactory.createEmptyBorder());
            cardControlPanel.revalidate();
            cardControlPanel.repaint();
            this.isFirstClick = true;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        fieldMonsterButton.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        fieldMonsterButton.setBorder(BorderFactory.createEmptyBorder());
    }

}
