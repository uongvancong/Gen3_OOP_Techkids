/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author ADMIN
 */
public class GameObject {
    protected int x;
    protected int y;
    protected boolean isAlive;
    protected MoveBehavior moveBehavior;  
    protected int position ;

    public int getPosition() {
        return position;
    }
    protected int speed;

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
        this.isAlive = true;
    }
    
      public void performMove(){
        moveBehavior.move(this);
    }
    public void setMoveBehavior(MoveBehavior moveBehavior) {
        this.moveBehavior = moveBehavior;
    }
    
    public void setXY(int x, int y){
        this.x =x;
        this.y = y;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isIsAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
    
    
    
}
