package gui;

import game.MonsterCard;
import game.SpellCard;
import gui.listeners.HighlightArea;

import javax.swing.*;
import java.awt.*;

public class FieldPanel extends JPanel{
    private JPanel monsterPanel;
    private JPanel spellPanel;
    private JPanel cardControlPanel;
    private PlayerPanel playerPanel;

    public FieldPanel(GUI gui){
        cardControlPanel = gui.getCardControlPanel();
        playerPanel = gui.getActivePlayer();

        this.setOpaque(false);
        this.setLayout(null);

        OverlapLayout cardZoneLayout = new OverlapLayout(new Point(145, 0));
        OverlapLayout spellZoneLayout = new OverlapLayout(new Point(145, 0));


        monsterPanel = new JPanel();
        monsterPanel.setBounds(160,10,850,180);
        monsterPanel.setLayout(cardZoneLayout);
        this.add(monsterPanel);
        monsterPanel.setOpaque(false);

        spellPanel = new JPanel();
        spellPanel.setBounds(160,180,850,170);
        spellPanel.setLayout(spellZoneLayout);
        this.add(spellPanel);
        spellPanel.setOpaque(false);

        ImageIcon monsterCardZone = new ImageIcon(this.getClass().getResource("resources/monsterCardZone.jpg"));
        ImageIcon spellCardZone = new ImageIcon(this.getClass().getResource("resources/spellCardZone.jpg"));


        for(int i = 0; i < 5; i++){
            MonsterButton monsterCardZoneButton = new MonsterButton(monsterCardZone);
            monsterCardZoneButton.addMouseListener(new HighlightArea(monsterCardZoneButton, cardControlPanel));
            monsterPanel.add(monsterCardZoneButton);

            SpellButton spellCardZoneButton = new SpellButton(spellCardZone);
            spellCardZoneButton.addMouseListener(new HighlightArea(spellCardZoneButton, cardControlPanel));
            spellPanel.add(spellCardZoneButton);
        }



    }

    public JPanel getMonsterPanel() {
        return monsterPanel;
    }

    //    public SpellButton summonMonster(SpellCard spellCard){
//        GetCardImage cardImage = new GetCardImage(spellCard, "s'");
//        SpellButton spellButton = new SpellButton(cardImage.getCardImage());
//        spellPanel.add(spellButton);
//        return spellButton;
//    }
}
