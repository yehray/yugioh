package gui.listeners;

import game.Game;
import game.MonsterCard;
import game.Player;
import gui.DefenseMonsterButton;
import gui.FieldCardButton;
import gui.GUI;
import gui.RotatedIcon;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
        MonsterCard monster = gui.getMonsterSelected().getMonsterCard();
        monster.setMode("DEFENSE");
        
        game.getCurrentPlayer().switchMonsterMode(monster);
        RotatedIcon r1 = new RotatedIcon(monster.getImageSmall(), RotatedIcon.Rotate.DOWN);
        DefenseMonsterButton defenseModeButton = new DefenseMonsterButton(monster.getImageSmall(), monster);
        defenseModeButton.addMouseListener( new ShowLargerImage(gui.getCardControlPanel(), defenseModeButton.getMonsterCard()));
        defenseModeButton.addMouseListener(new SelectFieldMonsterListener(defenseModeButton, gui));

        int index = gui.getMonsterSelected().getIndex();
        JPanel monsterPanel = gui.getActivePlayer().getFieldPanel().getMonsterPanel();
        monsterPanel.remove(index);
        monsterPanel.add(defenseModeButton, index);

        defenseModeButton.repaint();
        defenseModeButton.revalidate();


    }
}


