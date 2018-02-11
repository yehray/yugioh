package gui;

import game.Card;
import game.MonsterCard;

import javax.swing.*;
import java.awt.*;

public class HandButton extends JButton {
    private MonsterCard card;
    private boolean isClicked;
    private Object cardSource;

    public HandButton(ImageIcon imageIcon, MonsterCard c){
        isClicked = false;
        this.setIcon(imageIcon);
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
