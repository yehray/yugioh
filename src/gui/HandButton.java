package gui;

import game.Card;
import game.MonsterCard;

import javax.swing.*;
import java.awt.*;

public class HandButton extends JButton {
    private MonsterCard card;
    private boolean isClicked;

    public HandButton(ImageIcon imageIcon, MonsterCard c){
        isClicked = false;
        this.setIcon(imageIcon);
        card = c;
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
}
