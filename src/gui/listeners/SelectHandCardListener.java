package gui.listeners;

import game.MonsterCard;
import gui.FieldPanel;
import gui.HandButton;
import gui.HandPanel;
import gui.PlayerPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SelectHandCardListener extends MouseAdapter{

    private gui.HandButton handbutton;
    private boolean isFirstClick;
    private JPanel cardControlPanel;
    private FieldPanel fieldPanel;
    private HandPanel handPanel;
    private JButton summonButton;

    public SelectHandCardListener(HandButton addedButton, JPanel addedPanel, PlayerPanel playerPanel){
        handbutton = addedButton;
        cardControlPanel = addedPanel;
        fieldPanel = playerPanel.getFieldPanel();
        handPanel = playerPanel.getHandPanel();
        isFirstClick = true;

    }


    public void mouseClicked(MouseEvent e) {
        if(this.isFirstClick){
            handbutton.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
            JButton summonButton = new JButton("SUMMON");
            summonButton.setBounds(300,0, 125,50);
//            summonButton.addActionListener(new SummonMonsterListener(fieldPanel));
            cardControlPanel.add(summonButton);
            cardControlPanel.revalidate();
            this.isFirstClick = false;
        }
        else {
            handbutton.setBorder(BorderFactory.createEmptyBorder());
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
