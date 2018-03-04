package gui;
import game.Game;
import game.MonsterCard;
import game.OpponentPlayerStrategy;
import gui.exceptions.MaxHandSizeException;
import gui.exceptions.WrongPhaseException;
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
    private PlayerPanel player1;
    private PlayerPanel player2;
    private PlayerPanel opponent;
    private JLabel activeLifePoints;
    private JLabel opponentLifePoints;
    private InfoPanel infoPanel;
    private PhaseControlPanel phaseControlPanel;
    private MonsterButton monsterSelected;
    private MonsterButton monsterTarget;
    private OpponentPlayerStrategy opponentPlayerStrategy;


    public GUI(){

        Game newGame = new Game();
        game = newGame;
        game.startNewGame();

        this.setTitle("Yu-Gi-Oh!");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

//        boardBackground = new JLabel(new ImageIcon((getClass().getResource("resources/yugiohFieldBackgroundv2.jpg"))));
//        setSize(1366,768);
//
//        cardControlPanel = new JPanel();
//        cardControlPanel.setLayout(null);
//        cardControlPanel.setBounds(890,188,425,375);
//        cardControlPanel.setOpaque(false);
//
//        player1 = new PlayerPanel(this, "player");
//        player1.setBounds(0,400,1366,400);
//
//        activePlayer = player1;
//
//        player2 = new PlayerPanel(this, "opponent");
//        player2.setBounds(0,0,1366,400);
//
//        opponentPlayer = player2;
//
//        phaseControlPanel = new PhaseControlPanel(this);
//        phaseControlPanel.setBounds(1180,620,140,105);
//
//        InfoPanel infoPnl = new InfoPanel(this);
//        infoPnl.setBounds(1165, 155, 200, 425);
//        infoPanel = infoPnl;
//
//        this.add(infoPnl);
//        this.add(phaseControlPanel);
//        this.add(activePlayer);
//        this.add(opponentPlayer);
//        this.add(cardControlPanel);
//        this.add(boardBackground);

//        MonsterCard summonedSkull = new MonsterCard("Summoned Skull", 5, 2500, 1300);
//        MonsterCard blueEyes = new MonsterCard("Blue Eyes White Dragon", 8, 3000, 2500);
//        MonsterCard darkMagician = new MonsterCard("Dark Magician", 8, 3000, 2500);
//        MonsterCard gaiaTheFierceKnight = new MonsterCard("Gaia the Fierce Knight", 7, 2300, 2000);
//        MonsterCard beaverWarrior = new MonsterCard("Beaver Warrior", 8, 3000, 2500);
//        MonsterCard giantSoldierOfStone = new MonsterCard("Giant Soldier of Stone", 8, 3000, 2500);
//        ArrayList<MonsterCard> arr = new ArrayList<MonsterCard>();
//        arr.add(summonedSkull);
//        arr.add(blueEyes);
//        arr.add(darkMagician);
//        for(int i = 0; i < arr.size(); i++){
//            System.out.println(arr.get(i).getName());
//        }
//        arr.remove(darkMagician);
//        for(int i = 0; i < arr.size(); i++){
//            System.out.println(arr.get(i).getName());
//        }

//
//        addToHand(giantSoldierOfStone);
//        addToHand(summonedSkull);
//        addToHand(gaiaTheFierceKnight);
//        addToHand(beaverWarrior);
//        addToHand(darkMagician);
//        addToHand(blueEyes);


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

    public InfoPanel getInfoPanel() {
        return infoPanel;
    }

    public PhaseControlPanel getPhaseControlPanel() {
        return phaseControlPanel;
    }

    public MonsterButton getMonsterSelected() {
        return monsterSelected;
    }

    public MonsterButton getMonsterTarget() {
        return monsterTarget;
    }

    public void setMonsterSelected(MonsterButton monsterSelected) {
        this.monsterSelected = monsterSelected;
    }

    public void setMonsterTarget(MonsterButton monsterTarget) {
        this.monsterTarget = monsterTarget;
    }

    public void setOpponent(PlayerPanel opponent) {
        this.opponent = opponent;
    }

    public PlayerPanel getPlayer1() {
        return player1;
    }

    public PlayerPanel getPlayer2() {
        return player2;
    }

    public void setActivePlayer(PlayerPanel activePlayer) {
        this.activePlayer = activePlayer;
    }

    public Game getGame() {
        return game;
    }

    public void setOpponentPlayerStrategy() {
        this.opponentPlayerStrategy = new OpponentPlayerStrategy(game, this);
        this.getPhaseControlPanel().addStrategy();

    }

    public OpponentPlayerStrategy getOpponentPlayerStrategy() {
        return opponentPlayerStrategy;
    }

    public void setPlayers(){
        player1 = new PlayerPanel(this, "player");
        player1.setBounds(0,400,1366,400);

        activePlayer = player1;

        player2 = new PlayerPanel(this, "opponent");
        player2.setBounds(0,0,1366,400);

        opponentPlayer = player2;

        this.add(activePlayer);
        this.add(opponentPlayer);
    }

    public void setPanels(){
        boardBackground = new JLabel(new ImageIcon((getClass().getResource("resources/yugiohFieldBackgroundv2.jpg"))));
        setSize(1366,768);

        cardControlPanel = new JPanel();
        cardControlPanel.setLayout(null);
        cardControlPanel.setBounds(890,188,425,375);
        cardControlPanel.setOpaque(false);

        phaseControlPanel = new PhaseControlPanel(this);
        phaseControlPanel.setBounds(1180,620,140,105);

        InfoPanel infoPnl = new InfoPanel(this);
        infoPnl.setBounds(1165, 155, 200, 425);
        infoPanel = infoPnl;

        this.add(infoPnl);
        this.add(phaseControlPanel);
        this.add(cardControlPanel);
        this.add(boardBackground);
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


    public void drawStartingHand(){
        for(int i = 0; i < game.getPlayer().getHand().getCardsInHand().size(); i++){
            addToHand(game.getPlayer().getHand().getCardsInHand().get(i), getActivePlayer());
        }

        for(int i = 0; i < game.getOpponent().getHand().getCardsInHand().size(); i++){
            MonsterCard monsterCard = game.getOpponent().getHand().getCardsInHand().get(i);
            ImageIcon cardBackground = new ImageIcon(this.getClass().getResource("resources/yugiohCardBackground.jpg"));
            HandButton addedCard = new HandButton(cardBackground, monsterCard);
            getOpponentPlayer().getHandPanel().getHand().add(addedCard);
            getOpponentPlayer().getHandPanel().getHandButtons().add(addedCard);
        }
        revalidate();
        repaint();

    }

    public void addToHand(MonsterCard card, PlayerPanel player){
        if(player.getHandPanel().getHand().getComponents().length < 7) {
            HandButton addedCard = new HandButton(card.getImageSmall(), card);
            addedCard.addMouseListener(new ShowLargerImage(cardControlPanel, card));
            addedCard.addMouseListener(new SelectHandCardListener(addedCard, this));
            addedCard.addMouseListener(new PopUpListener(player.getHandPanel().getCurrentLayout()));
            player.getHandPanel().getHand().add(addedCard);
            player.getHandPanel().getHandButtons().add(addedCard);
            addedCard.setVisible(true);
            addedCard.validate();
        }
        else{
            JOptionPane.showMessageDialog(null, "Max hand size reached");
            throw new MaxHandSizeException("Max hand size reached");
        }
    }

    public MonsterButton summonMonster(HandButton monsterCardButton, PlayerPanel playerPanel){
        JPanel monsterPanel = playerPanel.getFieldPanel().getMonsterPanel();
        ArrayList<HandButton> handButtonsList = playerPanel.getHandPanel().getHandButtons();
        MonsterButton monsterButton = new MonsterButton(monsterCardButton.getCard().getImageSmall(), monsterCardButton.getCard());
        monsterButton.addMouseListener( new ShowLargerImage(cardControlPanel, monsterCardButton.getCard()));
        monsterButton.addMouseListener(new SelectFieldMonsterListener(monsterButton, this));
        setMonsterSelected(monsterButton);

        for(int i = 0; i < handButtonsList.size(); i++) {
            if(handButtonsList.get(i) == monsterCardButton.getCardSource()){
                playerPanel.getHandPanel().getHand().remove(handButtonsList.get(i));
                System.out.println(playerPanel.getHandPanel().getHand().getComponents().length);
            }
        }

        ArrayList<FieldCardButton> cardsOnField = playerPanel.getFieldPanel().getEmptySpotsOnField();
        int index = 0;
        for(int i = 0; i < cardsOnField.size(); i++){
            if(cardsOnField.get(i).isHighlighted()){
                index = cardsOnField.get(i).getIndex();
            }
        }
        monsterPanel.remove(index);
        monsterPanel.add(monsterButton, index);
        playerPanel.getFieldPanel().getMonsterCardsOnField().add(monsterButton);
        game.getPlayer().getField().getMonsters().add(monsterButton.getMonsterCard());
        monsterButton.setIndex(index);
        monsterPanel.revalidate();
        monsterPanel.repaint();
        return monsterButton;
    }

    public void endTurn(){
        game.getPlayer().endTurn();
        game.switchPlayer();
        String currentPlayer = game.getCurrentPlayer().getPlayerName();
        infoPanel.getCurrentPhasePanel().setText("<html>" + currentPlayer + "<br> MAIN PHASE 1 </html>");
        phaseControlPanel = new PhaseControlPanel(this);
        phaseControlPanel.setBounds(1180,620,140,105);
        this.add(phaseControlPanel);
    }


}

