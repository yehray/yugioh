package gui;

import game.Card;
import game.MonsterCard;
import gui.listeners.HighlightArea;
import gui.listeners.PopUpListener;
import gui.listeners.ShowLargerImage;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class HandPanel extends JPanel{
    private ArrayList<HandButton> handButtons;
    private JPanel handPanel;
    OverlapLayout layout;
    private JPanel panel;


    public HandPanel(JPanel addedPanel){
        panel = addedPanel;
        handPanel = new JPanel();
        layout = new OverlapLayout(new Point(25, 0));
        layout.setPopupInsets(new Insets(15,10,0,0));
        handPanel.setLayout(layout);
        handButtons = new ArrayList<HandButton>();
        this.setLayout(new FlowLayout());
        this.add(handPanel);
        this.setOpaque(false);

        MonsterCard summonedSkull = new MonsterCard("Summoned Skull", 5, 2500, 1300);
        MonsterCard blueEyes = new MonsterCard("Blue Eyes White Dragon", 8, 3000, 2500);

        addButton(summonedSkull);
        addButton(blueEyes);


    }

    public void addButton(Card card){
        HandButton addedCard = new HandButton(card.getImageSmall());
        addedCard.addMouseListener(new HighlightArea(addedCard));
        addedCard.addMouseListener(new PopUpListener(layout));
        addedCard.addMouseListener(new ShowLargerImage(panel, card));
        handPanel.add(addedCard);
        addedCard.setVisible(true);
        addedCard.validate();
        
    }

}
