package gui;

import game.Card;

import javax.swing.*;

public class GetCardImage {
    private ImageIcon cardImage;
    public GetCardImage(Card card, String size){
        if(size == "s") {
            ImageIcon cardImage = new ImageIcon(this.getClass().getResource("/Users/yehray/IdeaProjects/yugioh/src/gui/resources/Summoned Skull.jpg"));
        }
        else{
            ImageIcon cardImage = new ImageIcon(this.getClass().getResource("/Users/yehray/IdeaProjects/yugioh/src/gui/resources/Summoned Skull.jpg"));

        }
    }

    public ImageIcon getCardImage() {
        return cardImage;
    }

    public void setCardImage(ImageIcon cardImage) {
        this.cardImage = cardImage;
    }
}
