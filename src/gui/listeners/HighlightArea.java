package gui.listeners;

import gui.GUI;
import gui.HandButton;
import gui.OverlapLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class HighlightArea extends MouseAdapter{

    private JButton button;
    private boolean isFirstClick;
    private JPanel cardControlPanel;
    private JButton attackButton;
    private JButton defenseModeButton;

    public HighlightArea(JButton addedButton, JPanel addedPanel){
        button = addedButton;
        cardControlPanel = addedPanel;
        isFirstClick = true;


    }

    public void mouseClicked(MouseEvent e) {
//        if(this.isFirstClick){
//            button.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
//
//            JButton attackButton = new JButton("ATTACK");
//            attackButton.setBounds(300,0, 125,50);
//            JButton defenseModeButton = new JButton("SWITCH TO DEFENSE MODE");
//            defenseModeButton.setBounds(300,50, 125,75);
//            cardControlPanel.add(attackButton);
//            cardControlPanel.add(defenseModeButton);
//            cardControlPanel.revalidate();
//            this.isFirstClick = false;
//        }
//        else {
//            button.setBorder(BorderFactory.createEmptyBorder());
//            this.isFirstClick = true;
//        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        button.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(this.isFirstClick) {
            button.setBorder(BorderFactory.createEmptyBorder());
        }
    }



}
