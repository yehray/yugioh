package gui.listeners;

import game.Game;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MonsterActionListener extends MouseAdapter {
    private Game currentGame;
    public MonsterActionListener(Game game){
        currentGame = game;
    }


    public void mouseClicked(MouseEvent e) {
        currentGame.getPlayer().attack();

    }
}
