package gui;

import game.MonsterCard;

import javax.swing.*;
import java.awt.*;

public class DefenseMonsterButton extends MonsterButton {

    private int index;
    private boolean highlighted;
    private MonsterCard monsterCard;

    public DefenseMonsterButton(ImageIcon imageIcon, MonsterCard addedMonsterCard){
        Image img = imageIcon.getImage() ;
        Image newimg = img.getScaledInstance( 75, 100,  java.awt.Image.SCALE_SMOOTH ) ;
        RotatedIcon rotated = new RotatedIcon(new ImageIcon( newimg ), RotatedIcon.Rotate.DOWN);
        this.setIcon(rotated);
        monsterCard = addedMonsterCard;
        highlighted = false;
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);


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
