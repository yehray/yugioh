package game;

public class MonsterCard extends Card {
    private int attack;
    private int defence;
    private int level;
    private String mode;

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getLevel() {
        return level;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
