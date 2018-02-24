package gui;

import javax.swing.*;
import java.awt.*;

public class PlayerPanel extends JPanel{

    private GUI gui;
    private String playerName;
    private JLabel DeckLabel;
    private JLabel opponentLifePoints;
    private HandPanel handPanel;
    private HandPanel opponentHandPanel;
    private FieldPanel fieldPanel;
    private String selectMonsterInHand;
    private String selectMonsterInField;
    private JPanel cardControlPanel;


    public PlayerPanel(GUI gui, String player){
        playerName = player;
        this.setOpaque(false);
        this.setLayout(null);


        cardControlPanel = gui.getCardControlPanel();

        fieldPanel = new FieldPanel(gui, playerName);
        fieldPanel.setBounds(0,0,850,384);
        this.add(fieldPanel);

        handPanel = new HandPanel(gui);

        ImageIcon deckBackground = new ImageIcon(this.getClass().getResource("resources/yugiohCardBackground.jpg"));
        DeckButton deckButton = new DeckButton(deckBackground);

        ImageIcon graveYardBackground = new ImageIcon(this.getClass().getResource("resources/yugiohGraveyardBackground.jpg"));
        GraveyardButton graveyardButton = new GraveyardButton(graveYardBackground);

        if(player == "opponent") {
            deckButton.setBounds(32, 180, 100, 150);
            graveyardButton.setBounds(32, 10, 100, 150);
            handPanel.setBounds(890,-10,315,190);
        }
        else{
            deckButton.setBounds(32, 10, 100, 150);
            graveyardButton.setBounds(32, 180, 100, 150);
            handPanel.setBounds(890,165,315,200);
        }

        this.add(deckButton);
        this.add(graveyardButton);
        this.add(handPanel);




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
