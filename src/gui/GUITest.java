package gui;

import game.Game;
import game.MonsterCard;
import game.Player;

import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class GUITest {
    public static void main(String args[]){
//        Game newGame = new Game();
//        newGame.startNewGame();
//        Player player = new Player("player", 8000);
//        newGame.createDeck(player, "/Users/yehray/IdeaProjects/yugioh/src/game/cards/YugiDeck.csv");
//        player.drawCard();
//        MonsterCard monsterCard = (MonsterCard) player.getDeck().getDeck().get(0);
//        System.out.println(monsterCard.getName());
        GUI gui = new GUI();
        gui.setGame();
        System.out.println(gui.getActivePlayer().getFieldPanel());


    }
}
