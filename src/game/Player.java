package game;

public class Player {

    private String playerName;
    public int lifepoints;
    private Hand hand;
    private Deck deck;
    Field field;
    boolean monsterSummoned;

    public String getPlayerName() {
        return playerName;
    }

    public int getLifepoints() {
        return lifepoints;
    }

    public void setLifepoints(int lifepoints) {
        this.lifepoints = lifepoints;
    }

    public Hand getHand() {
        return hand;
    }

    public Field getField(){
        return field;
    }

    public Deck getDeck() {
        return deck;
    }

    public Player(String name, int lp, Deck playerDeck){
        playerName = name;
        lifepoints = lp;
        hand = new Hand(this);
        deck = playerDeck;
        field = new Field(this);
        monsterSummoned = false;
    }

    public Boolean selectCardInHand(Card card){
        if(hand.getCardsInHand().contains(card)){
            return true;
        }
        return false;
    }

    public Boolean selectMonsterCard(Card card){
        if(field.getMonsters().contains(card)){
            return true;
        }
        return false;
    }

    public Boolean selectSpellCard(Card card){
        if(field.getSpells().contains(card)){
            return true;
        }
        return false;
    }

    public void summonMonster(MonsterCard monsterCard){
        if(field.getPhase() == "MAIN PHASE 1" || field.getPhase() == "MAIN PHASE 2") {
            if (monsterCard.getLevel() < 4 && this.monsterSummoned == false) {
                field.setMonster(monsterCard);
                this.monsterSummoned = true;
            }
        }
    }

    public void flipMonster(MonsterCard monsterCard){
        if(monsterCard.getFaceDown()){
            monsterCard.setFaceDown(false);
            monsterCard.setMode("ATTACK");
        }
    }

    public void attack(MonsterCard monsterCard, MonsterCard opponentMonsterCard, Player opponent) {
        if (field.getPhase() == "BATTLE PHASE" && monsterCard.getMode() == "ATTACK" && opponentMonsterCard.getMode() == "ATTACK" && !monsterCard.getHaveAttacked()) {
            if (monsterCard.getAttack() >= opponentMonsterCard.getAttack()) {
                opponent.field.removeMonster(opponentMonsterCard);
                opponent.field.addToGraveyard(opponentMonsterCard);
                opponent.lifepoints = opponent.lifepoints - (monsterCard.getAttack() - opponentMonsterCard.getAttack());
            }
            if (monsterCard.getAttack() < opponentMonsterCard.getAttack()) {
                field.removeMonster(monsterCard);
                field.addToGraveyard(monsterCard);
                this.lifepoints = this.lifepoints - (opponentMonsterCard.getAttack() - monsterCard.getAttack());
            }
        }
        if (field.getPhase() == "BATTLE PHASE" && monsterCard.getMode() == "ATTACK" && opponentMonsterCard.getMode() == "DEFENSE" && !monsterCard.getHaveAttacked()) {
            if (monsterCard.getAttack() >= opponentMonsterCard.getAttack()) {
                opponent.field.removeMonster(opponentMonsterCard);
                opponent.field.addToGraveyard(opponentMonsterCard);
            }
        }
        monsterCard.setHaveAttacked(true);
    }

    public void switchMonsterMode(MonsterCard monsterCard){
        if(field.getPhase() == "MAIN PHASE 1" || field.getPhase() == "MAIN PHASE 2") {
            if (monsterCard.getMode() == "ATTACK") {
                monsterCard.setMode("DEFENSE");
            } else {
                monsterCard.setMode("ATTACK");
            }
        }
    }

    public void activateSpell(SpellCard spellCard, Card targetCard, Player targetPlayer){
        if(field.getPhase() == "MAIN PHASE 1" || field.getPhase() == "MAIN PHASE 2") {
            field.setSpell(spellCard);
        }
    }

    public void setSpell(SpellCard spellCard){
        if(field.getPhase() == "MAIN PHASE 1" || field.getPhase() == "MAIN PHASE 2") {
            field.setSpell(spellCard);
        }
    }

    public void activateTrap(Card trapCard, Player opponent){

    }

    public void drawCard(){
        Card card = deck.drawOneCard();
        hand.addCardToHand(card);
    }

    public void endPhase(String phase){
        if(phase == "MAIN PHASE 1"){
            this.getField().phase = "BATTLE PHASE";
        }
        else if(phase == "BATTLE PHASE"){
            this.getField().phase = "MAIN PHASE 2";
        }
        else{
            endTurn();
        }
    }

    public void endTurn(){
        this.monsterSummoned = false;
        for(int i = 0; i < this.field.getMonsters().size(); i++){
            this.field.getMonsters().get(i).setHaveAttacked(false);
        }
    }


}
