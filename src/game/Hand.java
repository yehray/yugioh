package game;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cardsInHand;
    private String playersHand;

    public ArrayList<Card> getCardsInHand() {
        return cardsInHand;
    }

    public String getPlayersHand() {
        return playersHand;
    }

    public Hand(Player player){
        cardsInHand = new ArrayList<Card>();
        playersHand = player.getPlayerName();
    }

    public void addCardToHand(Card card){
        if(cardsInHand.size() < 7){
            cardsInHand.add(card);
        }
    }

    public void removeCardFromHand(Card card){
        removeCardFromHand(card);
    }
}
