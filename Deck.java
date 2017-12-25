package game;

import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> deck;
    private String playerDeck;


    public ArrayList<Card> getDeck() {
        return deck;
    }

    public Deck(Player player){
        deck = new ArrayList<Card>();
        playerDeck = player.getPlayerName();
    }

    private void shuffleDeck(){

    }

    public Card drawOneCard(){
        return deck.remove(0);
    }
}
