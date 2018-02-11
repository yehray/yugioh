package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

abstract public class Card {
    private String owner;
    private String name;
    private String location;
    private Boolean faceDown;
    private ImageIcon imageSmall;
    private ImageIcon imageLarge;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getFaceDown() {
        return faceDown;
    }

    public void setFaceDown(Boolean faceDown) {
        this.faceDown = faceDown;
    }

    public ImageIcon getImageSmall() {
        return new ImageIcon(this.getClass().getResource("/gui/resources/" + name + ".jpg"));
    }

    public ImageIcon getImageLarge() {
        return new ImageIcon(this.getClass().getResource("/gui/resources/" + name + " Large.jpg"));
    }



    public Card(){
        faceDown = true;
    }
}
