package gui;

import game.MonsterCard;
import game.SpellCard;
import gui.listeners.HighlightArea;
import gui.listeners.SelectFieldCardListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FieldPanel extends JPanel{
    private JPanel monsterPanel;
    private JPanel spellPanel;
    private JPanel cardControlPanel;
    private PlayerPanel playerPanel;
    private ArrayList<FieldCardButton> emptySpotsOnField;
    private ArrayList<MonsterCard> monsterCardsOnField;

    public FieldPanel(GUI gui){
        cardControlPanel = gui.getCardControlPanel();
        playerPanel = gui.getActivePlayer();

        emptySpotsOnField = new ArrayList<FieldCardButton>();
        monsterCardsOnField = new ArrayList<MonsterCard>();


        this.setOpaque(false);
        this.setLayout(null);

        OverlapLayout monsterZoneLayout = new OverlapLayout(new Point(145, 0));
        OverlapLayout spellZoneLayout = new OverlapLayout(new Point(145, 0));


        monsterPanel = new JPanel();
        monsterPanel.setBounds(160,10,850,180);
        monsterPanel.setLayout(monsterZoneLayout);
        this.add(monsterPanel);
        monsterPanel.setOpaque(false);

        spellPanel = new JPanel();
        spellPanel.setBounds(160,180,850,170);
        spellPanel.setLayout(spellZoneLayout);
        this.add(spellPanel);
        spellPanel.setOpaque(false);





    }

    public JPanel getMonsterPanel() {
        return monsterPanel;
    }

    public ArrayList<MonsterCard> getMonsterCardsOnField() {
        return monsterCardsOnField;
    }

    public ArrayList<FieldCardButton> getEmptySpotsOnField() {
        return emptySpotsOnField;
    }

    public JPanel getSpellPanel() {
        return spellPanel;
    }

    //    public SpellButton summonMonster(SpellCard spellCard){
//        GetCardImage cardImage = new GetCardImage(spellCard, "s'");
//        SpellButton spellButton = new SpellButton(cardImage.getCardImage());
//        spellPanel.add(spellButton);
//        return spellButton;
//    }
}
