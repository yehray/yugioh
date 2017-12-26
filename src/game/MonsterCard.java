package game;

public class MonsterCard extends Card {
    private int attack;
    private int defence;
    private int level;
    private String mode;
    private Boolean haveAttacked;

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

    public MonsterCard(){

    }
}
