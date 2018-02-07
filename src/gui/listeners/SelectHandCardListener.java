package gui.listeners;

import game.MonsterCard;
import gui.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SelectHandCardListener extends MouseAdapter{

    private gui.HandButton handbutton;
    private boolean isFirstClick;
    private JPanel cardControlPanel;
    private JButton summonButton;

    public SelectHandCardListener(HandButton addedButton, GUI gui){
        handbutton = addedButton;
        cardControlPanel = gui.getCardControlPanel();
        summonButton = new JButton("SUMMON");
        summonButton.setBounds(275,40, 125,50);
        summonButton.addMouseListener(new SummonMonsterListener(gui, handbutton.getCard()));

    }


    public void mouseClicked(MouseEvent e) {
        if(this.isFirstClick){
            handbutton.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
            cardControlPanel.add(summonButton);
            cardControlPanel.revalidate();
            cardControlPanel.repaint();
            this.isFirstClick = false;
        }
        else {
            handbutton.setBorder(BorderFactory.createEmptyBorder());
            cardControlPanel.revalidate();
            cardControlPanel.repaint();
            this.isFirstClick = true;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        handbutton.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(this.isFirstClick) {
            handbutton.setBorder(BorderFactory.createEmptyBorder());
        }
    }

}
