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

    public Player(String name, int lp){
        playerName = name;
        lifepoints = lp;
        hand = new Hand(this);
        deck = new Deck();
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
                field.setMonster(monsterCard);
                hand.removeCardFromHand(monsterCard);
                this.monsterSummoned = true;
        }
    }

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

    public void flipMonster(MonsterCard monsterCard){
        if(monsterCard.getFaceDown()){
            monsterCard.setFaceDown(false);
            monsterCard.setMode("ATTACK");
        }
    }

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

    public void endPhase(String phase){
        if(phase == "MAIN PHASE 1"){
            this.getField().setPhase("BATTLE PHASE");
        }
        else if(phase == "BATTLE PHASE"){
            this.getField().setPhase("MAIN PHASE 2");
        }
//        else{
//            endTurn();
//        }
    }

    public void endTurn(){
        this.monsterSummoned = false;
        this.getField().setPhase("MAIN PHASE 1");
        for(int i = 0; i < this.field.getMonsters().size(); i++){
            this.field.getMonsters().get(i).setHaveAttacked(false);
        }
    }


}
