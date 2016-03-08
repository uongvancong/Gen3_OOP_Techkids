import java.awt.*;
import java.awt.image.BufferedImage;

public  class GameObject {
    protected int positionX;
    protected int positionY;
    protected int speed;
    protected BufferedImage sprite;


    public GameObject(int positionX, int positionY, int speed) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.speed = speed;
    }

    public void draw(Graphics g){
        g.drawImage(this.sprite, this.positionX, this.positionY, null);
    }



    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
