/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Vector;

/**
 *
 * @author tuan anh le
 */
public class ShitManager {
    public static int ShitCost = 30;
    private Vector<Shit> shitVect;

    private ShitManager() {
        shitVect = new Vector<Shit>();
    }

    public Vector<Shit> getShitVect() {
        return shitVect;
    }

    public void addShit(Shit shit) {
        shitVect.add(shit);
        Game_State.point-=shit.cost;
    }
    private static ShitManager inst;

    public static ShitManager getInst() {
        if (inst == null) {
            inst = new ShitManager();            
        }
        return inst;
    }
    
}
