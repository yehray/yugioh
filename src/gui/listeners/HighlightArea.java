package gui.listeners;

import gui.GUI;
import gui.HandButton;
import gui.OverlapLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class HighlightArea extends MouseAdapter{

    private JButton button;
    private boolean isFirstClick;

    public HighlightArea(JButton addedButton){
        button = addedButton;
        isFirstClick = true;
    }

    public void mouseClicked(MouseEvent e) {
        if(this.isFirstClick){
            button.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
            this.isFirstClick = false;
        }
        else {
            button.setBorder(BorderFactory.createEmptyBorder());
            this.isFirstClick = true;
        }
    }



}
