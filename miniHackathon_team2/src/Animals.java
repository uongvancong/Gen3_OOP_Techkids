import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by DuongPTIT14 on 3/6/2016.
 */
public abstract class Animals {
    protected BufferedImage sprite;
    protected String name;
    protected String color;
    protected int weight;
    protected int leg;
    protected String space;

    public abstract void sound();
    public abstract void move();
    public void display() {
        System.out.println("-----------------------------------------------");
        System.out.println("Name : " + this.name);
        System.out.println("Color :" + this.color);
        System.out.println("Weight : " + this.weight);
        System.out.println("Leg : " + this.leg);
        System.out.println("Space : " + this.space);
        this.sound();
        this.move();
        System.out.println("******************************************");
        System.out.println();
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}
