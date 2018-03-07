package com.game;

import java.util.ArrayList;

public class Field {

    private String fieldSide;
    private ArrayList<MonsterCard> monsterZone;
    private ArrayList<SpellCard> spellZone;
    private ArrayList<Card> graveyard;
    private String phase;

    public Field(Player player){
        fieldSide = player.getPlayerName();
        monsterZone = new ArrayList<MonsterCard>();
        spellZone = new ArrayList<SpellCard>();
        graveyard = new ArrayList<Card>();
        phase = "MAIN PHASE 1";
    }

    public String getFieldSide() {
        return fieldSide;
    }

    public void setFieldSide(String fieldSide) {
        this.fieldSide = fieldSide;
    }

    public ArrayList<MonsterCard> getMonsters() {
        return monsterZone;
    }

    public void setMonster(MonsterCard monsterCard){
        if(monsterZone.size() < 6){
            monsterZone.add(monsterCard);
        }
    }

    public ArrayList<SpellCard> getSpells() {
        return spellZone;
    }

    public void setSpell(SpellCard spellCard){
        if(spellZone.size() < 6){
            spellZone.add(spellCard);
        }
    }

    public String getPhase(){
        return phase;
    }

    public void setPhase(String p){
        phase = p;
    }

    public ArrayList<Card> getGraveyard() {
        return graveyard;
    }

    public void removeMonster(MonsterCard monsterCard){
        monsterZone.remove(monsterCard);
    }

    public void removeSpell(SpellCard spellCard){
        spellZone.remove(spellCard);
    }

    public void addToGraveyard(Card card){
        graveyard.add(card);
    }

    public void removeFromGraveyard(Card card){
        graveyard.remove(card);
    }

}
