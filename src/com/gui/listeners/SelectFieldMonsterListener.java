package com.gui.listeners;

import com.gui.FieldCardButton;
import com.gui.GUI;
import com.gui.MonsterButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SelectFieldMonsterListener extends MouseAdapter{
    MonsterButton fieldMonsterButton;
    JPanel cardControlPanel;
    JButton attackButton;
    JButton defenseModeButton;
    private Object fieldSource;
    private GUI gui;
    private ArrayList<MonsterButton> monstersOnField;
    private ArrayList<FieldCardButton> emptySpotsOnField;

    /**
     * Highlights the card when mouse hovers over card. Highlights the card and sets it as the selected card when the card is clicked.
     * Displays ATTACK and DEFENSE MODE buttons when the card is clicked.
     */
    public SelectFieldMonsterListener(MonsterButton monsterButton, GUI addedGUI){
        gui = addedGUI;
        fieldMonsterButton = monsterButton;
        cardControlPanel = gui.getCardControlPanel();
        monstersOnField = gui.getActivePlayer().getFieldPanel().getMonsterCardsOnField();
        emptySpotsOnField = gui.getActivePlayer().getFieldPanel().getEmptySpotsOnField();

        attackButton = new JButton("ATTACK");
        attackButton.setBounds(275,40, 125,50);

        defenseModeButton = new JButton("SWITCH MODE");
        defenseModeButton.setBounds(275,150, 125,50);

        attackButton.addMouseListener(new StartAttackListener(gui, attackButton, defenseModeButton, fieldMonsterButton));
        defenseModeButton.addMouseListener(new DefenseModeListener(gui));

        cardControlPanel.remove(1);
        cardControlPanel.add(attackButton);
        cardControlPanel.add(defenseModeButton);
        cardControlPanel.revalidate();
        cardControlPanel.repaint();

    }

    public void mouseClicked(MouseEvent e) {
        fieldSource = e.getSource();
        gui.setMonsterSelected(fieldMonsterButton);
        if(!fieldMonsterButton.isHighlighted()){
            for (int i = 0; i < monstersOnField.size(); i++) {
                monstersOnField.get(i).setBorder(BorderFactory.createEmptyBorder());
                monstersOnField.get(i).setHighlighted(false);
            }
            for (int i = 0; i < emptySpotsOnField.size(); i++) {
                emptySpotsOnField.get(i).setBorder(BorderFactory.createEmptyBorder());
                emptySpotsOnField.get(i).setHighlighted(false);
            }
            fieldMonsterButton.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
            fieldMonsterButton.setHighlighted(true);
            cardControlPanel.add(attackButton);
            cardControlPanel.add(defenseModeButton);
            cardControlPanel.revalidate();
            cardControlPanel.repaint();
        }
        else {
            fieldMonsterButton.setBorder(BorderFactory.createEmptyBorder());
            for(int i = 0; i < cardControlPanel.getComponents().length; i++){
                cardControlPanel.remove(i);
            }
            fieldMonsterButton.setHighlighted(false);
        }
        fieldMonsterButton.revalidate();
        fieldMonsterButton.repaint();
    }

    public Object getFieldSource() {
        return fieldSource;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(!fieldMonsterButton.isHighlighted()) {
            fieldMonsterButton.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(!fieldMonsterButton.isHighlighted()) {
            fieldMonsterButton.setBorder(BorderFactory.createEmptyBorder());
        }
    }



}
