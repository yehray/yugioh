package com.gui;

import com.game.*;

public class mainGUI {
    public static void main(String args[]){
//        Game newGame = new Game();
//        newGame.startNewGame();
//        Player player = new Player("player", 8000);
//        newGame.createDeck(player, "/Users/yehray/IdeaProjects/yugioh/src/com.game/cards/YugiDeck.csv");
//        player.drawCard();
//        MonsterCard monsterCard = (MonsterCard) player.getDeck().getDeck().get(0);
//        System.out.println(monsterCard.getName());

        GUI gui = new GUI();
        gui.setPlayers();
        gui.setPanels();
        gui.setGame(gui.getActivePlayer());
        gui.setGame(gui.getOpponentPlayer());
        gui.drawStartingHand();

        OpponentPlayerStrategy opponentPlayerStrategy = new OpponentPlayerStrategy(gui.getGame(), gui);
        gui.setOpponentPlayerStrategy();

//        JFrame newFrame = new JFrame();
//        newFrame.setSize(1000,1000);
//        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        JPanel test = new JPanel();
//        GridLayout layout = new GridLayout(1,5);
//        layout.setHgap(10);
//        test.setLayout(layout);
//        JButton[] buttons = new JButton[5];
//        for(int i = 0 ; i < 5 ; i++) {
//            test.add(buttons[i] = new JButton(Integer.toString(i)));
//        }
//
//
//        newFrame.add(test, BorderLayout.CENTER);
//        newFrame.setVisible(true);


    }
}
