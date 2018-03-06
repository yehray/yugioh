package com.game;

abstract public class SpellCard extends Card {
    private String name;
    private String spellOrTrap;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpellOrTrap() {
        return spellOrTrap;
    }

    public void setSpellOrTrap(String spellOrTrap) {
        this.spellOrTrap = spellOrTrap;
    }

    public void activateSpell(){

    }

    public SpellCard(String nm, String sot){
        name = nm;
        spellOrTrap = sot;
    }
}
