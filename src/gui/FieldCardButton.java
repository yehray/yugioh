package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FieldCardButton extends JButton {

    private boolean highlighted;

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
}