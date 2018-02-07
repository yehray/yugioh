package gui.listeners;

import game.Card;
import gui.GUI;
import gui.GetCardImage;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShowLargerImage extends MouseAdapter{
    private JPanel panel;
    private Card card;
    private boolean isFirstClick;
    private JLabel picLabel;
    private JLabel backLabel;


    public ShowLargerImage(JPanel addedPanel, Card addedCard){
        panel = addedPanel;
        card = addedCard;
        isFirstClick = true;
        picLabel = new JLabel(card.getImageLarge());
        backLabel = new JLabel(new ImageIcon(this.getClass().getResource("/gui/resources/yugiohCardBackground Large.jpg")));
    }

    public void mouseClicked(MouseEvent e) {
        if(this.isFirstClick){
            picLabel.setSize(250,375);
            panel.add(backLabel);
            panel.revalidate();
            panel.repaint();
            this.isFirstClick = false;
        }
        else {
            panel.add(picLabel);
            backLabel.setSize(250,375);
            panel.revalidate();
            panel.repaint();
            this.isFirstClick = true;

        }

    }
}
