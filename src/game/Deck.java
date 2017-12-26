package game;

import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> deck;

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public Deck(){
        deck = new ArrayList<Card>();
    }

    private void shuffleDeck(){

    }

    public Card drawOneCard(){
        return deck.remove(0);
    }
}
