package gui;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Window;

public class GUI extends JFrame {

    JLabel background;
    PlayerPanel activePlayer;
    PlayerPanel opponent;



    public GUI(String player1, String player2){
        setTitle("YU GI OH");
        background = new JLabel();
        setSize(1000,750);

        activePlayer = new PlayerPanel(player1);
        opponent = new PlayerPanel(player2);
    }



}

