package com.game;

import com.gui.exceptions.AlreadyAttackedException;
import com.gui.exceptions.DefenseModeException;
import com.gui.exceptions.WrongPhaseException;

import javax.swing.*;

public class Player {

    private String playerName;
    public int lifepoints;
    private Hand hand;
    private Deck deck;
    Field field;
    boolean monsterSummoned;

    public Player(String name, int lp){
        playerName = name;
        lifepoints = lp;
        hand = new Hand(this);
        deck = new Deck();
        field = new Field(this);
        monsterSummoned = false;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
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

    /**
     * Monsters is moved from the hand to the field in attack position. Monsters can only be summoned during MAIN PHASE 1 or MAIN PHASE 2
     */
    public void summonMonster(MonsterCard monsterCard){
        if(field.getPhase() == "MAIN PHASE 1" || field.getPhase() == "MAIN PHASE 2") {
                field.setMonster(monsterCard);
                hand.removeCardFromHand(monsterCard);
                this.monsterSummoned = true;
        }
    }

    /**
     * Monsters with level 4 or higher need to be tribute summoned. Not implemented yet.
     */
    public void tributeSummon(MonsterCard monsterCard, MonsterCard tribute, String mode){
        if(field.getPhase() == "MAIN PHASE 1" || field.getPhase() == "MAIN PHASE 2") {
            if (monsterCard.getLevel() > 4 && this.monsterSummoned == false) {
                field.removeMonster(tribute);
                field.addToGraveyard(tribute);
                field.setMonster(monsterCard);
                monsterCard.setMode(mode);
                this.monsterSummoned = true;
            }
        }
    }

    /**
     * Not implemented yet.
     */
    public void flipMonster(MonsterCard monsterCard){
        if(monsterCard.getFaceDown()){
            monsterCard.setFaceDown(false);
            monsterCard.setMode("ATTACK");
        }
    }

    /**
     * A monster can only attack an opponent's monster if it is in ATTACK position and if the player is in BATTLE PHASE. If the player's monster has a higher attack
     * than the opponent's monster and both monsters are in ATTACK position, the opponent's monster is removed from the field and the difference between the player's
     * monster's attack points and the opponent's monster's attack points is subtracted from the opponent's lifepoints. If the opponent's monster is in defense mode,
     * the monster is removed without the opponent losing any lifepoints.
     */
    public void attack(MonsterCard monsterCard, MonsterCard opponentMonsterCard, Player opponent){
        if (monsterCard.getHaveAttacked()){
            JOptionPane.showMessageDialog(null, "Monster cannot attack twice in a turn");
            throw new AlreadyAttackedException("Monster cannot attack twice in a turn");
        }
        if (field.getPhase() == "BATTLE PHASE" && monsterCard.getMode() == "DEFENSE"){
            JOptionPane.showMessageDialog(null, "Monster cannot attack if in defense position");
            throw new DefenseModeException("Monster cannot attack if in defense position");
        }
        if (field.getPhase() != "BATTLE PHASE"){
            JOptionPane.showMessageDialog(null, "Monster cannot attack if not in battle phase");
            throw new WrongPhaseException("Monster cannot attack if not in battle phase");
        }
        if (field.getPhase() == "BATTLE PHASE" && monsterCard.getMode() == "ATTACK" && opponentMonsterCard.getMode() == "ATTACK" && !monsterCard.getHaveAttacked()) {
            monsterCard.setHaveAttacked(true);
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
            monsterCard.setHaveAttacked(true);
            if (monsterCard.getAttack() >= opponentMonsterCard.getAttack()) {
                opponent.field.removeMonster(opponentMonsterCard);
                opponent.field.addToGraveyard(opponentMonsterCard);
            }
        }

    }

    /**
     * If there are no monsters on the field, the monster can attack the opponent's lifepoints directly. The monster's attack points are subtracted from the
     * opponent's lifepoints.
     */
    public void attackDirectly(MonsterCard monsterCard, Player opponent){
        if (monsterCard.getHaveAttacked()){
            JOptionPane.showMessageDialog(null, "Monster cannot attack twice in a turn");
            throw new AlreadyAttackedException("Monster cannot attack twice in a turn");
        }
        if (field.getPhase() == "BATTLE PHASE" && monsterCard.getMode() == "ATTACK" && !monsterCard.getHaveAttacked()) {
            monsterCard.setHaveAttacked(true);
            opponent.lifepoints = opponent.lifepoints - (monsterCard.getAttack());
        }
    }

    /**
     * Switches monster from ATTACK to DEFENSE or from DEFENSE to ATTACK. Can only switch modes during MAIN PHASE 1 or MAIN PHASE 2.
     */
    public boolean switchMonsterMode(MonsterCard monsterCard){
        if(field.getPhase() == "MAIN PHASE 1" || field.getPhase() == "MAIN PHASE 2") {
            if (monsterCard.getMode() == "ATTACK") {
                monsterCard.setMode("DEFENSE");
            } else {
                monsterCard.setMode("ATTACK");
            }
            return true;
        }
        return false;
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

    public MonsterCard drawCard(){
        MonsterCard card = deck.drawOneCard();
        hand.addCardToHand(card);
        return card;
    }

    /**
     * Changes phase from MAIN PHASE 1 to BATTLE PHASE or from BATTLE PHASE to MAIN PHASE 2.
     */
    public void endPhase(String phase){
        if(phase == "MAIN PHASE 1"){
            this.getField().setPhase("BATTLE PHASE");
        }
        else if(phase == "BATTLE PHASE"){
            this.getField().setPhase("MAIN PHASE 2");
        }
    }

    /**
     * Set monsterSummoned to be false and  haveAttacked for all monsters on the field to be false. This enables the player to summon and attack
     * during the next turn since the player can only summon one monster and attack once with each monster during each turn.
     */
    public void endTurn(){
        this.monsterSummoned = false;
        this.getField().setPhase("MAIN PHASE 1");
        for(int i = 0; i < this.field.getMonsters().size(); i++){
            this.field.getMonsters().get(i).setHaveAttacked(false);
        }
    }


}
