package gui;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class GUI extends JFrame {

    private JLabel boardBackground;
    private PlayerPanel activePlayer;
    private PlayerPanel opponent;
    private JLabel activeLifePoints;
    private JLabel opponentLifePoints;
//    private JPanel cardImagePanel;




    public GUI(String p1, String p2){


        this.setTitle("Yu-Gi-Oh!");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        boardBackground = new JLabel(new ImageIcon((getClass().getResource("resources/yugiohFieldBackground.jpg"))));
        setSize(1366,768);

        JPanel cardImagePanel = new JPanel();
        cardImagePanel.setBounds(890,188,250,375);

        activePlayer = new PlayerPanel(p1, cardImagePanel);
        boardBackground.add(activePlayer);
        activePlayer.setBounds(0,400,1366,400);


        this.add(activePlayer);
        this.add(cardImagePanel);
        this.add(boardBackground);







        //        opponent = new PlayerPanel(p2);


//        this.add(opponent, BorderLayout.NORTH);


//        HandPanel handPanelP1 = new HandPanel();

//        HandPanel handPanelP2 = new HandPanel();

//        JPanel jPanel = new JPanel();
//



        this.setVisible(true);




//        activeLifePoints = new JLabel("Life Points");
//        activeLifePoints.setFont(new Font("Papyrus", Font.BOLD, 30));
//        activeLifePoints.setForeground(Color.LIGHT_GRAY);
//        opponentLifePoints = new JLabel("Life Points");
//        opponentLifePoints.setFont(new Font("Papyrus", Font.BOLD, 30));
//        opponentLifePoints.setForeground(Color.LIGHT_GRAY);
//        background.add(activeLifePoints);
//        background.add(opponentLifePoints);
//        activeLifePoints.setSize(150, 100);
//        activeLifePoints.setLocation(890, 198);




//        JLabel player1 = new JLabel("PLAYER 1 : "+ p1);
//        player1.setFont(new Font("Papyrus",Font.BOLD,20));
//        player1.setForeground(Color.LIGHT_GRAY);
//        JLabel player2 = new JLabel("PLAYER 2 : "+ p2);
//        player2.setFont(new Font("Papyrus",Font.BOLD,20));
//        player2.setForeground(Color.LIGHT_GRAY);
//        player1.setSize(200,30);
//        player2.setSize(200,30);
//        player1.setLocation(230, 390);
//        player2.setLocation(230, 290);
//        background.add(player1);
//        background.add(player2);


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
}

