package game;

public class Player {

    private String playerName;
    public int lifepoints;
    private Hand hand;
    private Deck deck;
    private Field field;

    public String getPlayerName() {
        return playerName;
    }

    public int getLifepoints() {
        return lifepoints;
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

    public Player(String name){
        playerName = name;
        lifepoints = 8000;
        hand = new Hand(this);
        deck = new Deck(this);
        field = new Field(this);
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
        if(monsterCard.getLevel() < 4){
            field.setMonster(monsterCard);
        }
    }

    public void attack(MonsterCard monsterCard, MonsterCard opponentMonsterCard, Player opponent){
        if(field.getPhase() == "BATTLE PHASE"){
            if(monsterCard.getAttack() >= opponentMonsterCard.getAttack()){
                opponent.field.removeMonster(opponentMonsterCard);
                opponent.field.addToGraveyard(opponentMonsterCard);
                opponent.lifepoints = opponent.lifepoints - (monsterCard.getAttack() - opponentMonsterCard.getAttack());
            }
            if(monsterCard.getAttack() < opponentMonsterCard.getAttack()){
                field.removeMonster(monsterCard);
                field.addToGraveyard(monsterCard);
                this.lifepoints = this.lifepoints - (opponentMonsterCard.getAttack() - monsterCard.getAttack());
            }
        }

    }

    public void activateSpell(SpellCard spellCard, Player opponent){
        field.setSpell(spellCard);
    }

    public void setSpell(SpellCard spellCard){
        field.setSpell(spellCard);
    }

    public void activateTrap(Card trapCard, Player opponent){

    }

    public void drawCard(){
        Card card = deck.drawOneCard();
        hand.addCardToHand(card);
    }





}
