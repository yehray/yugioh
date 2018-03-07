package com.game;

import java.util.ArrayList;

public class Hand {
    private ArrayList<MonsterCard> cardsInHand;
    private String playersHand;

    public Hand(Player player){
        cardsInHand = new ArrayList<MonsterCard>();
        playersHand = player.getPlayerName();
    }

    public ArrayList<MonsterCard> getCardsInHand() {
        return cardsInHand;
    }

    public String getPlayersHand() {
        return playersHand;
    }

    /**
     * Each player has a max hand size of 6
     */
    public void addCardToHand(MonsterCard card){
        if(cardsInHand.size() < 7){
            cardsInHand.add(card);
        }
    }

    public void removeCardFromHand(Card card){
        for(int i = 0; i < cardsInHand.size(); i++){
            if(cardsInHand.get(i) == card){
                cardsInHand.remove(card);
            }
        }
    }
}
