package gui.listeners;

import gui.GUI;
import gui.MonsterButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SelectAttackTargetListener extends MouseAdapter{
    private boolean isFirstClick;
    private MonsterButton monsterButton;
    private GUI gui;

        public SelectAttackTargetListener(MonsterButton addedMonsterButton, GUI addedGUI){
            isFirstClick = true;
            monsterButton = addedMonsterButton;
            gui = addedGUI;
        }

    @Override
    public void mouseClicked(MouseEvent e) {
        monsterButton.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
        gui.setMonsterTarget(monsterButton);
        this.isFirstClick = false;
//        if(this.isFirstClick){
//            monsterButton.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
//            gui.setMonsterTarget(monsterButton);
//            this.isFirstClick = false;
//        }
//        else {
//            monsterButton.setBorder(BorderFactory.createEmptyBorder());
//            this.isFirstClick = true;
//        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(this.isFirstClick) {
            monsterButton.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
        }
    }

    @Override
    public void mouseExited(MouseEvent e){
        if(this.isFirstClick){
            monsterButton.setBorder(BorderFactory.createEmptyBorder());
        }
    }
}
