package gui;
import game.Game;
import game.MonsterCard;
import gui.listeners.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class GUI extends JFrame {

    private JLabel boardBackground;
    private JLabel cardBackGroundLarge;
    private JPanel cardControlPanel;
    private PlayerPanel activePlayer;
    private PlayerPanel opponent;
    private JLabel activeLifePoints;
    private JLabel opponentLifePoints;
//    private JPanel cardImagePanel;




    public GUI(){

        Game newGame = new Game();
        newGame.startNewGame();

        this.setTitle("Yu-Gi-Oh!");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        boardBackground = new JLabel(new ImageIcon((getClass().getResource("resources/yugiohFieldBackground.jpg"))));
        setSize(1366,768);

        cardControlPanel = new JPanel();
        cardControlPanel.setLayout(null);
        cardControlPanel.setBounds(890,188,425,375);
        cardControlPanel.setOpaque(false);

        activePlayer = new PlayerPanel(this);
        boardBackground.add(activePlayer);
        activePlayer.setBounds(0,400,1366,400);


        this.add(activePlayer);
        this.add(cardControlPanel);
        this.add(boardBackground);

        MonsterCard summonedSkull = new MonsterCard("Summoned Skull", 5, 2500, 1300);
        MonsterCard blueEyes = new MonsterCard("Blue Eyes White Dragon", 8, 3000, 2500);

        addToHand(summonedSkull);
        addToHand(blueEyes);

        this.setVisible(true);


    }

    public JLabel getActiveLifePoints() {
        return activeLifePoints;
    }

    public JLabel getBoardBackground() {
        return boardBackground;
    }

    public PlayerPanel getActivePlayer() {
        return activePlayer;
    }

    public PlayerPanel getOpponent() {
        return opponent;
    }

    public JPanel getCardControlPanel() {
        return cardControlPanel;
    }

    public void addToHand(MonsterCard card){
        HandButton addedCard = new HandButton(card.getImageSmall(), card);
        addedCard.addMouseListener(new SelectHandCardListener(addedCard, this));
        addedCard.addMouseListener(new PopUpListener(this.getActivePlayer().getHandPanel().getCurrentLayout()));
        addedCard.addMouseListener(new ShowLargerImage(cardControlPanel, card));
        this.getActivePlayer().getHandPanel().getHand().add(addedCard);
        addedCard.setVisible(true);
        addedCard.validate();
    }

    public MonsterButton summonMonster(MonsterCard monsterCard){
        JPanel monsterPanel = this.getActivePlayer().getFieldPanel().getMonsterPanel();
        monsterPanel.remove(0);
        MonsterButton monsterButton = new MonsterButton(monsterCard.getImageSmall());
        monsterButton.addMouseListener(new SelectFieldCardListener(monsterButton, this));
        monsterPanel.add(monsterButton);
        monsterPanel.revalidate();
        monsterPanel.repaint();
        return monsterButton;
    }





}

