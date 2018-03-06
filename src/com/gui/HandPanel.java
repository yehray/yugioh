package com.gui;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HandPanel extends JPanel{
    private ArrayList<HandButton> handButtons;
    private JPanel hand;
    OverlapLayout layout;
    private JPanel cardControlPanel;
    private PlayerPanel playerPanel;
    private GUI gui;

    public HandPanel(GUI addedGUI){
        this.setOpaque(false);
        gui = addedGUI;
        cardControlPanel = gui.getCardControlPanel();
        playerPanel = gui.getActivePlayer();
        hand = new JPanel();
        layout = new OverlapLayout(new Point(25, 0));
        layout.setPopupInsets(new Insets(15,10,0,0));
        hand.setLayout(layout);
        hand.setOpaque(false);
        handButtons = new ArrayList<HandButton>();
        this.setLayout(new FlowLayout());
        this.add(hand);
        this.setOpaque(false);
    }


    public OverlapLayout getCurrentLayout() {
        return layout;
    }

    public JPanel getHand(){
        return hand;
    }

    public ArrayList<HandButton> getHandButtons() {
        return handButtons;
    }
}
