package gui;
import game.Game;
import game.MonsterCard;
import gui.listeners.*;

import javax.swing.*;
import java.util.ArrayList;

public class GUI extends JFrame {

    private Game game;
    private JLabel boardBackground;
    private JLabel cardBackGroundLarge;
    private JPanel cardControlPanel;
    private PlayerPanel activePlayer;
    private PlayerPanel opponentPlayer;
    private PlayerPanel opponent;
    private JLabel activeLifePoints;
    private JLabel opponentLifePoints;
    private InfoPanel infoPanel;
//    private JPanel cardImagePanel;




    public GUI(){

        game = new Game();
        game.startNewGame();

        this.setTitle("Yu-Gi-Oh!");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        boardBackground = new JLabel(new ImageIcon((getClass().getResource("resources/yugiohFieldBackground.jpg"))));
        setSize(1366,768);

        cardControlPanel = new JPanel();
        cardControlPanel.setLayout(null);
        cardControlPanel.setBounds(890,188,425,375);
        cardControlPanel.setOpaque(false);

        activePlayer = new PlayerPanel(this, "player");
        activePlayer.setBounds(0,400,1366,400);

        opponentPlayer = new PlayerPanel(this, "opponent");
        opponentPlayer.setBounds(0,5,1366,400);

        PhaseControlPanel phaseControlPanel = new PhaseControlPanel(this);
        phaseControlPanel.setBounds(1180,620,140,105);

        InfoPanel infoPnl = new InfoPanel(this);
        infoPnl.setBounds(1165, 155, 200, 425);
        infoPanel = infoPnl;

        this.add(infoPnl);
        this.add(phaseControlPanel);
        this.add(activePlayer);
        this.add(opponentPlayer);
        this.add(cardControlPanel);
        this.add(boardBackground);



        MonsterCard summonedSkull = new MonsterCard("Summoned Skull", 5, 2500, 1300);
        MonsterCard blueEyes = new MonsterCard("Blue Eyes White Dragon", 8, 3000, 2500);
        MonsterCard darkMagician = new MonsterCard("Dark Magician", 8, 3000, 2500);
        MonsterCard gaiaTheFierceKnight = new MonsterCard("Gaia the Fierce Knight", 7, 2300, 2000);
        MonsterCard beaverWarrior = new MonsterCard("Beaver Warrior", 8, 3000, 2500);
        MonsterCard giantSoldierOfStone = new MonsterCard("Giant Soldier of Stone", 8, 3000, 2500);



        addToHand(giantSoldierOfStone);
        addToHand(summonedSkull);
        addToHand(gaiaTheFierceKnight);
        addToHand(beaverWarrior);
        addToHand(darkMagician);
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

    public PlayerPanel getOpponentPlayer() {
        return opponentPlayer;
    }

    public JPanel getCardControlPanel() {
        return cardControlPanel;
    }


    public void setGame(PlayerPanel player){
        ImageIcon monsterCardZone = new ImageIcon(this.getClass().getResource("resources/monsterCardZone.jpg"));
        ImageIcon spellCardZone = new ImageIcon(this.getClass().getResource("resources/spellCardZone.jpg"));

        for(int i = 0; i < 5; i++){
            FieldCardButton monsterCardZoneButton = new FieldCardButton(monsterCardZone);
            monsterCardZoneButton.setIndex(i);
            monsterCardZoneButton.addMouseListener(new SelectFieldCardListener(monsterCardZoneButton, this));
            player.getFieldPanel().getMonsterPanel().add(monsterCardZoneButton);
            player.getFieldPanel().getEmptySpotsOnField().add(monsterCardZoneButton);
            player.getFieldPanel().getCardsOnField().add(monsterCardZoneButton);

            FieldCardButton spellCardZoneButton = new FieldCardButton(spellCardZone);
            spellCardZoneButton.addMouseListener(new HighlightArea(spellCardZoneButton, cardControlPanel));
            player.getFieldPanel().getSpellPanel().add(spellCardZoneButton);
            player.getFieldPanel().revalidate();
            player.getFieldPanel().repaint();
        }


    }

    //
//        MonsterCard blueEyes = new MonsterCard("Blue Eyes White Dragon", 8, 3000, 2500);
//        MonsterButton monsterButton = new MonsterButton(blueEyes.getImageSmall());
//
//        int index = getComponentZOrder(buttons[0]);
//        monsterPanel.remove(buttons[2]);
//        monsterPanel.add(new JLabel("I was here"), 3);




    public void addToHand(MonsterCard card){
        HandButton addedCard = new HandButton(card.getImageSmall(), card);
        addedCard.addMouseListener(new ShowLargerImage(cardControlPanel, card));
        addedCard.addMouseListener(new SelectHandCardListener(addedCard, this));
        addedCard.addMouseListener(new PopUpListener(this.getActivePlayer().getHandPanel().getCurrentLayout()));
        this.getActivePlayer().getHandPanel().getHand().add(addedCard);
        this.getActivePlayer().getHandPanel().getHandButtons().add(addedCard);
        this.getActivePlayer().getHandPanel().getHandButtons().add(addedCard);
        addedCard.setVisible(true);
        addedCard.validate();
    }

    public MonsterButton summonMonster(HandButton monsterCardButton){
        JPanel monsterPanel = this.getActivePlayer().getFieldPanel().getMonsterPanel();
        ArrayList<HandButton> handButtonsList = this.getActivePlayer().getHandPanel().getHandButtons();
        MonsterButton monsterButton = new MonsterButton(monsterCardButton.getCard().getImageSmall());
        monsterButton.addMouseListener( new ShowLargerImage(cardControlPanel, monsterCardButton.getCard()));
        monsterButton.addMouseListener(new SelectFieldMonsterListener(monsterButton, this));


        for(int i = 0; i < handButtonsList.size(); i++) {
            if(handButtonsList.get(i) == monsterCardButton.getCardSource()){
                this.getActivePlayer().getHandPanel().getHand().remove(handButtonsList.get(i));
            }
        }

        ArrayList<FieldCardButton> cardsOnField = this.getActivePlayer().getFieldPanel().getCardsOnField();
        int index = 0;
        for(int i = 0; i < cardsOnField.size(); i++){
            if(cardsOnField.get(i).isHighlighted()){
                index = cardsOnField.get(i).getIndex();
            }
        }


        monsterPanel.remove(index);
        monsterPanel.add(monsterButton, index);
        monsterButton.setIndex(index);
        monsterPanel.revalidate();
        monsterPanel.repaint();
        return monsterButton;
    }



    public void attack(MonsterCard monster, MonsterCard opponentMonster){
//        game.getPlayer().attack();

    }

    public void changePhase(){
        String currentPhase = game.getPlayer().getField().getPhase();
        game.getPlayer().endPhase(currentPhase);
        infoPanel.getCurrentPhasePanel().setText(game.getPlayer().getField().getPhase());

    }





}

