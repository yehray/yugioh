package gui.listeners;

import gui.FieldCardButton;
import gui.GUI;
import gui.MonsterButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SelectFieldCardListener extends MouseAdapter{
    private FieldCardButton fieldCardButton;
    private ArrayList<MonsterButton> monstersOnField;
    private ArrayList<FieldCardButton> emptySpotsOnField;
    private GUI gui;
    private JPanel cardControlPanel;

    public SelectFieldCardListener(FieldCardButton fieldButton, GUI addedGUI){
        gui = addedGUI;
        fieldCardButton = fieldButton;
        monstersOnField = gui.getActivePlayer().getFieldPanel().getMonsterCardsOnField();
        emptySpotsOnField = gui.getActivePlayer().getFieldPanel().getEmptySpotsOnField();
        cardControlPanel = gui.getCardControlPanel();
    }


    public void mouseClicked(MouseEvent e) {
        if(!fieldCardButton.isHighlighted()) {

            for (int i = 0; i < monstersOnField.size(); i++) {
                monstersOnField.get(i).setBorder(BorderFactory.createEmptyBorder());
                monstersOnField.get(i).setHighlighted(false);
            }
            for (int i = 0; i < emptySpotsOnField.size(); i++) {
                emptySpotsOnField.get(i).setBorder(BorderFactory.createEmptyBorder());
                emptySpotsOnField.get(i).setHighlighted(false);
            }

            fieldCardButton.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
            fieldCardButton.setHighlighted(true);

        }
        else {
            fieldCardButton.setBorder(BorderFactory.createEmptyBorder());
            fieldCardButton.setHighlighted(false);
        }
        fieldCardButton.revalidate();
        fieldCardButton.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(!fieldCardButton.isHighlighted()) {
            fieldCardButton.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(!fieldCardButton.isHighlighted()) {
            fieldCardButton.setBorder(BorderFactory.createEmptyBorder());
        }
    }



}
