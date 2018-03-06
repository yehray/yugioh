package com.game;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<MonsterCard> deck;

    public ArrayList<MonsterCard> getDeck() {
        return deck;
    }

    public Deck(){
        deck = new ArrayList<MonsterCard>();
    }

    public void shuffleDeck(){
        Collections.shuffle(getDeck());
    }

    public void addCardToDeck(MonsterCard card){
        deck.add(card);

    }

//    public void addCardToDeck(SpellCard card){
//        deck.add(MonsterCard);
//
//    }

    public MonsterCard drawOneCard(){
        MonsterCard card = deck.get(0);
        deck.remove(0);
        return card;
    }
}
