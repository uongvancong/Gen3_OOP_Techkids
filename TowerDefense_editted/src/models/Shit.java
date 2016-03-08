/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author tuan anh le
 */
public class Shit extends GameObject{
    public int countCar = 0;
    public int cost;
    public Shit(int x, int y) {
        super(x, y);
        cost = ShitManager.ShitCost; 
    }
    
}
