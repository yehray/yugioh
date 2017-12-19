package game;

public class Player {

    private String playerName;
    private int lifepoints;
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

    public Boolean selectCard(Card card){
        if(hand.getCardsInHand().contains(card)){
            return true;
        }
        return false;
    }

    public void summonMonster(MonsterCard monsterCard){
        if(monsterCard.getLevel() < 4){
            field.setMonster(monsterCard);
        }
    }

    public void attack(Card monsterCard, Card opponentMonsterCard){

    }

    public void activateSpell(Card spellCard){
        field.setSpell(spellCard);
    }

    public void setSpell(Card spellCard){
        field.setSpell(spellCard);
    }

    public void activateTrap(Card trapCard){

    }

    public void drawCard(){
        Card card = deck.drawOneCard();
        hand.addCardToHand(card);
    }





}
