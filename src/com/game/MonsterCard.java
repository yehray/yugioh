package com.game;

public class MonsterCard extends Card {
    private String name;
    private int attack;
    private int defence;
    private int level;
    private String mode;
    private Boolean haveAttacked;
    private Boolean switchedMode;

    public MonsterCard(String nm, int lvl, int atk, int dfc){
        setName(nm);
        level = lvl;
        attack = atk;
        defence = dfc;
        switchedMode = true;
        mode = "ATTACK";
        haveAttacked = false;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Boolean getHaveAttacked(){
        return haveAttacked;
    }

    public void setHaveAttacked(Boolean haveAttacked) {
        this.haveAttacked = haveAttacked;
    }

    public Boolean getSwitchedMode() {
        return switchedMode;
    }

    public void setSwitchedMode(Boolean switchedMode) {
        this.switchedMode = switchedMode;
    }
}
