package gui.listeners;

import game.MonsterCard;
import gui.FieldPanel;
import gui.GUI;
import gui.HandButton;

import java.awt.*;
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
            gui.summonMonster(monsterCard);
            fieldPanel.revalidate();
            fieldPanel.repaint();
        }
    }
}

