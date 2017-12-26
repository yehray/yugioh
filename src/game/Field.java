package game;

import java.util.ArrayList;

public class Field {

    private String fieldSide;
    private ArrayList<Card> monsterZone;
    private ArrayList<Card> spellZone;
    private ArrayList<Card> graveyard;
    public String phase;

    public String fieldSide() {
        return fieldSide;
    }

    public ArrayList<Card> getMonsters() {
        return monsterZone;
    }

    public ArrayList<Card> getSpells() {
        return spellZone;
    }

    public ArrayList<Card> getGraveyard() {
        return graveyard;
    }

    public String getPhase(){
        return phase;
    }

    public Field(Player player){
        fieldSide = player.getPlayerName();
        monsterZone = new ArrayList<Card>();
        spellZone = new ArrayList<Card>();
        graveyard = new ArrayList<Card>();
        phase = "MAIN PHASE 1";
    }

    public void setMonster(MonsterCard monsterCard){
        if(monsterZone.size() < 5){
            monsterZone.add(monsterCard);
        }
    }

    public void removeMonster(MonsterCard monsterCard){
        monsterZone.remove(monsterCard);
    }

    public void setSpell(SpellCard spellCard){
        if(spellZone.size() < 5){
            spellZone.add(spellCard);
        }
    }

    public void removeSpell(SpellCard spellCard){
        spellZone.remove(spellCard);
    }

    public void addToDeck(Card card){

    }

    public void removeFromDeck(Card card){
    }

    public void addToGraveyard(Card card){
        graveyard.add(card);
    }

    public void removeFromGraveyard(Card card){
        graveyard.remove(card);
    }

}
