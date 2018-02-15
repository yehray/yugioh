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


    public void mouseClicked(MouseEvent e) {
        System.out.println("defense");
    }
}
