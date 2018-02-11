package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MonsterButton extends JButton {

    private int index;
    private boolean highlighted;

    public MonsterButton(ImageIcon imageIcon){
        this.setIcon(imageIcon);
        this.highlighted = false;
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
}
