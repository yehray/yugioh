package com.gui.listeners;

import com.game.MonsterCard;
import com.gui.FieldPanel;
import com.gui.GUI;
import com.gui.HandButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SummonMonsterListener extends MouseAdapter {
    private FieldPanel fieldPanel;
    private MonsterCard monsterCard;
    private GUI gui;
    private HandButton handButton;
    
    /**
     * Move selected monster from the hand to the field.
     */
    public SummonMonsterListener(GUI currentGUI, HandButton hb){
        handButton = hb;
        monsterCard = handButton.getCard();
        gui = currentGUI;
	fieldPanel = gui.getActivePlayer().getFieldPanel();
    }

    public void mouseClicked(MouseEvent e) {
        if(handButton.isClicked()) {
            gui.summonMonster(handButton, gui.getActivePlayer());
            fieldPanel.revalidate();
            fieldPanel.repaint();
        }
    }
}

