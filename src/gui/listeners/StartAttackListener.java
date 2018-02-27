
package gui.listeners;


import gui.GUI;
import gui.MonsterButton;
import gui.exceptions.AlreadyAttackedException;
import gui.exceptions.WrongPhaseException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StartAttackListener extends MouseAdapter {
    private JLabel attackLabel;
    private GUI gui;
    private JPanel cardControlPanel;
    private JButton attackButton;
    private JButton defenseModeButton;
    private JButton executeAttackButton;
    private MonsterButton monsterButton;

    public StartAttackListener(GUI addedGUI, JButton atkButton, JButton dfsButton, MonsterButton addedMonsterButton){
        gui = addedGUI;
        cardControlPanel = gui.getCardControlPanel();
        attackButton = atkButton;
        defenseModeButton = dfsButton;
        monsterButton = addedMonsterButton;

        attackLabel = new JLabel("<html>SELECT<br> MONSTER TO<br> ATTACK</html>");
        attackLabel.setFont(new Font("Papyrus", Font.BOLD, 20));
        attackLabel.setForeground(Color.WHITE);
        attackLabel.setBounds(275,0, 200,400);

        executeAttackButton = new JButton("ATTACK");
        executeAttackButton.setBounds(275,40, 125,50);
        executeAttackButton.addMouseListener(new AttackListener(gui));
    }

    public void mouseClicked(MouseEvent e){
        if(gui.getGame().getCurrentPlayer().getField().getPhase() != "BATTLE PHASE"){
            JOptionPane.showMessageDialog(null, "Monster cannot attack if not in battle phase");
            throw new WrongPhaseException("Monster cannot attack if not in battle phase");
        }
        if(monsterButton.getMonsterCard().getHaveAttacked()){
            JOptionPane.showMessageDialog(null, "Monster cannot attack twice in a turn");
            throw new AlreadyAttackedException("Monster cannot attack twice in a turn");
        }
        if(gui.getOpponentPlayer().getFieldPanel().getEmptySpotsOnField().size() == 5){
            gui.getGame().getPlayer().attackDirectly(monsterButton.getMonsterCard(), gui.getGame().getOpponent());
            gui.getInfoPanel().getOpponentLifepointsPanel().setText("LIFEPOINTS: " + Integer.toString(gui.getGame().getOpponent().getLifepoints()));
        }
        else {
            gui.setMonsterSelected(monsterButton);
            cardControlPanel.remove(attackButton);
            cardControlPanel.remove(defenseModeButton);
            cardControlPanel.add(attackLabel);
            cardControlPanel.add(executeAttackButton);
            cardControlPanel.revalidate();
            cardControlPanel.repaint();
        }
    }
}

