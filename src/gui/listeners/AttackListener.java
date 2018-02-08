package gui.listeners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AttackListener extends MouseAdapter{
    boolean isFirstClick;
    public AttackListener(){
        isFirstClick = true;

    }


//    public void mouseClicked(MouseEvent e) {
//        if(this.isFirstClick){
//            fieldMonsterButton.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
//            cardControlPanel.add(attackButton);
//            cardControlPanel.add(defenseModeButton);
//            cardControlPanel.revalidate();
//            cardControlPanel.repaint();
//            this.isFirstClick = false;
//        }
//        else {
//            fieldMonsterButton.setBorder(BorderFactory.createEmptyBorder());
//            cardControlPanel.revalidate();
//            cardControlPanel.repaint();
//            this.isFirstClick = true;
//        }
//    }
}
