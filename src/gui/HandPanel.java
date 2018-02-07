package gui;

import game.Card;
import game.MonsterCard;
import game.Player;
import gui.listeners.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class HandPanel extends JPanel{
    private ArrayList<HandButton> handButtons;
    private JPanel hand;
    OverlapLayout layout;
    private JPanel cardControlPanel;
    private PlayerPanel playerPanel;
    private GUI gui;

    public HandPanel(GUI addedGUI){
        gui = addedGUI;
        cardControlPanel = gui.getCardControlPanel();
        playerPanel = gui.getActivePlayer();
        hand = new JPanel();
        layout = new OverlapLayout(new Point(25, 0));
        layout.setPopupInsets(new Insets(15,10,0,0));
        hand.setLayout(layout);
        handButtons = new ArrayList<HandButton>();
        this.setLayout(new FlowLayout());
        this.add(hand);
        this.setOpaque(false);

        MonsterCard summonedSkull = new MonsterCard("Summoned Skull", 5, 2500, 1300);
        MonsterCard blueEyes = new MonsterCard("Blue Eyes White Dragon", 8, 3000, 2500);



    }

    public void addButton(MonsterCard card){
        HandButton addedCard = new HandButton(card.getImageSmall(), card);
//        addedCard.addMouseListener(new SelectHandCardListener(addedCard, gui));
//        addedCard.addMouseListener(new PopUpListener(layout));
//        addedCard.addMouseListener(new ShowLargerImage(cardControlPanel, card));
        hand.add(addedCard);
        addedCard.setVisible(true);
        addedCard.validate();

    }

    public OverlapLayout getCurrentLayout() {
        return layout;
    }

    public JPanel getHand(){
        return hand;
    }
}
