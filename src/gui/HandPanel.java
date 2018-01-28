package gui;

import game.Card;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class HandPanel extends JPanel{
    private ArrayList<HandButton> handButtons;
    private JPanel handPanel;

    OverlapLayout layout;


    public HandPanel(){
        JPanel handPanel = new JPanel();
        layout = new OverlapLayout(new Point(25, 0));
        layout.setPopupInsets(new Insets(15,10,0,0));
        handPanel.setLayout(layout);
        handButtons = new ArrayList<HandButton>();
        this.setLayout(new FlowLayout());
        this.add(handPanel);

        ImageIcon summonedSkull = new ImageIcon(this.getClass().getResource("resources/Summoned Skull.jpg"));
        HandButton addedCard = new HandButton(summonedSkull);


        ImageIcon darkMagician = new ImageIcon(this.getClass().getResource("resources/Dark Magician.jpg"));
        HandButton addedCard2 = new HandButton(darkMagician);

        ImageIcon mysticalElf = new ImageIcon(this.getClass().getResource("resources/Mystical Elf.jpg"));
        HandButton addedCard3 = new HandButton(mysticalElf);

        ImageIcon gaia = new ImageIcon(this.getClass().getResource("resources/Gaia the Fierce Knight.jpg"));
        HandButton addedCard4 = new HandButton(gaia);


        handPanel.add(addedCard);
        handPanel.add(addedCard2);
        handPanel.add(addedCard3);
        handPanel.add(addedCard4);




    }

    public void addButton(Card card){
        GetCardImage cardImage = new GetCardImage(card);
        HandButton addedCard = new HandButton(cardImage.getCardImage());
        handPanel.add(addedCard);
        handButtons.add(addedCard);
        addedCard.setVisible(true);
        addedCard.validate();

        addedCard.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println(addedCard.isFirstClick());
                if(addedCard.isFirstClick()){
                    addedCard.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
                    addedCard.setFirstClick(false);
                }
                else {
                    addedCard.setBorder(BorderFactory.createEmptyBorder());
                    addedCard.setFirstClick(true);
                }


            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Component c = e.getComponent();
                layout.addLayoutComponent(c, OverlapLayout.POP_UP);
                c.getParent().invalidate();
                c.getParent().validate();

            }

            @Override
            public void mouseExited(MouseEvent e) {
                Component c = e.getComponent();
                layout.addLayoutComponent(c, OverlapLayout.POP_DOWN);
                c.getParent().invalidate();
                c.getParent().validate();
            }
        });

    }

//    @Override
//    public void mouseClicked(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mousePressed(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseEntered(MouseEvent e) {
//        Component c = e.getComponent();
//        layout.addLayoutComponent(c, OverlapLayout.POP_UP);
//        c.getParent().invalidate();
//        c.getParent().validate();
//
//    }
//
//    @Override
//    public void mouseExited(MouseEvent e) {
//        Component c = e.getComponent();
//        layout.addLayoutComponent(c, OverlapLayout.POP_DOWN);
//        c.getParent().invalidate();
//        c.getParent().validate();
//    }
}
