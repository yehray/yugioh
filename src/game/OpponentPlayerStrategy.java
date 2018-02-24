package game;

import gui.GUI;

public class OpponentPlayerStrategy {
    private Game game;
    private GUI gui;
    public OpponentPlayerStrategy(Game currentGame, GUI currentGUI){
        game = currentGame;
        gui = currentGUI;
        endTurn();

    }

    public void endTurn(){
        game.setCurrentPlayer(game.getPlayer());
        MonsterCard drawnCard = game.getCurrentPlayer().drawCard();
        gui.setActivePlayer(gui.getPlayer1());
        gui.setOpponent(gui.getPlayer2());
        gui.addToHand(drawnCard, gui.getActivePlayer());
    }
}
