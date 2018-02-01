package gui;

import javax.swing.*;
import java.awt.*;

public class PlayerPanel extends JPanel{

    private GUI gui;
    private JLabel DeckLabel;
    private JLabel opponentLifePoints;
    private HandPanel handPanel;
    private String selectMonsterInHand;
    private String selectMonsterInField;


    public PlayerPanel(String name, JPanel addedPanel){
        this.setName(name);
        this.setOpaque(false);
        this.setLayout(null);

        FieldPanel fieldPanel = new FieldPanel();
        fieldPanel.setBounds(0,0,850,384);
        this.add(fieldPanel);


        ImageIcon deckBackground = new ImageIcon(this.getClass().getResource("resources/yugiohCardBackground.jpg"));
        DeckButton deckButton = new DeckButton(deckBackground);
        deckButton.setBounds(32,10,100,150);
        this.add(deckButton);

        ImageIcon graveYardBackground = new ImageIcon(this.getClass().getResource("resources/yugiohGraveyardBackground.jpg"));
        GraveyardButton graveyardButton = new GraveyardButton(graveYardBackground);
        graveyardButton.setBounds(32,180,100,150);
        this.add(graveyardButton);

        HandPanel handPanel = new HandPanel(addedPanel);
        handPanel.setBounds(890,165,315,200);
        this.add(handPanel);




//        opponentLifePoints = new JLabel("Life Points");
//        opponentLifePoints.setFont(new Font("Papyrus", Font.BOLD, 30));
//        opponentLifePoints.setSize(150, 100);
//        opponentLifePoints.setLocation(100, 100);
//        this.add(opponentLifePoints);


    }

    public HandPanel getHandPanel() {
        return handPanel;
    }
}
