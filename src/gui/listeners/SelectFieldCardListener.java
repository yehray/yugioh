package gui.listeners;

import gui.FieldCardButton;
import gui.GUI;
import gui.HandButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SelectFieldCardListener extends MouseAdapter{
    private FieldCardButton fieldCardButton;
    private ArrayList<FieldCardButton> emptySpotsOnField;
    private ArrayList<HandButton> handButtonsList;

    public SelectFieldCardListener(FieldCardButton fieldButton, GUI gui){
        fieldCardButton = fieldButton;
        handButtonsList = gui.getActivePlayer().getHandPanel().getHandButtons();
        emptySpotsOnField = gui.getActivePlayer().getFieldPanel().getEmptySpotsOnField();
    }

    public boolean isSelected(){
        boolean isSelected = false;
        for(int i = 0; i < handButtonsList.size(); i++){
            if(handButtonsList.get(i).isClicked()){
                isSelected = true;
                break;
            }
        }
        return isSelected;
    }


    public void mouseClicked(MouseEvent e) {
        if(isSelected()) {
            for (int i = 0; i < emptySpotsOnField.size(); i++) {
                emptySpotsOnField.get(i).setBorder(BorderFactory.createEmptyBorder());
                emptySpotsOnField.get(i).setHighlighted(false);
            }
            fieldCardButton.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
            fieldCardButton.setHighlighted(true);
            fieldCardButton.revalidate();
            fieldCardButton.repaint();
        }
    }

    

}
