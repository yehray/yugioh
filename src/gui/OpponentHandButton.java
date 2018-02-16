package gui;

import game.Card;
import game.MonsterCard;

import javax.swing.*;
import java.awt.*;

public class OpponentHandButton extends JButton {
    private MonsterCard card;
    private boolean isClicked;
    private Object cardSource;

    public OpponentHandButton(ImageIcon imageIcon, MonsterCard c){
        isClicked = false;
        RotatedIcon r1 = new RotatedIcon(imageIcon, RotatedIcon.Rotate.UPSIDE_DOWN);
        this.setIcon(r1);
        card = c;
        cardSource = null;
        this.setPreferredSize(new Dimension(100, 150));
    }

    public MonsterCard getCard() {
        return card;
    }

    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setCardSource(Object cardSource) {
        this.cardSource = cardSource;
    }

    public Object getCardSource() {
        return cardSource;
    }
}
