package com.gui.listeners;

import com.game.Card;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShowLargerImage extends MouseAdapter{
    private JPanel cardControlPanel;
    private Card card;
    private boolean isFirstClick;
    private JLabel picLabel;
    private JLabel backLabel;


    public ShowLargerImage(JPanel addedPanel, Card addedCard){
        cardControlPanel = addedPanel;
        card = addedCard;
        isFirstClick = true;
        picLabel = new JLabel(card.getImageLarge());
//        backLabel = new JLabel(new ImageIcon(this.getClass().getResource("/com.gui/resources/yugiohCardBackground Large.jpg")));
    }

    public void mouseClicked(MouseEvent e) {

        Component[] componentList = cardControlPanel.getComponents();

        for(Component c : componentList){
            cardControlPanel.remove(c);
        }
        picLabel.setSize(250,375);
        cardControlPanel.add(picLabel);
        cardControlPanel.revalidate();
        cardControlPanel.repaint();
    }
}
