package com.gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FieldPanel extends JPanel{
    private JPanel monsterPanel;
    private JPanel spellPanel;
    private JPanel cardControlPanel;
    private ArrayList<FieldCardButton> emptySpotsOnField;
    private ArrayList<MonsterButton> monsterCardsOnField;
    private ArrayList<FieldCardButton> cardsOnField;

    public FieldPanel(GUI gui, String player){
        cardControlPanel = gui.getCardControlPanel();
        emptySpotsOnField = new ArrayList<FieldCardButton>();
        monsterCardsOnField = new ArrayList<MonsterButton>();
        cardsOnField = new ArrayList<FieldCardButton>();

        this.setOpaque(false);
        this.setLayout(null);

        GridLayout monsterZoneLayout = new GridLayout(1,5);
        GridLayout spellZoneLayout = new GridLayout(1,5);

        spellPanel = new JPanel();
        monsterPanel = new JPanel();

        if(player == "opponent") {
            monsterPanel.setBounds(160, 180, 680, 150);
            spellPanel.setBounds(160, 10, 680, 150);
        }
        else{
            monsterPanel.setBounds(160, 10, 680, 150);
            spellPanel.setBounds(160, 180, 680, 150);
        }

        monsterPanel.setLayout(monsterZoneLayout);
        monsterZoneLayout.setHgap(40);
        monsterPanel.setOpaque(false);

        spellPanel.setLayout(spellZoneLayout);
        spellZoneLayout.setHgap(40);
        spellPanel.setOpaque(false);

        this.add(monsterPanel);
        this.add(spellPanel);

    }

    public JPanel getMonsterPanel() {
        return monsterPanel;
    }

    public ArrayList<MonsterButton> getMonsterCardsOnField() {
        return monsterCardsOnField;
    }

    public ArrayList<FieldCardButton> getEmptySpotsOnField() {
        return emptySpotsOnField;
    }

    public JPanel getSpellPanel() {
        return spellPanel;
    }

    public ArrayList<FieldCardButton> getCardsOnField() {
        return cardsOnField;
    }

}
