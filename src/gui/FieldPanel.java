package gui;

import game.MonsterCard;
import game.SpellCard;
import gui.listeners.HighlightArea;

import javax.swing.*;
import java.awt.*;

public class FieldPanel extends JPanel{
    private JPanel monsterPanel;
    private JPanel spellPanel;

    public FieldPanel(){
        this.setOpaque(false);
        this.setLayout(null);

//        GridLayout zoneLayout = new GridLayout(1,5);
        OverlapLayout zoneLayout = new OverlapLayout(new Point(145, 0));


        monsterPanel = new JPanel();
        monsterPanel.setBounds(160,10,850,180);
        monsterPanel.setLayout(zoneLayout);
        this.add(monsterPanel);
        monsterPanel.setOpaque(false);


        spellPanel = new JPanel();
        spellPanel.setBounds(0,190,850,180);
        this.add(spellPanel);
        spellPanel.setOpaque(false);

        ImageIcon monsterCardZone = new ImageIcon(this.getClass().getResource("resources/monsterCardZone.jpg"));
        MonsterButton monsterCardZoneButton = new MonsterButton(monsterCardZone);
        monsterCardZoneButton.addMouseListener(new HighlightArea(monsterCardZoneButton));

        monsterPanel.add(monsterCardZoneButton);
        monsterPanel.add(monsterCardZoneButton);
        monsterPanel.add(monsterCardZoneButton);
        monsterPanel.add(monsterCardZoneButton);
        monsterPanel.add(monsterCardZoneButton);






    }

    public MonsterButton summonMonster(MonsterCard monsterCard){
        MonsterButton monsterButton = new MonsterButton(monsterCard.getImageSmall());
        monsterPanel.add(monsterButton);
        return monsterButton;
    }

//    public SpellButton summonMonster(SpellCard spellCard){
//        GetCardImage cardImage = new GetCardImage(spellCard, "s'");
//        SpellButton spellButton = new SpellButton(cardImage.getCardImage());
//        spellPanel.add(spellButton);
//        return spellButton;
//    }
}
