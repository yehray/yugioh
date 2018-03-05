package gui.listeners;

import game.MonsterCard;
import gui.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SelectHandCardListener extends MouseAdapter{

    private gui.HandButton handbutton;
    private ArrayList<HandButton> handButtonsList;
    private JPanel cardControlPanel;
    private JButton summonButton;
    private boolean highlight;
    private GUI gui;

    public SelectHandCardListener(HandButton addedButton, GUI addedGUI){
        gui = addedGUI;
        handbutton = addedButton;
        highlight = false;
        handButtonsList = gui.getActivePlayer().getHandPanel().getHandButtons();
        cardControlPanel = gui.getCardControlPanel();
        summonButton = new JButton("SUMMON");
        summonButton.setBounds(275,40, 125,50);
        summonButton.addMouseListener(new SummonMonsterListener(gui, handbutton));

    }


    public void mouseClicked(MouseEvent e) {
        handbutton.setCardSource(e.getSource());
        if(!handbutton.isClicked()) {
            for (int i = 0; i < handButtonsList.size(); i++) {
                handButtonsList.get(i).setBorder(BorderFactory.createEmptyBorder());
                handButtonsList.get(i).setClicked(false);
            }
            handbutton.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
            handbutton.setClicked(true);
            cardControlPanel.add(summonButton);
            cardControlPanel.revalidate();
            cardControlPanel.repaint();
        }
        else{
            handbutton.setBorder(BorderFactory.createEmptyBorder());
            handbutton.setClicked(false);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(!handbutton.isClicked()) {
            handbutton.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
        }
    }

    @Override
    public void mouseExited(MouseEvent e){
        if(!handbutton.isClicked()) {
            handbutton.setBorder(BorderFactory.createEmptyBorder());
        }
    }


 
}
