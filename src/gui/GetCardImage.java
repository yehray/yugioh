package gui;

import game.Card;

import javax.swing.*;

public class GetCardImage {
    private ImageIcon cardImage;
    public GetCardImage(Card card){
        ImageIcon cardImage = new ImageIcon(this.getClass().getResource("/resources/" + card + ".jpg"));
    }

    public ImageIcon getCardImage() {
        return cardImage;
    }

    public void setCardImage(ImageIcon cardImage) {
        this.cardImage = cardImage;
    }
}
