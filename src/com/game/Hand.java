package com.game;

import java.util.ArrayList;

public class Hand {
    private ArrayList<MonsterCard> cardsInHand;
    private String playersHand;

    public ArrayList<MonsterCard> getCardsInHand() {
        return cardsInHand;
    }

    public String getPlayersHand() {
        return playersHand;
    }

    public Hand(Player player){
        cardsInHand = new ArrayList<MonsterCard>();
        playersHand = player.getPlayerName();
    }

    public void addCardToHand(MonsterCard card){
        if(cardsInHand.size() < 7){
            cardsInHand.add(card);
        }
    }

    public void removeCardFromHand(Card card){
        removeCardFromHand(card);
    }
}
