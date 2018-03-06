package com.gui;

import javax.swing.*;
import java.awt.*;

public class FieldCardButton extends JButton {

    private boolean highlighted;
    private int index;


    public FieldCardButton(ImageIcon imageIcon){
        highlighted = false;
        this.setIcon(imageIcon);
        this.setPreferredSize(new Dimension(100,150));
    }

    public boolean isHighlighted() {
        return highlighted;
    }

    public void setHighlighted(boolean highlighted) {
        this.highlighted = highlighted;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}