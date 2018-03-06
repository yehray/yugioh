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
    public SummonMonsterListener(GUI currentGUI, HandButton hb){
        handButton = hb;
        monsterCard = handButton.getCard();
        gui = currentGUI;

    }

    public void mouseClicked(MouseEvent e) {
        if(handButton.isClicked()) {
            gui.summonMonster(handButton, gui.getActivePlayer());
            fieldPanel.revalidate();
            fieldPanel.repaint();
        }
    }
}

