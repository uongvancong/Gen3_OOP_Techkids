/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Vector;
import views.ViewConfig;
import views.ViewLocation;

/**
 *
 * @author ADMIN
 */
public class ItemManager {
    private Vector<Item> itemVect;

    private ItemManager() {
        itemVect = new Vector<>();
    }

    public Vector<Item> getItemVect() {
        return itemVect;
    }

    public void addItem(Item item) {
        itemVect.add(item);
    }
    private static ItemManager inst;

    public static ItemManager getInst() {
        if (inst == null) {
            inst = new ItemManager();
        }
        return inst;
    }
}

