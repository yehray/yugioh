package com.gui;

import com.game.MonsterCard;

import javax.swing.*;
import java.awt.*;

public class MonsterButton extends JButton {

    private int index;
    private boolean highlighted;
    private MonsterCard monsterCard;

    public MonsterButton(){

    }

    public MonsterButton(ImageIcon imageIcon, MonsterCard addedMonsterCard){
        this.setIcon(imageIcon);
        monsterCard = addedMonsterCard;
        highlighted = false;
        this.setPreferredSize(new Dimension(100,150));

    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setHighlighted(boolean highlighted) {
        this.highlighted = highlighted;
    }

    public boolean isHighlighted() {
        return highlighted;
    }

    public MonsterCard getMonsterCard() {
        return monsterCard;
    }
}
