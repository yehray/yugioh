package gui.listeners;

import game.MonsterCard;
import gui.FieldPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SummonMonsterListener extends MouseAdapter {
    private FieldPanel fieldPanel;
    private MonsterCard monsterCard;
    public SummonMonsterListener(FieldPanel field, MonsterCard summonedMonster){
        fieldPanel = field;
        monsterCard = summonedMonster;

    }

    public void mouseClicked(MouseEvent e) {
        fieldPanel.summonMonster(monsterCard);
    }
}

