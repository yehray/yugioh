package gui.listeners;

import game.MonsterCard;
import gui.FieldPanel;
import gui.GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SummonMonsterListener extends MouseAdapter {
    private FieldPanel fieldPanel;
    private MonsterCard monsterCard;
    private GUI gui;
    public SummonMonsterListener(GUI currentGUI, MonsterCard summonedMonster){
        monsterCard = summonedMonster;
        gui = currentGUI;

    }

    public void mouseClicked(MouseEvent e) {
        gui.summonMonster(monsterCard);
        fieldPanel.revalidate();
        fieldPanel.repaint();
    }
}

