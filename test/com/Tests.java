package com;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import com.game.Game;
import com.game.MonsterCard;
import com.game.Player;
import com.gui.DefenseMonsterButton;
import com.gui.exceptions.AlreadyAttackedException;
import com.gui.exceptions.DefenseModeException;
import com.gui.exceptions.WrongPhaseException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import javax.swing.*;
import java.util.ArrayList;

public class Tests {
    private Game game;

    @Before
    public void setUp() {
        Game newGame = new Game();
        game = newGame;
        game.startNewGame();
    }

    /**
     * Tests max hand size.
     */
    @Test
    public void handSizeTest() {
        game.getPlayer().drawCard();
        game.getPlayer().drawCard();
        game.getPlayer().drawCard();
        assertEquals(7, game.getPlayer().getHand().getCardsInHand().size());
    }

    /**
     * Tests if player is the winner.
     */
    @Test
    public void playerWinnerTest() {
        game.getPlayer().setLifepoints(8000);
        game.getOpponent().setLifepoints(0);
        game.getCurrentWinner();
        assertEquals(game.getPlayer().getPlayerName(), game.getWinner().getPlayerName());
    }

    /**
     * Tests if opponent is the winner.
     */
    @Test
    public void opponentWinnerTest() {
        game.getPlayer().setLifepoints(0);
        game.getOpponent().setLifepoints(8000);
        game.getCurrentWinner();
        assertEquals(game.getOpponent().getPlayerName(), game.getWinner().getPlayerName());
    }

    /**
     * Tests max number of monsters on field.
     */
    @Test
    public void maxMonstersOnFieldTest() {
        game.getPlayer().getField().setPhase("MAIN PHASE 1");
        ArrayList<MonsterCard> cardsInHand = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            cardsInHand.add(game.getPlayer().getHand().getCardsInHand().get(i));
        }

        for(int j = 0; j < cardsInHand.size(); j++) {
            MonsterCard card = cardsInHand.get(j);
            game.getPlayer().summonMonster(card);
        }
        assertEquals(5, game.getPlayer().getField().getMonsters().size());
    }

    /**
     * Tests monster attack.
     */
    @Test
    public void monsterAttackTest() {
        game.getPlayer().getField().setPhase("BATTLE PHASE");
        MonsterCard blueEyes = new MonsterCard("Blue Eyes White Dragon", 8, 3000, 2500);
        blueEyes.setMode("ATTACK");
        MonsterCard darkMagician = new MonsterCard("Dark Magician", 8, 2500, 2100);
        darkMagician.setMode("ATTACK");
        game.getPlayer().attack(blueEyes, darkMagician, game.getOpponent());
        assertEquals(7500, game.getOpponent().getLifepoints());
    }

    /**
     * Tests monster defense.
     */
    @Test
    public void monsterDefenseTest() {
        game.getPlayer().getField().setPhase("BATTLE PHASE");
        MonsterCard blueEyes = new MonsterCard("Blue Eyes White Dragon", 8, 3000, 2500);
        blueEyes.setMode("ATTACK");
        MonsterCard darkMagician = new MonsterCard("Dark Magician", 8, 2500, 2100);
        darkMagician.setMode("DEFENSE");
        game.getPlayer().attack(blueEyes, darkMagician, game.getOpponent());
        assertEquals(8000, game.getOpponent().getLifepoints());
    }

    /**
     * Tests monster attacking lifepoints directly.
     */
    @Test
    public void monsterDirectAttackTest() {
        game.getPlayer().getField().setPhase("BATTLE PHASE");
        MonsterCard blueEyes = new MonsterCard("Blue Eyes White Dragon", 8, 3000, 2500);
        blueEyes.setMode("ATTACK");
        game.getPlayer().attackDirectly(blueEyes, game.getOpponent());
        assertEquals(5000, game.getOpponent().getLifepoints());
    }

    /**
     * Tests monster switching into defense mode.
     */
    @Test
    public void monsterSwitchToDefenseTest() {
        game.getPlayer().getField().setPhase("MAIN PHASE 1");
        MonsterCard blueEyes = new MonsterCard("Blue Eyes White Dragon", 8, 3000, 2500);
        blueEyes.setMode("ATTACK");
        game.getPlayer().switchMonsterMode(blueEyes);
        assertEquals("DEFENSE", blueEyes.getMode());
    }

    /**
     * Tests battle phase exception.
     */
    @Test(expected = WrongPhaseException.class)
    public void wrongPhaseExceptionTest() {
        MonsterCard blueEyes = new MonsterCard("Blue Eyes White Dragon", 8, 3000, 2500);
        blueEyes.setMode("ATTACK");
        MonsterCard darkMagician = new MonsterCard("Dark Magician", 8, 2500, 2100);
        darkMagician.setMode("ATTACK");
        game.getPlayer().attack(blueEyes, darkMagician, game.getOpponent());
    }

    /**
     * Tests already attacked exception.
     */
    @Test(expected = AlreadyAttackedException.class)
    public void AlreadyAttackedExceptionTest() {
        game.getPlayer().getField().setPhase("BATTLE PHASE");
        MonsterCard blueEyes = new MonsterCard("Blue Eyes White Dragon", 8, 3000, 2500);
        blueEyes.setMode("ATTACK");
        MonsterCard darkMagician = new MonsterCard("Dark Magician", 8, 2500, 2100);
        darkMagician.setMode("ATTACK");
        game.getPlayer().attack(blueEyes, darkMagician, game.getOpponent());
        game.getPlayer().attack(blueEyes, darkMagician, game.getOpponent());
    }

    /**
     * Tests defense mode exception.
     */
    @Test(expected = DefenseModeException.class)
    public void DefenseModeExceptionTest() {
        game.getPlayer().getField().setPhase("BATTLE PHASE");
        MonsterCard blueEyes = new MonsterCard("Blue Eyes White Dragon", 8, 3000, 2500);
        blueEyes.setMode("DEFENSE");
        MonsterCard darkMagician = new MonsterCard("Dark Magician", 8, 2500, 2100);
        darkMagician.setMode("ATTACK");
        game.getPlayer().attack(blueEyes, darkMagician, game.getOpponent());
    }


}
