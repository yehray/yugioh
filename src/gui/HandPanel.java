package gui;

import game.Card;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class HandPanel extends JPanel implements MouseListener{
    private ArrayList<HandButton> handButtons;
    private JPanel handPanelP1;
    private JPanel handPanelP2;

    OverlapLayout layout;


    public HandPanel(){
        JPanel handPanelP1 = new JPanel();
        JPanel handPanelP2 = new JPanel();

        layout = new OverlapLayout(new Point(25, 0));
        layout.setPopupInsets(new Insets(17,4,0,0));
        handPanelP1.setLayout(layout);
        handPanelP2.setLayout(layout);

        handButtons = new ArrayList<HandButton>();
        this.setLayout(new FlowLayout());
        this.add(handPanelP1);
        this.add(handPanelP2);
    }

    public void addButton(Card card){
        GetCardImage cardImage = new GetCardImage(card);
        HandButton addedCard = new HandButton(cardImage.getCardImage());
        handPanelP1.add(addedCard);
        handButtons.add(addedCard);
        addedCard.setVisible(true);
        addedCard.validate();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Component c = e.getComponent();
        layout.addLayoutComponent(c, OverlapLayout.POP_UP);
        c.getParent().invalidate();
        c.getParent().validate();

    }

    @Override
    public void mouseExited(MouseEvent e) {
        Component c = e.getComponent();
        layout.addLayoutComponent(c, OverlapLayout.POP_DOWN);
        c.getParent().invalidate();
        c.getParent().validate();
    }
}
