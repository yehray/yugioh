package game;

abstract public class Card {
    private String owner;
    private String location;
    private Boolean faceDown;

    public String getOwner() {
        return owner;
    }

    public String getLocation() {
        return location;
    }

    public Boolean getFaceDown() {
        return faceDown;
    }
}
