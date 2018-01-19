package gui;

import javax.swing.*;
import java.awt.*;

public class PlayerPanel extends JPanel{

    public PlayerPanel(String name){
        this.setOpaque(false);
        this.setName(name);
        this.setLayout(new BorderLayout());
        FieldPanel fieldPanel = new FieldPanel();
        HandPanel handPanel = new HandPanel();
        this.add(fieldPanel, BorderLayout.NORTH);
        this.add(handPanel, BorderLayout.SOUTH);
    }
}
