package game;

abstract public class Card {
    private String owner;
    private String location;
    private Boolean faceDown;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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
}
