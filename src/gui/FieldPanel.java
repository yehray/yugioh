package gui;

import game.MonsterCard;
import game.SpellCard;

import javax.swing.*;
import java.awt.*;

public class FieldPanel extends JPanel{
    private JPanel monsterPanel;
    private JPanel spellPanel;

    public FieldPanel(){
        JPanel monsterPanel = new JPanel();
        JPanel spellPanel = new JPanel();
        this.setLayout(new GridLayout(2,1));
        this.add(monsterPanel);
        this.add(spellPanel);
    }

    public MonsterButton summonMonster(MonsterCard monsterCard){
        GetCardImage cardImage = new GetCardImage(monsterCard);
        MonsterButton monsterButton = new MonsterButton(cardImage.getCardImage());
        monsterPanel.add(monsterButton);
        return monsterButton;
    }

    public SpellButton summonMonster(SpellCard spellCard){
        GetCardImage cardImage = new GetCardImage(spellCard);
        SpellButton spellButton = new SpellButton(cardImage.getCardImage());
        spellPanel.add(spellButton);
        return spellButton;
    }
}
