package gui;

import javax.swing.*;
import java.awt.*;

public class PlayerPanel extends JPanel{

    private GUI gui;
    private JLabel DeckLabel;
    private JLabel opponentLifePoints;
    private HandPanel handPanel;
    private FieldPanel fieldPanel;
    private String selectMonsterInHand;
    private String selectMonsterInField;
    private JPanel cardControlPanel;


    public PlayerPanel(GUI gui){
        this.setOpaque(false);
        this.setLayout(null);


        cardControlPanel = gui.getCardControlPanel();

        fieldPanel = new FieldPanel(gui);
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

        handPanel = new HandPanel(gui);
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

    public FieldPanel getFieldPanel(){
        return fieldPanel;
    }

    public GUI getGui() {
        return gui;
    }
}
