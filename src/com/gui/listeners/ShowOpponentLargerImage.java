package com.gui.listeners;

import com.game.Card;
import com.gui.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShowOpponentLargerImage extends MouseAdapter{
    private JPanel cardControlPanel;
    private Card card;
    private boolean isFirstClick;
    private JLabel picLabel;
    private JLabel backLabel;
    private GUI gui;


    public ShowOpponentLargerImage(JPanel addedPanel, Card addedCard, GUI addedGUI){
        cardControlPanel = addedPanel;
        gui = addedGUI;
        card = addedCard;
        isFirstClick = true;
        picLabel = new JLabel(card.getImageLarge());
//        backLabel = new JLabel(new ImageIcon(this.getClass().getResource("/com.gui/resources/yugiohCardBackground Large.jpg")));
    }

    public void mouseClicked(MouseEvent e) {
        if(gui.getGame().getPlayer().getField().getPhase() != "BATTLE PHASE") {

            Component[] componentList = cardControlPanel.getComponents();

            for (Component c : componentList) {
                cardControlPanel.remove(c);
            }
            picLabel.setSize(250, 375);
            cardControlPanel.add(picLabel);
            cardControlPanel.revalidate();
            cardControlPanel.repaint();
        }
    }
}
