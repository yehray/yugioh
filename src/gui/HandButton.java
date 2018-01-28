package gui;

import javax.swing.*;
import java.awt.*;

public class HandButton extends JButton {

    private boolean firstClick;

    public HandButton(ImageIcon imageIcon){
        firstClick = true;
        this.setIcon(imageIcon);
        this.setPreferredSize(new Dimension(100, 150));

    }

    public boolean isFirstClick() {
        return firstClick;
    }

    public void setFirstClick(boolean firstClick) {
        this.firstClick = firstClick;
    }
}
