package gui.listeners;

import game.Game;
import game.MonsterCard;
import game.Player;
import gui.*;
import gui.exceptions.WrongPhaseException;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DefenseModeListener extends MouseAdapter{
    boolean isFirstClick;
    private GUI gui;
    private Game game;
    public DefenseModeListener(GUI addedGUI){
        gui = addedGUI;
        game = gui.getGame();
        isFirstClick = true;
    }


    public void mouseClicked(MouseEvent e) {
        if(gui.getGame().getPlayer().getField().getPhase() == "BATTLE PHASE"){
            JOptionPane.showMessageDialog(null, "Cannot switch modes during battle phase");
            throw new WrongPhaseException("Cannot switch modes during battle phase");
        }
        else {
            MonsterCard monster = gui.getMonsterSelected().getMonsterCard();
            int index = gui.getMonsterSelected().getIndex();
            JPanel monsterPanel = gui.getActivePlayer().getFieldPanel().getMonsterPanel();
            monsterPanel.remove(index);
            if (monster.getMode() == "ATTACK") {
                game.getCurrentPlayer().switchMonsterMode(monster);
                RotatedIcon r1 = new RotatedIcon(monster.getImageSmall(), RotatedIcon.Rotate.DOWN);
                DefenseMonsterButton defenseModeButton = new DefenseMonsterButton(monster.getImageSmall(), monster);
                defenseModeButton.addMouseListener(new ShowLargerImage(gui.getCardControlPanel(), defenseModeButton.getMonsterCard()));
                defenseModeButton.addMouseListener(new SelectFieldMonsterListener(defenseModeButton, gui));

                monsterPanel.add(defenseModeButton, index);
                defenseModeButton.repaint();
                defenseModeButton.revalidate();
            } else {
                game.getCurrentPlayer().switchMonsterMode(monster);
                MonsterButton monsterButton = new MonsterButton(monster.getImageSmall(), monster);
                monsterButton.addMouseListener(new ShowLargerImage(gui.getCardControlPanel(), monster));
                monsterButton.addMouseListener(new SelectFieldMonsterListener(monsterButton, gui));

                monsterPanel.add(monsterButton, index);
                monsterPanel.repaint();
                monsterPanel.revalidate();
            }
        }
    }
}


