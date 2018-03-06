package com.gui;

import com.game.MonsterCard;

import javax.swing.*;
import java.awt.*;

public class HandButton extends JButton {
    private MonsterCard card;
    private boolean isClicked;
    private Object cardSource;
    private int index;

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

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
